package Slide2.processors;

import java.util.Random;

public class ProcessorExSeis implements Runnable{
	private int id;
	private int tamanhoCorrida = 1000;
	private int distanciaPercorrida = 0;
	private int tickCountUntilFinish = 0;

	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    } 

	
	public ProcessorExSeis(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		try {
			while (this.getDistanciaPercorrida() < tamanhoCorrida) {
				Thread.sleep(30);
				this.setDistanciaPercorrida(this.getDistanciaPercorrida() + getRandomNumberInRange(1, 10));
				System.out.println("Cavalo " + this.getId() + " percorreu " + this.getDistanciaPercorrida() + "m");
				this.tickCountUntilFinish++;
				if (this.getDistanciaPercorrida() >= this.tamanhoCorrida) {
					System.out.println("Cavalo " + this.getId() + " finalizou a corrida em " + this.getTickCount() + " ticks");
				}
			}
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}
	
	public int getTickCount() {
		return this.tickCountUntilFinish;
	}
}
