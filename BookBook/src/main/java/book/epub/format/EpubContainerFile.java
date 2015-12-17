package book.epub.format;

import book.BookModel;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContainerFile implements PersistableFile {
	@Getter private final String fileName = "META-INF/container.xml";
	private final EpubContainerElement data = new EpubContainerElement();

	@Override
	public byte[] formatContent(BookModel book) {
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\"?>\n");
		sb.append(data.formatContent(book));
		return sb.toString().getBytes();
	}
}
