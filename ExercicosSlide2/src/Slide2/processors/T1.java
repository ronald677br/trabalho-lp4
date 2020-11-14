package Slide2.processors;

public class T1 implements Runnable{
	private int identificador;
	
	public T1(int id) {
		this.setIdentificador(id);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Thread " + this.getIdentificador() + " executando.");
		}
		
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
