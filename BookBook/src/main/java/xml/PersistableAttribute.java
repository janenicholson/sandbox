package xml;

import book.BookModel;

public abstract class PersistableAttribute {
	protected abstract String getName();
	protected abstract String getValue();
	public String formatContent(BookModel book) {
		return getName() + "=\"" + getValue(book)  + "\" ";
	}

	protected String getValue(BookModel book) {
		return getValue();
	}
}
