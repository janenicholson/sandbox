package book.epub.write;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.adobe.epubcheck.api.EpubCheck;

import book.epub.EpubFileFactory;

public class EpubFileWriterShould {

	@Test
	public void create_empty_epub_book() throws IOException {
		File file = File.createTempFile("test", ".epub");
		EpubFileWriter epubWriter = new EpubFileWriter(new FileOutputStream(file));
		try {
			epubWriter.write(EpubFileFactory.create());
			epubWriter.close();
			assertThat(new EpubCheck(file).validate(), is(equalTo(true)));
		} finally {
			file.delete();
		}
	}

}
