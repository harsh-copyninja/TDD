package Calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import Exception.NegativeNumberFoundException;

public class TestStringCalculator {

	private StringCalculator cal;
	
	@Before
	public void setUp() {
		cal = new StringCalculator();
	}
	
	@Test
	public void emptyString()  throws Exception{
		String toBeAdded = "";
		assertSum(0,toBeAdded);
	}
	
	@Test
	public void oneNumber()  throws Exception{
		String toBeAdded = "1";
		assertSum(1,toBeAdded);
	}
	
	@Test
	public void twoNumbers()  throws Exception{
		String toBeAdded = "1,2";
		assertSum(3,toBeAdded);
	}
	
	@Test
	public void multipleNumbers()  throws Exception{
		String toBeAdded = "1,2,3,4,5,6";
		assertSum(21,toBeAdded);
	}
	
	@Test
	public void newLineDelimeter()  throws Exception{
		String toBeAdded = "1\n2,3";
		assertSum(6,toBeAdded);
	}
	
	@Test
	public void newDelimeter()  throws Exception{
		String toBeAdded = "//;\n1;2\n3";
		assertSum(6,toBeAdded);
	}
	
	@Test
	public void numberOfTimesAddCalled()  throws Exception{
		String toBeAdded = "//;\n1;2\n3";
		for(int i = 1;i<=10;i++) {
			int temp = cal.intAdd(toBeAdded);
			assertEquals(i,cal.GetCalledCount());
		}
	}
	
	@Test
	public void exceptionShouldDisplayNegatives() {
		String toBeAdded = "//;\n1;-2;3;-4;-5";
		try {
			int ans = cal.intAdd(toBeAdded);
			assertFalse(true);
		}catch (NegativeNumberFoundException ex) {
			assertEquals(ex.getMessage(),"negatives not allowed: -2 -4 -5");
		}
	}
	
	@Test
	public void numberGreaterThan1000ShouldBeIgnored()  throws Exception{
		String toBeAdded = "//;\n1;1001\n3";
		assertSum(4,toBeAdded);
	}
	
	@Test
	public void delimetersCanBeOfAnyLength()  throws Exception{
		String toBeAdded = "//[***]\n1***2***3";
		assertSum(6,toBeAdded);
	}
	
	@Test
	public void multipleDelimeters()  throws Exception{
		String toBeAdded = "//[*][%]\n1*2%3";
		assertSum(6,toBeAdded);
	}
	
	private void assertSum(int expected,String toBeAdded) throws Exception{
		int ans = cal.intAdd(toBeAdded);
		assertEquals(expected,ans);
	}
}
