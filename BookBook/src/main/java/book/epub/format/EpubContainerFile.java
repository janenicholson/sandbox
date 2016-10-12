package book.epub.format;

import book.BookModel;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContainerFile implements PersistableFile {
	@Getter private final String fileName = "META-INF/container.xml";
	private final EpubContainerElement data = new EpubContainerElement();

	@Override
	public byte[] formatContent(BookModel book) {
		return data.formatContent(book).getBytes();
	}
}
