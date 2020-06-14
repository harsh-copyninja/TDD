package Calculator;

public class StringCalculator {

	public int intAdd(String toBeAdded) {
		if (toBeAdded == "")
			return 0;
		return Integer.parseInt(toBeAdded);
	}

}
