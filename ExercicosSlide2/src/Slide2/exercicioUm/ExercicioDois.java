package Slide2.exercicioUm;

import Slide2.processors.ProcessorExDois;

public class ExercicioDois {
	
	public static void main (String[] args) {
		String[] news = {
				"Noticia 1",
				"Noticia 2",
				"Noticia 3",
				"Noticia 4",
				"Noticia 5"
		};
		
		Thread threadUm = new Thread(new ProcessorExDois(1, news));
		Thread threadDois = new Thread(new ProcessorExDois(2, news));
		threadUm.start();
		threadDois.start();
		
	}
	
	
}
