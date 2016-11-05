package webcam;

import static webcam.TutorialImages.nap;
import static org.openimaj.image.ImageUtilities.readMBF;
import static webcam.TutorialImages.OPEN_IMAJ_QUERY;
import static webcam.TutorialImages.OPEN_IMAJ_TARGET;

import java.io.IOException;
import java.net.URI;

import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.BasicMatcher;
import org.openimaj.feature.local.matcher.FastBasicKeypointMatcher;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.feature.local.matcher.MatchingUtilities;
import org.openimaj.feature.local.matcher.consistent.ConsistentLocalFeatureMatcher2d;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.math.geometry.transforms.estimation.RobustAffineTransformEstimator;
import org.openimaj.math.model.fit.RANSAC;

public class OpenImajTutorial4 {

	private MBFImage query;
	private MBFImage target;
	private DoGSIFTEngine engine = new DoGSIFTEngine();
	private LocalFeatureMatcher<Keypoint> matcher;
	private RobustAffineTransformEstimator modelFitter;

	public void run() {
		query = loadImage(OPEN_IMAJ_QUERY);
		target = loadImage(OPEN_IMAJ_TARGET);
		findMatches();
		displayMatches();
		displayTarget();
	}

	private MBFImage loadImage(URI uri) {
		try {
			return readMBF(uri.toURL());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void findMatches() {
		LocalFeatureList<Keypoint> queryFeatures = engine.findFeatures(query.flatten());
		LocalFeatureList<Keypoint> targetFeatures = engine.findFeatures(target.flatten());
		matcher = new BasicMatcher<>(80);
		modelFitter = new RobustAffineTransformEstimator(5.0, 1500, new RANSAC.PercentageInliersStoppingCondition(0.5));
		matcher = new ConsistentLocalFeatureMatcher2d<>(new FastBasicKeypointMatcher<>(8), modelFitter);
		matcher.setModelFeatures(queryFeatures);
		matcher.findMatches(targetFeatures);
	}

	private void displayMatches() {
		MBFImage matches = MatchingUtilities.drawMatches(query, target, matcher.getMatches(), RGBColour.RED);
		DisplayUtilities.display(matches);
	}

	private void displayTarget() {
		target.drawShape(query.getBounds().transform(modelFitter.getModel().getTransform().inverse()), 3, RGBColour.BLUE);
		nap();
		DisplayUtilities.display(target);
	}
}
