package book.epub.format;

import book.epub.PersistableFile;
import lombok.Getter;

public class EpubNcxFile implements PersistableFile {

	@Getter private final String fileName = "OEBPS/toc.ncx";

	@Override
	public byte[] getContent() {
		StringBuffer sb = new StringBuffer("<ncx xmlns=\"http://www.daisy.org/z3986/2005/ncx/\" version=\"2005-1\">");
		sb.append("  <head>");
		sb.append("    <meta content=\"id\" name=\"dtb:uid\"/>");
		sb.append("  </head>");
		sb.append("  <docTitle>");
		sb.append("    <text />");
		sb.append("  </docTitle>");
		sb.append("  <navMap>");
		sb.append("    <navPoint id=\"chapter1\">");
		sb.append("      <navLabel>");
		sb.append("        <text>Chapter 1</text>");
		sb.append("      </navLabel>");
		sb.append("      <content src=\"chapter1.html\"/>");
		sb.append("    </navPoint>");
		sb.append("  </navMap>");
		sb.append("</ncx>");
		return sb.toString().getBytes();
	}

}
