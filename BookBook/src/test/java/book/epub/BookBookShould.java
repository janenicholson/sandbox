package book.epub;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.adobe.epubcheck.api.EpubCheck;

import book.epub.BookBook;

public class BookBookShould {

	@Test
	public void create_a_valid_epub_file() throws IOException {
		File file = File.createTempFile("test", ".epub");
		BookBook application = new BookBook();
		File epubFile = application.createEpub(file.getName());
		EpubCheck checker = new EpubCheck(epubFile);
		assertThat(checker.validate(), is(equalTo(true)));
	}
}
