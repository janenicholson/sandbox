package webcam;

import org.openimaj.image.MBFImage;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;

public class WebCamVideoListener implements VideoDisplayListener<MBFImage> {

	private MBFImage last;

	@Override
	public void afterUpdate(VideoDisplay<MBFImage> display) {
	}

	@Override
	public void beforeUpdate(MBFImage frame) {
		MBFImage swap = frame.clone();
		if (last != null) {
			frame.subtractInplace(last).abs();
		}
		last = swap;
	}

}
