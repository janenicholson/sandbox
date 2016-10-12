package xml;

import java.util.List;

import book.BookModel;

public abstract class PersistableElement {
	protected abstract String getName();

	public String formatContent(BookModel book) {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + getName() + " ");
		for (PersistableAttribute attribute : getAttributes()) {
			sb.append(attribute.formatContent(book));
		}
		sb.append(">\n");
		for (PersistableElement child : getChildren())
			sb.append(child.formatContent(book));
		sb.append("</" + getName() + ">");
		return sb.toString();
	}

	protected abstract List<PersistableAttribute> getAttributes();
	protected abstract List<PersistableElement> getChildren();
}
