package book.epub.content;

import book.epub.PersistableFile;
import lombok.Getter;

public class EpubContentOpfFile implements PersistableFile {
	@Getter private final String fileName = "OEBPS/content.opf";

	@Override
	public byte[] getContent() {
		StringBuffer sb = new StringBuffer("<package xmlns=\"http://www.idpf.org/2007/opf\"\n");
		sb.append(" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n");
		sb.append(" unique-identifier=\"bookid\"\n");
		sb.append(" version=\"2.0\">\n");
		sb.append("  <metadata id=\"metadataid\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:opf=\"http://www.idpf.org/2007/opf\">\n");
		sb.append("    <dc:identifier id=\"bookid\" opf:scheme=\"ISBN\">id</dc:identifier>\n");
		sb.append("    <dc:language>en</dc:language>\n");
		sb.append("    <dc:title>en</dc:title>\n");
		sb.append("  </metadata>\n");
		sb.append("  <manifest>\n");
		sb.append("    <item href=\"toc.ncx\" id=\"tocid\" media-type=\"application/x-dtbncx+xml\"/>\n");
		sb.append("    <item href=\"chapter1.html\" id=\"chapter1\" media-type=\"application/xhtml+xml\"/>\n");
		sb.append("  </manifest>\n");
		sb.append("  <spine toc=\"tocid\">\n");
		sb.append("    <itemref idref=\"chapter1\" />\n");
		sb.append("  </spine>\n");
		sb.append("</package>\n");
		return sb.toString().getBytes();
	}
}
