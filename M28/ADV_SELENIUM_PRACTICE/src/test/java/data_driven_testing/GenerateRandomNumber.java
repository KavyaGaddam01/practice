package data_driven_testing;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {

		// Generating random number
		Random random = new Random();
		int ranInt = random.nextInt(1000);
		System.out.println(ranInt);

	}

}
