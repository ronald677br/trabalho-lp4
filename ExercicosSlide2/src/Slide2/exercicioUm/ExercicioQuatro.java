package Slide2.exercicioUm;

import Slide2.processors.T1;

public class ExercicioQuatro {
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			Thread thread = new Thread(new T1(i));
			
			thread.start();
		}
	}
}
