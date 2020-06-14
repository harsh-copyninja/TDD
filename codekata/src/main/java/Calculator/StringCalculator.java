package Calculator;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		if (toBeAdded == "")
			return 0;
		String nums[] = toBeAdded.split(",");
		if (nums.length == 1)
			return parseInt(nums[0]);
		return parseInt(nums[0])+parseInt(nums[1]);
	}
	
	private int parseInt(String num) {
		return Integer.parseInt(num);
	}

}
