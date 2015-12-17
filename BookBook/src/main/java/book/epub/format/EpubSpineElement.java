package book.epub.format;

import book.BookModel;
import book.BookSection;

public class EpubSpineElement {
	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("  <spine toc=\"tocid\">\n");
		for (BookSection section : book.getBookSections().getAll()) {
			sb.append("    <itemref idref=\"");
			sb.append(section.getId());
			sb.append("\" />\n");
		}
		sb.append("  </spine>\n");
		return sb.toString();
	}
}
