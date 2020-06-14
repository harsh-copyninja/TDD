package Calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {

	private StringCalculator cal;
	
	@Before
	public void setUp() {
		cal = new StringCalculator();
	}
	
	@Test
	public void zeroParameter() {
		String toBeAdded = "";
		assertSum(0,toBeAdded);
	}
	
	@Test
	public void OneParameter() {
		String toBeAdded = "1";
		assertSum(1,toBeAdded);
	}
	
	private void assertSum(int expected,String toBeAdded) {
		int ans = cal.intAdd(toBeAdded);
		assertEquals(expected,ans);
	}
}
