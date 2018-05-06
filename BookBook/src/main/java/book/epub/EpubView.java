package book.epub;

import java.util.List;

import book.epub.format.EpubContainerFile;
import book.epub.format.EpubContentOpfFile;
import book.epub.format.EpubMimeTypeFile;
import book.epub.format.EpubNcxFile;
import lombok.Data;

@Data
public class EpubView {
	private final EpubMimeTypeFile mimeType;
	private final EpubContainerFile containerFile;
	private final EpubContentOpfFile contentOpfFile;
	private final EpubNcxFile ncxFile;
	private final List<PersistableContentFile> epubData;
}
