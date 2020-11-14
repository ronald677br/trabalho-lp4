package Slide2.processors;

public class ProcessorExUm implements Runnable{
	private int id;
	
	public ProcessorExUm(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("A thread " + this.getId() + " executou.");
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
}
