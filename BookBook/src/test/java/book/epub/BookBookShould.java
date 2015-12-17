package book.epub;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import com.adobe.epubcheck.api.EpubCheck;

import book.BookBook;

public class BookBookShould {

	@Test
	public void create_a_valid_epub_file() throws IOException {
		BookBook application = new BookBook();
		File epubFile = application.createEpub("X"+UUID.randomUUID().toString());
		EpubCheck checker = new EpubCheck(epubFile);
		assertThat(checker.validate(), is(equalTo(true)));
	}
}
