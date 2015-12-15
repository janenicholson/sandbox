package book.epub.format;

public class EpubManifestElement {
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		sb.append("  <manifest>\n");
		sb.append("    <item href=\"toc.ncx\" id=\"tocid\" media-type=\"application/x-dtbncx+xml\"/>\n");
		sb.append("    <item href=\"chapter1.html\" id=\"chapter1\" media-type=\"application/xhtml+xml\"/>\n");
		sb.append("  </manifest>\n");
		return sb.toString();
	}
}
