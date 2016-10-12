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
import org.openimaj.image.processor.PrimitivePixelProcessor;
import org.openimaj.ml.clustering.FloatCentroidsResult;
import org.openimaj.ml.clustering.assignment.HardAssigner;
import org.openimaj.ml.clustering.kmeans.FloatKMeans;

public class OpenImajTutorial2 {

	private MBFImage input;
	private MBFImage convertedInput;
	private MBFImage clusteredInput;
	private MBFImage output;

	public void run() {
		try {
			input = readMBF(OPEN_IMAJ_SUPPLIED.toURL());
			JFrame window = createNamedWindow("Open IMAJ tutorial 2");
			display(input, window);
			convertedInput = convert(input, CIE_Lab);
			SECONDS.sleep(1);
			display(convertedInput, window);
			FloatCentroidsResult centroids = cluster();
			reportCentroids(centroids);
			assignCentroids(centroids);
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

	private void reportCentroids(FloatCentroidsResult centroids) {
		for (float[] fs : centroids.centroids) {
			System.out.println(Arrays.toString(fs));
		}
	}

	private void assignCentroids(FloatCentroidsResult centroids) {
		clusteredInput = convertedInput.clone();
		clusteredInput.processInplace(new Centroider(centroids));
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

	private static class Centroider extends PrimitivePixelProcessor {
		FloatCentroidsResult centroids;
		private HardAssigner<float[], ?, ?> assigner;

		public Centroider(FloatCentroidsResult centroids) {
			this.centroids = centroids;
			this.assigner = centroids.defaultHardAssigner();
		}

		@Override
		public float[] processPixel(float[] pixel) {
			return centroids.centroids[assigner.assign(pixel)];
		}
	}
}
