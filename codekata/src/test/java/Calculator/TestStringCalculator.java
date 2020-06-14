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
	
	@Test
	public void OneParameter() {
		StringCalculator cal = new StringCalculator();
		String toBeAdded = "1";
		int ans = cal.intAdd(toBeAdded);
		assertEquals(1,ans);
	}
}
