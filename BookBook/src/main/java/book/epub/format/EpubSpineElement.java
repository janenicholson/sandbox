package book.epub.format;

import book.BookModel;

public class EpubSpineElement {
	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("  <spine toc=\"tocid\">\n");
		sb.append("    <itemref idref=\"chapter1\" />\n");
		sb.append("  </spine>\n");
		return sb.toString();
	}
}
