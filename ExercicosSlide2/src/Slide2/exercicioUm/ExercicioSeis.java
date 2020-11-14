package Slide2.exercicioUm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Slide2.processors.ProcessorExSeis;


public class ExercicioSeis {
	
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		List<ProcessorExSeis> processors = new ArrayList<ProcessorExSeis>();

		for (int i = 0; i < 3; i++) {
			ProcessorExSeis processor = new ProcessorExSeis(i); 
			processors.add(processor);
			threads.add(new Thread(processor));
		}

		for (Thread t : threads) {
			t.start();
		}
		
		for (Thread t : threads) {
		    try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(processors, (o1, o2) -> o1.getTickCount() - o2.getTickCount());
		int counter = 1;
		for (ProcessorExSeis processor : processors) {
			
			System.out.println(counter + " - Cavalo " + processor.getId() + " finalizou a corrida em " + processor.getTickCount() + " ticks.");
			counter++;
		}
	}
}
