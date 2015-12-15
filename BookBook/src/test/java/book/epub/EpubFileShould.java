package book.epub;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class EpubFileShould {

	@Test
	public void satisfy_equivalence_contract() {
		EqualsVerifier.forClass(EpubView.class).suppress(Warning.STRICT_INHERITANCE).verify();
	}

}
