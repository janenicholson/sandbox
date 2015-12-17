package book.epub.format;

import book.BookModel;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubMimeTypeFile implements PersistableFile {
	@Getter private final String fileName = "mimetype";

	public byte[] formatContent(BookModel book) {
		return "application/epub+zip".getBytes();
	}
}
