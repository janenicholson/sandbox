package book.epub.format;

import java.util.List;

import com.google.common.collect.Lists;

import book.BookModel;
import book.BookSection;
import lombok.Getter;
import xml.PersistableAttribute;
import xml.PersistableElement;

public class EpubManifestElement extends PersistableElement {
	@Getter private final String name = "manifest";
	@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList();
	@Getter private final List<PersistableElement> children = Lists.newArrayList();
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
