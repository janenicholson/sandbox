package book.epub.format;

import book.BookModel;
import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContentOpfFile implements PersistableFile {
	@Getter private final String fileName = "OEBPS/content.opf";
	private final EpubMetadataElement metadataElement = new EpubMetadataElement();
	private final EpubManifestElement manifestElement = new EpubManifestElement();
	private final EpubSpineElement spineElement = new EpubSpineElement();

	@Override
	public byte[] formatContent(BookModel book) {
		StringBuffer sb = new StringBuffer("<package xmlns=\"http://www.idpf.org/2007/opf\"\n");
		sb.append(" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n");
		sb.append(" unique-identifier=\"");
		sb.append(book.getId());
		sb.append("\"\n");
		sb.append(" version=\"2.0\">\n");
		sb.append(metadataElement.formatContent(book));
		sb.append(manifestElement.formatContent(book));
		sb.append(spineElement.formatContent(book));
		sb.append("</package>\n");
		return sb.toString().getBytes();
	}
}
