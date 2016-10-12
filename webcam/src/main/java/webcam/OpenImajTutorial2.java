package webcam;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openimaj.image.DisplayUtilities.createNamedWindow;
import static org.openimaj.image.DisplayUtilities.display;
import static org.openimaj.image.ImageUtilities.readMBF;
import static org.openimaj.image.colour.ColourSpace.CIE_Lab;
import static org.openimaj.image.colour.ColourSpace.RGB;
import static org.openimaj.image.colour.ColourSpace.convert;
import static org.openimaj.image.typography.hershey.HersheyFont.TIMES_MEDIUM;
import static webcam.TutorialImages.KINDLE_URL;
import static webcam.TutorialImages.OPEN_IMAJ_SUPPLIED;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.openimaj.image.MBFImage;
import org.openimaj.image.connectedcomponent.GreyscaleConnectedComponentLabeler;
import org.openimaj.image.pixel.ConnectedComponent;
import org.openimaj.ml.clustering.FloatCentroidsResult;
import org.openimaj.ml.clustering.assignment.HardAssigner;
import org.openimaj.ml.clustering.kmeans.FloatKMeans;

public class OpenImajTutorial2 {

	private MBFImage input;
	private MBFImage convertedInput;
	private MBFImage clusteredInput;
	private MBFImage output;

	private FloatCentroidsResult centroids;

	public void run() {
		try {
			input = readMBF(OPEN_IMAJ_SUPPLIED.toURL());
			JFrame window = createNamedWindow("Open IMAJ tutorial 2");
			display(input, window);
			convertedInput = convert(input, CIE_Lab);
			SECONDS.sleep(1);
			display(convertedInput, window);
			centroids = cluster();
			reportCentroids();
			assignCentroids();
			SECONDS.sleep(1);
			display(clusteredInput, window);
			connectComponents();
			SECONDS.sleep(1);
			display(clusteredInput, window);
			output = convert(clusteredInput, RGB);
			SECONDS.sleep(3);
			display(output, window);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}

	}

	private FloatCentroidsResult cluster() {
		FloatKMeans cluster = FloatKMeans.createExact(2);
		return cluster.cluster(convertedInput.getPixelVectorNative(new float[convertedInput.getWidth() * convertedInput.getHeight()][3]));
	}

	private void reportCentroids() {
		for (float[] fs : centroids.centroids) {
			System.out.println(Arrays.toString(fs));
		}
	}

	private void assignCentroids() {
		clusteredInput = convertedInput.clone();
		HardAssigner<float[], ?, ?> assigner = centroids.defaultHardAssigner();
		for (int y = 0; y < clusteredInput.getHeight(); y++) {
			for (int x = 0; x < clusteredInput.getWidth(); x++) {
				float[] pixel = clusteredInput.getPixelNative(x, y);
				int centroid = assigner.assign(pixel);
				clusteredInput.setPixelNative(x, y, centroids.centroids[centroid]);
			}
		}
	}

	private void connectComponents() {
		GreyscaleConnectedComponentLabeler labeler = new GreyscaleConnectedComponentLabeler();
		List<ConnectedComponent> components = labeler.findComponents(clusteredInput.flatten());
		int i = 0;
		for (ConnectedComponent comp : components) {
			if (comp.calculateArea() < 50)
				continue;
			clusteredInput.drawText("Point:" + (i++), comp.calculateCentroidPixel(), TIMES_MEDIUM, 20);
		}
	}

}
