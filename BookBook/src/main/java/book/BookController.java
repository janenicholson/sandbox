package book;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookController {
	private final BookModel model;

	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	public void addContent(Object content) {
		model.getBookSections().add(transform(content));
	}

	private BookSection transform(Object content) {
		return new BookSection("chapter1", "Chapter One");
	}
}
