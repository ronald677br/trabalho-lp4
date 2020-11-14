package Slide2.exercicioUm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Slide2.processors.ProcessorExTres;


public class ExercicioTres {
	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    } 

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		int randomLinha = getRandomNumberInRange(1, 100);
		int randomColuna = getRandomNumberInRange(1, 100);
		int[][] matriz = new int[randomLinha][randomColuna];
		List<ProcessorExTres> processors = new ArrayList<ProcessorExTres>();
		
		for (int i = 0; i < matriz.length; i++) {
			String linha = "";
			for (int j = 0; j < matriz[i].length; j++) {
				int randomN = getRandomNumberInRange(0, 10000);
				matriz[i][j] = randomN;
				linha += Integer.toString(randomN) + " ";
			}
			System.out.println(linha);
		}
		
		
		for (int i = 0; i < matriz.length; i++) {
			ProcessorExTres processor = new ProcessorExTres(i, matriz[i]); 
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
		int somaGlobal = 0;
		for (ProcessorExTres processor : processors) {
			somaGlobal += processor.getSoma();
		}
		System.out.println("Soma total: " + somaGlobal);
	}
}
