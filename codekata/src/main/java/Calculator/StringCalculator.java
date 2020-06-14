package Calculator;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		int sum = 0;
		String nums[] = toBeAdded.split(",");
		for (String num : nums) {
			sum+=parseInt(num);
		}
		return sum;
	}
	
	private int parseInt(String num) {
		if(num == "") {
			return 0;
		}
		return Integer.parseInt(num);
	}

}
