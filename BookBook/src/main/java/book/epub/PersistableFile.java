package book.epub;

import book.BookModel;

public interface PersistableFile {
	String getFileName();
	byte[] formatContent(BookModel mode);
}
