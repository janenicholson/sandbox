package webcam;

import static java.util.Optional.empty;
import static org.openimaj.image.ImageUtilities.FIMAGE_READER;
import static webcam.TutorialImages.FACES_PATH;
import static webcam.TutorialImages.IMAGE_PATH;
import static webcam.TutorialImages.nap;

import java.io.IOException;
import java.util.Optional;

import org.openimaj.data.dataset.VFSListDataset;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;

public class OpenImajTutorial5 {
	public void run() {
		Optional<VFSListDataset<FImage>> imageSet = loadImages(IMAGE_PATH);
		if (imageSet.isPresent()) {
			DisplayUtilities.display("My Images", imageSet.get());
		}
		nap();
		Optional<VFSListDataset<FImage>> faces = loadImages(FACES_PATH);
		if (faces.isPresent()) {
			DisplayUtilities.display("Faces", faces.get());
		}
	}

	private Optional<VFSListDataset<FImage>> loadImages(String uri) {
		try {
			return Optional.of(new VFSListDataset<>(uri, FIMAGE_READER));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empty();
	}
}
