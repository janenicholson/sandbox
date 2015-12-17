package xml;

import java.util.List;

import book.BookModel;

public interface PersistableElement {
	String getName();
	String formatContent(BookModel book);
	List<PersistableElement> getAttributes();
	List<PersistableElement> getChildren();
}
