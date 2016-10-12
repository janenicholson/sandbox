package webcam;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openimaj.image.DisplayUtilities.createNamedWindow;
import static org.openimaj.image.DisplayUtilities.display;
import static org.openimaj.image.ImageUtilities.readMBF;
import static org.openimaj.image.colour.RGBColour.BLACK;
import static org.openimaj.image.typography.hershey.HersheyFont.ASTROLOGY;
import static webcam.TutorialImages.OPEN_IMAJ_SUPPLIED;

import java.io.IOException;

import javax.swing.JFrame;

import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.edges.CannyEdgeDetector;
import org.openimaj.math.geometry.shape.Ellipse;

public class OpenImajTutorial1 {
	private static final int RGB_RED = 0;
	private static final int RGB_GREEN = 1;
	private static final int RGB_BLUE = 2;

	public void run() {
		try {
			MBFImage image = readMBF(OPEN_IMAJ_SUPPLIED.toURL());
			JFrame window = createNamedWindow("Open IMAJ tutorial 1");
			display(image, window);
			SECONDS.sleep(3);
			display(pinkFilter(image), window);
			SECONDS.sleep(3);
			MBFImage edgeFilteredImage = edgeFilter(image);
			display(edgeFilteredImage, window);
			SECONDS.sleep(3);
			display(speechBubbleFilter(edgeFilteredImage), window);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
	}

	private static MBFImage pinkFilter(MBFImage image) {
		MBFImage redFilteredImage = image.clone();
		for (int y = image.getHeight() - 1; y >= 0; y--) {
			for (int x = image.getWidth() - 1; x >= 0; x--) {
				redFilteredImage.getBand(RGB_BLUE).pixels[y][x] = 0;
				redFilteredImage.getBand(RGB_GREEN).pixels[y][x] = 0;
			}
		}
		redFilteredImage.getBand(RGB_BLUE).fill(1f);
		return redFilteredImage;
	}

	private static MBFImage edgeFilter(MBFImage image) {
		MBFImage edgeImage = image.clone();
		edgeImage.processInplace(new CannyEdgeDetector());
		return edgeImage;
	}

	private static MBFImage speechBubbleFilter(MBFImage image) {
		MBFImage speechBubbleImage = image.clone();
		drawWithOutline(speechBubbleImage, new Ellipse(700f, 450f, 20f, 10f, 0f));
		drawWithOutline(speechBubbleImage, new Ellipse(650f, 425f, 25f, 12f, 0f));
		drawWithOutline(speechBubbleImage, new Ellipse(600f, 380f, 30f, 15f, 0f));
		drawWithOutline(speechBubbleImage, new Ellipse(500f, 300f, 100f, 70f, 0f));
		speechBubbleImage.drawText("OpenIMAJ is", 425, 300, ASTROLOGY, 20, BLACK);
		speechBubbleImage.drawText("Awesome", 425, 330, ASTROLOGY, 20, BLACK);
		return speechBubbleImage;
	}

	private static void drawWithOutline(MBFImage speechBubbleImage, Ellipse ellipse) {
		speechBubbleImage.drawShapeFilled(ellipse, RGBColour.WHITE);
		speechBubbleImage.drawShape(ellipse, RGBColour.LIGHT_GRAY);
	}
}
