package book.epub.format;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import xml.PersistableAttribute;
import xml.PersistableElement;

public class EpubContainerElement extends PersistableElement {
	@Getter private final String name = "container";
	@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList(new EpubContainerVersionAttribute(), new EpubContainerNamespaceAttribute());
	@Getter private final List<PersistableElement> children = Lists.newArrayList(new EpubRootFilesElement());

	private static class EpubRootFilesElement extends PersistableElement {
		@Getter private final String name = "rootfiles";
		@Getter private final List<PersistableElement> children = Lists.newArrayList(new EpubRootFileElement());
		@Getter private final List<PersistableAttribute> attributes = Collections.emptyList();
	}

	private static class EpubRootFileElement extends PersistableElement {
		@Getter private final String name = "rootfile";
		@Getter private final List<PersistableElement> children = Collections.emptyList();
		@Getter private final List<PersistableAttribute> attributes = Lists.newArrayList(new EpubRootFilePathAttribute(), new EpubRootFileMediaTypeAttribute());
	}

	private static class EpubContainerVersionAttribute extends PersistableAttribute {
		@Getter private final String name = "version";
		@Getter private final String value = "1.0";
	}

	private static class EpubContainerNamespaceAttribute extends PersistableAttribute {
		@Getter private final String name = "xmlns";
		@Getter private final String value = "urn:oasis:names:tc:opendocument:xmlns:container";
	}

	private static class EpubRootFilePathAttribute extends PersistableAttribute {
		@Getter private final String name = "full-path";
		@Getter private final String value = "OEBPS/content.opf";
	}

	private static class EpubRootFileMediaTypeAttribute extends PersistableAttribute {
		@Getter private final String name = "media-type";
		@Getter private final String value = "application/oebps-package+xml";
	}
}
