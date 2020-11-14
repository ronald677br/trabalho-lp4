package Slide2.processors;

public class ProcessorExTres implements Runnable{
	private int[] linha;
	private int id;
	private int soma;
	
	public ProcessorExTres(int id, int[] linha) {
		this.setLinha(linha);
		this.setId(id);
	}
	
	@Override
	public void run() {
		try {
			int[] linha = this.getLinha();
			for (int i = 0; i <  linha.length; i++) {
				this.setSoma(this.getSoma() + linha[i]);
			}
			System.out.println("Resultado da Thread " + this.getId() + ": " + soma);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}	
	}

	public int[] getLinha() {
		return linha;
	}

	public void setLinha(int[] linha) {
		this.linha = linha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}
}
