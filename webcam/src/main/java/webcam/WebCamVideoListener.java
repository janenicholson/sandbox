package webcam;

import org.openimaj.image.MBFImage;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;

import lombok.Getter;

public class WebCamVideoListener implements VideoDisplayListener<MBFImage> {

	@Getter private MBFImage snapshot;
	@Getter private MBFImage diff;

	@Override
	public void afterUpdate(VideoDisplay<MBFImage> display) {
	}

	@Override
	public void beforeUpdate(MBFImage frame) {
		MBFImage swap = frame.clone();
		if (snapshot != null) {
			diff = frame.subtract(snapshot).abs();
		}
		snapshot = swap;
	}

}
