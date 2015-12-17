package book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import book.epub.EpubFileFactory;
import book.epub.format.write.EpubFileWriter;

public class BookBook {

	public File createEpub(String id) throws IOException {
		File file = File.createTempFile(id, ".epub");
		EpubFileWriter writer = new EpubFileWriter(new FileOutputStream(file));
		try {
			writer.write(EpubFileFactory.create(id), new BookModel(id));
			writer.close();
		} catch (IOException e) {
			writer.close();
		}
		return file;
	}

}
