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
	public void emptyString() {
		String toBeAdded = "";
		assertSum(0,toBeAdded);
	}
	
	@Test
	public void oneNumber() {
		String toBeAdded = "1";
		assertSum(1,toBeAdded);
	}
	
	@Test
	public void twoNumbers() {
		String toBeAdded = "1,2";
		assertSum(3,toBeAdded);
	}
	
	@Test
	public void multipleNumbers() {
		String toBeAdded = "1,2,3,4,5,6";
		assertSum(21,toBeAdded);
	}
	
	@Test
	public void newLineDelimeter() {
		String toBeAdded = "1\n2,3";
		assertSum(6,toBeAdded);
	}
	
	@Test
	public void newDelimeter() {
		String toBeAdded = "//;\\n1;2";
		assertSum(3,toBeAdded);
	}
	
	private void assertSum(int expected,String toBeAdded) {
		int ans = cal.intAdd(toBeAdded);
		assertEquals(expected,ans);
	}
}
