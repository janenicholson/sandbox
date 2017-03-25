package webcam;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.net.URI;

public class TutorialImages {
	public static final URI OPEN_IMAJ_SUPPLIED = URI.create("http://static.openimaj.org/media/tutorial/sinaface.jpg");
	public static final URI KINDLE_URL = URI.create("https://lh3.googleusercontent.com/PNb_ojblUx24gwyLrQXphlWWYc0zsL0mSl9NMJjt3vtDxWkWNzmQo_lIghlQ8Tr3iC30PkjqjSXRktYd-SnKQtkZOJaFKYCx7rD3fIziSCZU0jSSTIuO2ZvFFP9eT55xPbdlboWkYr60dmhunl8KXyYjYpstIGLVnlVa0O39RjUDsmTeshg36k5NM2dauccLDGEwTdOvFznJzAEeN7_CYyEPlRQug2ZhaWusGBnLxWYsHtJVeKRyoa8j7eBzY_Qc8_7BY5O2h6QkS2fSNERGiC3Ns-ogKmHA_FMi2vZijY7BHUN68KKHFUZ_cIE5wUcwq8h27CRw0sli0N2QdbPdKiv7qIt4mkQcObcCyQ_LS6pyKih0IDKd7jMolYZJNxPHcMfBPO-QGcK0iiJpkjlrk3kPoRo8Q9sU4EF1ULvIOPYN9BMeQGtcwUuvrINNosZhapnLEx3g4Nq0p0ZIfD1ijVMIVfTKB-ZfkorkOlK3Fmz1TaNmdVutT2ySSaDC2sDcDNPKkbXN3rWdhl_Ct8wHkr5pPBXx1JS7aZOW1YCKJpih-TtbAWGGfFdMYntUGzqTPBQenhSUfoK_OXcGiUIQW2uVSxEQYB7l0pnszyiBJNmLMB7f=w1108-h1476-no");
	public static final URI OPEN_IMAJ_HISTOGRAM_BEACH = URI.create("http://users.ecs.soton.ac.uk/dpd/projects/openimaj/tutorial/hist1.jpg");
	public static final URI OPEN_IMAJ_HISTOGRAM_SHORE = URI.create("http://users.ecs.soton.ac.uk/dpd/projects/openimaj/tutorial/hist2.jpg");
	public static final URI OPEN_IMAJ_HISTOGRAM_MOON = URI.create("http://users.ecs.soton.ac.uk/dpd/projects/openimaj/tutorial/hist3.jpg");
	public static final URI OPEN_IMAJ_QUERY = URI.create("http://static.openimaj.org/media/tutorial/query.jpg");
	public static final URI OPEN_IMAJ_TARGET = URI.create("http://static.openimaj.org/media/tutorial/target.jpg");

	public static final String IMAGE_PATH = "/Users/jane/Code/sandbox/webcam/config/images";
	public static final String FACES_PATH = "zip:http://datasets.openimaj.org/att_faces.zip";

	public static void nap() {
		try {
			SECONDS.sleep(3);
		} catch (InterruptedException e) {
		}
	}
}
