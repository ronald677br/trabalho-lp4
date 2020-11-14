package Slide2.exercicioUm;

import java.util.ArrayList;
import java.util.List;

import Slide2.processors.ProcessorExUm;

public class ExercicioUm {
	private static final int N_THREADS = 100;
	
	public static void main(String[] args) {
		
		List<Thread> threads= new ArrayList<Thread>();
		
		for(int i = 0; i < N_THREADS; i++) {
			threads.add(new Thread(new ProcessorExUm(i)));
		}
		
		for(Thread t : threads) {
			t.start();
		}
			
	}
}
