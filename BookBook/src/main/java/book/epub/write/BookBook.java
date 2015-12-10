package book.epub.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipFile;

import book.epub.EpubFileFactory;

public class BookBook {

	private ZipFile createFile(String name) throws IOException {
		File file = new File(name);
		EpubFileWriter writer = new EpubFileWriter(new FileOutputStream(file));
		try {
			writer.write(EpubFileFactory.create());
			return new ZipFile(file);
		} catch (IOException e) {
			writer.close();
			return new ZipFile(name);
		}
	}

	public File createEpub(String name) {
		try {
			createFile(name);
		} catch (IOException e) {
		}
		return new File(name);
	}

}
