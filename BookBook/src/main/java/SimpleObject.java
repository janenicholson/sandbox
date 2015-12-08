import java.util.Objects;

import lombok.Getter;

public class SimpleObject {
	@Getter final int value;
	
	public SimpleObject(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SimpleObject && typeSafeEquals((SimpleObject)obj);
	}

	protected boolean typeSafeEquals(SimpleObject obj) {
		return value == obj.getValue();
	}
}
