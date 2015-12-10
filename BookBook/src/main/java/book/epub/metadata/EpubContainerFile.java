package book.epub.metadata;

import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContainerFile implements PersistableFile {
	@Getter private final String fileName = "META-INF/container.xml";

	@Override
	public byte[] getContent() {
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\"?>\n");
		sb.append("<container version=\"1.0\" xmlns=\"urn:oasis:names:tc:opendocument:xmlns:container\">\n");
		sb.append("<rootfiles>\n");
		sb.append("<rootfile full-path=\"OEBPS/content.opf\" media-type=\"application/oebps-package+xml\"/>\n");
		sb.append("</rootfiles>\n");
		sb.append("</container>\n");
		return sb.toString().getBytes();
	}
}
