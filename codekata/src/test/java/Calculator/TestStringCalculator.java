package Calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void zeroParameter() {
		StringCalculator cal = new StringCalculator();
		String toBeAdded = "";
		int ans = cal.intAdd(toBeAdded);
		assertEquals(0,ans);
	}
}
