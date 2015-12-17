package book;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class BookSection {
	private final String id;
	private final String title;
	private final List<String> paragraphs = Lists.newArrayList();
}
