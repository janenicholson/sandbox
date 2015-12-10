package book.epub;

import java.util.List;

import book.epub.content.EpubContentOpfFile;
import book.epub.content.EpubNcxFile;
import book.epub.metadata.EpubContainerFile;
import book.epub.metadata.EpubMimeTypeFile;
import lombok.Data;
import lombok.Getter;

@Data
public class EpubFile {
	@Getter private final EpubMimeTypeFile mimeType;
	@Getter private final EpubContainerFile containerFile;
	@Getter private final EpubContentOpfFile contentOpfFile;
	@Getter private final EpubNcxFile ncxFile;
	@Getter private final List<PersistableFile> epubData;
}
