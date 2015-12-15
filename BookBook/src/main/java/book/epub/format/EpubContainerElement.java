package book.epub.format;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import xml.PersistableElement;

public class EpubContainerElement implements PersistableElement {
	@Getter private final String name = "container";
	@Getter private final String content = "<container version=\"1.0\" xmlns=\"urn:oasis:names:tc:opendocument:xmlns:container\">\n"
			+ "<rootfiles>\n"
			+ "<rootfile full-path=\"OEBPS/content.opf\" media-type=\"application/oebps-package+xml\"/>\n"
			+ "</rootfiles>\n"
			+ "</container>";
	@Getter private final List<PersistableElement> children = Collections.emptyList();
	@Getter private final List<PersistableElement> attributes = Collections.emptyList();
}
