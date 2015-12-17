package book.epub;

import java.util.List;

import book.epub.format.EpubContainerFile;
import book.epub.format.EpubContentOpfFile;
import book.epub.format.EpubMimeTypeFile;
import book.epub.format.EpubNcxFile;
import lombok.Data;
import lombok.Getter;

@Data
public class EpubView {
	@Getter private final EpubMimeTypeFile mimeType;
	@Getter private final EpubContainerFile containerFile;
	@Getter private final EpubContentOpfFile contentOpfFile;
	@Getter private final EpubNcxFile ncxFile;
	@Getter private final List<PersistableContentFile> epubData;
}
