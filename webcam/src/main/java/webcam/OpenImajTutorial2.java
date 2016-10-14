package webcam;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openimaj.image.DisplayUtilities.createNamedWindow;
import static org.openimaj.image.DisplayUtilities.display;
import static org.openimaj.image.ImageUtilities.readMBF;
import static org.openimaj.image.typography.hershey.HersheyFont.TIMES_MEDIUM;
import static webcam.TutorialImages.BEACH_URL;
import static webcam.TutorialImages.GRAIN_URL;
import static webcam.TutorialImages.KINDLE_URL;
import static webcam.TutorialImages.OPEN_IMAJ_SUPPLIED;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import org.openimaj.image.MBFImage;
import org.openimaj.image.pixel.ConnectedComponent;
import org.openimaj.image.segmentation.FelzenszwalbHuttenlocherSegmenter;
import org.openimaj.image.segmentation.SegmentationUtilities;

public class OpenImajTutorial2 {

	private MBFImage input;

	public void run() {
		try {
			input = readMBF(KINDLE_URL.toURL());
			JFrame window = createNamedWindow("Open IMAJ tutorial 2");
			display(input, window);
			connectComponents();
			SECONDS.sleep(1);
			display(input, window);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}

	}

	private void connectComponents() {
		FelzenszwalbHuttenlocherSegmenter<MBFImage> segmenter = new FelzenszwalbHuttenlocherSegmenter<MBFImage>();
		List<ConnectedComponent> components = segmenter.segment(input);
		int i = 0;
		for (ConnectedComponent comp : components) {
			if (comp.calculateArea() < 50)
				continue;
			input.drawText("Point:" + (i++), comp.calculateCentroidPixel(), TIMES_MEDIUM, 20);
		}
		SegmentationUtilities.renderSegments(input, components);
	}
}
