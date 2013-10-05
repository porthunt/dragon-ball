package System;

import java.util.Random;

public class IntRandom {

	public IntRandom(){
	}
	
	public int NumRandom (){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(41);
		return randomInt;
	}
	
}
