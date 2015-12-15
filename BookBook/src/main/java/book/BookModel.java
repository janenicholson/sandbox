package book;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class BookModel {
	private final String isbn;
	private String author;
	private final List<BookSection> sections = Lists.newArrayList();
}
