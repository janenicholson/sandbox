package book.epub.metadata;

import book.epub.PersistableFile;
import lombok.Getter;

public class EpubMimeTypeFile implements PersistableFile {
	@Getter private final String fileName = "mimetype";
	@Getter private final byte[] content = "application/epub+zip".getBytes();
}
