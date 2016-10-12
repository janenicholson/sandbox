package book.epub.format;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import book.BookModel;
import book.BookSection;
import lombok.Getter;
import xml.PersistableAttribute;
import xml.PersistableElement;

public class EpubSpineElement extends PersistableElement {
	@Getter private final String name = "spine";
	@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList(new EpubTocAttribute());
	@Getter private final List<PersistableElement> children = Lists.newArrayList(new MultiChildElement());

	private static class EpubTocAttribute extends PersistableAttribute {
		@Getter private final String name = "toc";
		@Getter private final String value = "tocid";
	}

	private static class MultiChildElement extends PersistableElement {
		@Getter private final String name = "itemref";
		@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList();
		@Getter private final List<PersistableElement> children = Collections.emptyList();
		@Override
		public String formatContent(BookModel book) {
			StringBuilder sb = new StringBuilder();
			for (BookSection section : book.getBookSections().getAll()) {
				sb.append("    <itemref idref=\"");
				sb.append(section.getId());
				sb.append("\" />\n");
			}
			return sb.toString();
		}
	}
}
