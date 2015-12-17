package book.epub.format;

import book.BookModel;
import book.BookSection;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubNcxFile implements PersistableFile {

	@Getter private final String fileName = "OEBPS/toc.ncx";

	@Override
	public byte[] formatContent(BookModel book) {
		StringBuffer sb = new StringBuffer("<ncx xmlns=\"http://www.daisy.org/z3986/2005/ncx/\" version=\"2005-1\">");
		sb.append("  <head>");
		sb.append("    <meta content=\"id\" name=\"dtb:uid\"/>");
		sb.append("  </head>");
		sb.append("  <docTitle>");
		sb.append("    <text />");
		sb.append("  </docTitle>");
		sb.append("  <navMap>");
		for (BookSection section : book.getBookSections().getAll()) {
			sb.append("    <navPoint id=\"");
			sb.append(section.getId());
			sb.append("\">");
			sb.append("      <navLabel>");
			sb.append("        <text>");
			sb.append(section.getTitle());
			sb.append("</text>");
			sb.append("      </navLabel>");
			sb.append("      <content src=\"");
			sb.append(section.getId());
			sb.append(".html\"/>");
			sb.append("    </navPoint>");
		}
		sb.append("  </navMap>");
		sb.append("</ncx>");
		return sb.toString().getBytes();
	}

}
