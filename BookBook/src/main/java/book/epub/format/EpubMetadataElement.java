package book.epub.format;

import java.util.List;

import com.google.common.collect.Lists;

import book.BookModel;
import lombok.Getter;
import xml.PersistableAttribute;
import xml.PersistableElement;

public class EpubMetadataElement extends PersistableElement {
	@Getter private final String name = "metadata";
	@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList();
	@Getter private final List<PersistableElement> children = Lists.newArrayList();

	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("  <metadata id=\"metadataid\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:opf=\"http://www.idpf.org/2007/opf\">\n");
		sb.append("    <dc:identifier id=\"");
		sb.append(book.getId());
		sb.append("\" opf:scheme=\"ISBN\">id</dc:identifier>\n");
		sb.append("    <dc:language>en</dc:language>\n");
		sb.append("    <dc:title>");
		sb.append(book.getTitle());
		sb.append("</dc:title>\n");
		sb.append("    <dc:creator>");
		sb.append(book.getAuthor());
		sb.append("</dc:creator>\n");
		sb.append("  </metadata>\n");
		return sb.toString();
	}
}
