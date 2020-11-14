package Slide2.exercicioUm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Slide2.processors.ThreadDivFive;
import Slide2.processors.ThreadImpar;
import Slide2.processors.ThreadPar;

public class ExercicioCinco {
	
	public static void main(String[] args) {
		ArrayList<Integer> listImpar = new ArrayList<Integer>();
		ArrayList<Integer> listPar = new ArrayList<Integer>();
		ArrayList<Integer> listDiv = new ArrayList<Integer>();
		
		int waits = 0;
		
		long startTime = System.currentTimeMillis();;
				
		for(int i = 1; i <= 5; i++) {
			ThreadImpar tImpar = new ThreadImpar();
			
			Thread threadImpar = new Thread(tImpar);
			ThreadPar threadPar = new ThreadPar();
			ThreadDivFive threadDivFive = new ThreadDivFive();
			
			
			threadImpar.start();
			threadPar.start();
			threadDivFive.start();
			
			try {
				threadImpar.join();
				threadPar.join();
				threadDivFive.join();
				
				if(tImpar.isWait() || threadPar.isWait() || threadDivFive.isWait()) {
					waits++;
				}
				
				if(tImpar.getNum() != -1) {
					listImpar.add(tImpar.getNum());
				}
				if(threadPar.getNum() != -1) {
					listPar.add(threadPar.getNum());
				}
				if(threadDivFive.getNum() != -1) {
					listDiv.add(threadDivFive.getNum());
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Impares: " + listImpar.toString());
		System.out.println("Pares: " + listPar.toString());
		System.out.println("Divisiveis: " + listDiv.toString());
		System.out.println("Esperas: " + waits);
		
		long endTime = System.currentTimeMillis();

		long duration = (endTime - startTime);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration); 
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		
		System.out.println("Tempo de Execução: " + hours + ":" + minutes + ":" + seconds);

	}
	
	
}
