package Slide3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Slide2.processors.ProcessorExTres;
import Slide3.processors.ExercicioTresProcessor;

public class Exercicio3 {
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		
		Scanner scanner = new Scanner(System.in); // Create a Scanner object
		System.out.println("Digite a quantidade de threads");
		
		List<ExercicioTresProcessor> processors = new ArrayList<ExercicioTresProcessor>();

		String input = scanner.nextLine();
		int threadCount = Integer.parseInt(input);

		ExecutorService application = Executors.newFixedThreadPool(threadCount);
		for (int i = 0; i < threadCount; i++) {
			int prioridade = getRandomNumberInRange(1, 10);
			ExercicioTresProcessor processor = new ExercicioTresProcessor(prioridade);
			processors.add(processor);
		}

		Collections.sort(processors, (o1, o2) -> o1.getPrioridade() - o2.getPrioridade());

		for (ExercicioTresProcessor processor : processors) {
			Thread thread = new Thread(processor);
			threads.add(thread);
			thread.start();
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
