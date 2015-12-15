package book.epub.format.write;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import com.adobe.epubcheck.api.EpubCheck;

import book.epub.EpubFileFactory;
import book.epub.format.write.EpubFileWriter;

public class EpubFileWriterShould {

	@Test
	public void create_empty_epub_book() throws IOException {
		String id = UUID.randomUUID().toString();
		File file = File.createTempFile(id, ".epub");
		EpubFileWriter epubWriter = new EpubFileWriter(new FileOutputStream(file));
		try {
			epubWriter.write(EpubFileFactory.create(id));
			epubWriter.close();
			assertThat(new EpubCheck(file).validate(), is(equalTo(true)));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			file.delete();
		}
	}

}
