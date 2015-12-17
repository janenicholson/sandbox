package book.epub;

import com.google.common.collect.Lists;

import book.BookModel;
import book.BookSection;
import book.epub.format.EpubContainerFile;
import book.epub.format.EpubContentOpfFile;
import book.epub.format.EpubMimeTypeFile;
import book.epub.format.EpubNcxFile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class EpubFileFactory {

	public static EpubView create(String id) {
		return new EpubView(new EpubMimeTypeFile(), new EpubContainerFile(), new EpubContentOpfFile(), new EpubNcxFile(), Lists.<PersistableContentFile>newArrayList(new StubBookSectionView("chapter1")));
	}

	@RequiredArgsConstructor
	private static final class StubBookSectionView implements PersistableContentFile {
		@Getter private final String sectionId;

		@Override
		public String getFileName() {
			return "OEBPS/" + getSectionId() + ".html";
		}

		@Override
		public byte[] formatContent(BookModel book) {
			BookSection section = book.getBookSections().getSection(getSectionId());
			StringBuilder sb = new StringBuilder("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
			sb.append("<head><title>");
			sb.append(book.getTitle());
			sb.append("</title></head><body><h1>");
			sb.append(section.getTitle());
			sb.append("</h1>\n");
			for (String paragraph : section.getParagraphs()) {
				sb.append("<p>");
				sb.append(paragraph);
				sb.append("</p>\n");
			}
			sb.append("</body>\n");
			sb.append("</html>");
			return sb.toString().getBytes();
		}
	}
}
