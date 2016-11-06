package webcam;


import org.openimaj.video.VideoDisplay;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

public class WebCam {

	public static void main(String[] args) {
		try {
			// Access First Webcam
			VideoCapture cap = new VideoCapture(1280, 720);
			// Process Video
			VideoDisplay.createOffscreenVideoDisplay(cap).addVideoListener(new WebCamVideoListener());
		} catch (VideoCaptureException e) {
		}
	}
}
