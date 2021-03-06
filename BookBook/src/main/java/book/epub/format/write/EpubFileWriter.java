package book.epub.format.write;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import book.BookModel;
import book.epub.EpubView;
import book.epub.PersistableFile;
import book.epub.format.EpubMimeTypeFile;

public class EpubFileWriter implements Closeable, Flushable {
	private final ZipOutputStream out;

	public EpubFileWriter(FileOutputStream out) {
		this.out = new ZipOutputStream(out);
	}

	public void write(EpubView epub, BookModel book) throws IOException {
		addMimeType(epub.getMimeType());
		addContent(epub.getContainerFile(), book);
		addContent(epub.getContentOpfFile(), book);
		addContent(epub.getNcxFile(), book);
		for (PersistableFile file : epub.getEpubData())
			addContent(file, book);
	}

	private void addMimeType(EpubMimeTypeFile mimeType) throws IOException {
		addUncompressedZipEntry(mimeType.getFileName(), mimeType.formatContent(null));
	}

	private void addUncompressedZipEntry(String fileName, byte[] content) throws IOException {
		out.setLevel(ZipEntry.STORED);
		out.putNextEntry(new UncompressedZipEntry(fileName, content));
		out.write(content);
		out.closeEntry();
	}
	
	private void addContent(PersistableFile file, BookModel book) throws IOException {
		addZipEntry(file.getFileName(), file.formatContent(book));
	}

	private void addZipEntry(String fileName, byte[] content) throws IOException {
		out.putNextEntry(new ZipEntry(fileName));
		out.write(content);
		out.closeEntry();
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void close() throws IOException {
		out.close();
	}

	private static class UncompressedZipEntry extends ZipEntry {
		private final CRC32 crc = new CRC32();
		public UncompressedZipEntry(String fileName, byte[] content) {
			super(fileName);
			crc.update(content);
			setMethod(ZipEntry.STORED);
			setCompressedSize(content.length);
			setSize(content.length);
			setCrc(crc.getValue());
		}
	}
}
