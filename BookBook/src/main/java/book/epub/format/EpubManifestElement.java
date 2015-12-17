package book.epub.format;

import book.BookModel;
import book.BookSection;

public class EpubManifestElement {
	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("  <manifest>\n");
		sb.append("    <item href=\"toc.ncx\" id=\"tocid\" media-type=\"application/x-dtbncx+xml\"/>\n");
		for (BookSection section : book.getBookSections().getAll()) {
			sb.append("    <item href=\"");
			sb.append(section.getId());
			sb.append(".html\" id=\"");
			sb.append(section.getId());
			sb.append("\" media-type=\"application/xhtml+xml\"/>\n");
		}
		sb.append("  </manifest>\n");
		return sb.toString();
	}
}
