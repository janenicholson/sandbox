package webcam;

import static org.openimaj.image.ImageUtilities.readMBF;
import static webcam.TutorialImages.OPEN_IMAJ_HISTOGRAM_BEACH;
import static webcam.TutorialImages.OPEN_IMAJ_HISTOGRAM_MOON;
import static webcam.TutorialImages.OPEN_IMAJ_HISTOGRAM_SHORE;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.openimaj.feature.DoubleFVComparison;
import org.openimaj.image.pixel.statistics.HistogramModel;
import org.openimaj.math.statistics.distribution.MultidimensionalHistogram;

import com.google.common.collect.Lists;

public class OpenImajTutorial3 {

	private URI[] uris = new URI[] {
			OPEN_IMAJ_HISTOGRAM_BEACH,
			OPEN_IMAJ_HISTOGRAM_SHORE,
			OPEN_IMAJ_HISTOGRAM_MOON
	};

	public void run() {
		List<MultidimensionalHistogram> histograms = createHistograms();
		compareHistograms(histograms);
	}

	private List<MultidimensionalHistogram> createHistograms() {
		try {
			List<MultidimensionalHistogram> histograms = Lists.newArrayList();
			HistogramModel model = new HistogramModel(4, 4, 4);
			for (URI uri : uris) {
				model.estimateModel(readMBF(uri.toURL()));
				histograms.add(model.histogram.clone());
			}
			return histograms;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void compareHistograms(List<MultidimensionalHistogram> histograms) {
		for (MultidimensionalHistogram histogram1 : histograms) {
			for (MultidimensionalHistogram histogram2 : histograms) {
				double difference = histogram1.compare(histogram2, DoubleFVComparison.EUCLIDEAN);
				System.out.println(difference);
			}
		}
	}
}
