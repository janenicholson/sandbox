import static org.junit.Assert.*;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class SimpleObjectTest {

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(SimpleObject.class).suppress(Warning.STRICT_INHERITANCE).verify();
	}

}
