package book.epub.format;

import book.BookModel;

public class EpubMetadataElement {
	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("  <metadata id=\"metadataid\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:opf=\"http://www.idpf.org/2007/opf\">\n");
		sb.append("    <dc:identifier id=\"bookid\" opf:scheme=\"ISBN\">id</dc:identifier>\n");
		sb.append("    <dc:language>en</dc:language>\n");
		sb.append("    <dc:title>en</dc:title>\n");
		sb.append("  </metadata>\n");
		return sb.toString();
	}
}
