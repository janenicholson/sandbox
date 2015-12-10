package book.epub.metadata;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import xml.PersistableElement;

public class EpubContainerElement implements PersistableElement {
	@Getter private final String name = "container";
	@Getter private final String content = "";
	@Getter private final List<PersistableElement> children = Collections.emptyList();
	@Getter private final List<PersistableElement> attributes = Collections.emptyList();
}
