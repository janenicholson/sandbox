package book.epub.format;

import java.util.List;

import com.google.common.collect.Lists;

import book.BookModel;
import lombok.Getter;
import xml.PersistableAttribute;
import xml.PersistableElement;

public class EpubContentElement extends PersistableElement {
	@Getter private final String name = "package";
	@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList(new EpubOpfNamespaceAttribute(), new EpubDCNamespaceAttribute(), new EpubUidAttribute(), new EpubVersionElement());
	@Getter private final List<PersistableElement> children = Lists.newArrayList(new EpubMetadataElement(), new EpubManifestElement(), new EpubSpineElement());

	private static class EpubOpfNamespaceAttribute extends PersistableAttribute {
		@Getter private final String name = "xmlns";
		@Getter private final String value = "http://www.idpf.org/2007/opf";
	}

	private static class EpubDCNamespaceAttribute extends PersistableAttribute {
		@Getter private final String name = "xmlns:dc";
		@Getter private final String value = "http://purl.org/dc/elements/1.1/";
	}

	private static class EpubUidAttribute extends PersistableAttribute {
		@Getter private final String name = "unique-identifier";

		@Override
		protected String getValue(BookModel book) {
			return book.getId();
		}

		@Override
		protected String getValue() {
			throw new RuntimeException("Not allowed out of context");
		}
		
	}

	private static class EpubVersionElement extends PersistableAttribute {
		@Getter private final String name = "version";
		@Getter private final String value = "2.0";
	}
}
