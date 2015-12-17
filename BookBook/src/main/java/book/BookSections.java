package book;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class BookSections {
	private final List<BookSection> sections = Lists.newArrayList(new BookSection("chapter1", "Chapter One"));

	public BookSection getSection(String sectionId) {
		List<BookSection> potentialMatches = sections.stream()
				.filter((section) -> section.getId().equals(sectionId))
				.collect(Collectors.toList());
		if (potentialMatches.size() == 1)
			return potentialMatches.get(0);
		return null;
	}

	public void add(BookSection section) {
		sections.add(section);
	}

	public List<BookSection> getAll() {
		return Collections.unmodifiableList(sections);
	}
}
