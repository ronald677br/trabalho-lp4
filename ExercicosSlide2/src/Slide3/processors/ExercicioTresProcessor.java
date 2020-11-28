package Slide3.processors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExercicioTresProcessor implements Runnable{
	private int prioridade;
	
	
	public ExercicioTresProcessor(int prioridade) {
		this.prioridade = prioridade;
	}
	
	@Override
	public void run() {
		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");  
			System.out.println("Rodei em " + dtf.format(now) + " com prioridade " + this.getPrioridade());
			Thread.currentThread().setPriority(this.getPrioridade());
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}	
	}

	public int getPrioridade() {
		return prioridade;
	}

	
}
