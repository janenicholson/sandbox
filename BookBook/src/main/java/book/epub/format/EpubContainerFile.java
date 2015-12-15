package book.epub.format;

import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContainerFile implements PersistableFile {
	@Getter private final String fileName = "META-INF/container.xml";
	private final EpubContainerElement data = new EpubContainerElement();

	@Override
	public byte[] getContent() {
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\"?>\n");
		sb.append(data.getContent());
		return sb.toString().getBytes();
	}
}
