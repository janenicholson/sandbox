package book;

import lombok.Data;

@Data
public class BookModel {
	private final String id;
	private String isbn;
	private String author;
	private String title;
	private final BookSections bookSections = new BookSections();
}
