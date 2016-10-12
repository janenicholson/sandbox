package book.epub.format;

import book.BookModel;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContentOpfFile implements PersistableFile {
	@Getter private final String fileName = "OEBPS/content.opf";
	private final EpubContentElement packageElement = new EpubContentElement();

	public byte[] formatContent(BookModel book) {
		return packageElement.formatContent(book).getBytes();
	}
}
