package xml;

import java.util.List;

public interface PersistableElement {
	String getName();
	String getContent();
	List<PersistableElement> getAttributes();
	List<PersistableElement> getChildren();
}
