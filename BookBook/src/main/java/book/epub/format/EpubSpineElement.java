package book.epub.format;

public class EpubSpineElement {
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		sb.append("  <spine toc=\"tocid\">\n");
		sb.append("    <itemref idref=\"chapter1\" />\n");
		sb.append("  </spine>\n");
		return sb.toString();
	}
}
