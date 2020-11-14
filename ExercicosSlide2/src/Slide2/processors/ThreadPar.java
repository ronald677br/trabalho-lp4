package Slide2.processors;

import java.util.Random;

public class ThreadPar extends Thread{
	
	private int num = -1;
	private boolean wait;
	
	private final long TIME = 2000;
	
	public ThreadPar() {
		int value = ThreadPar.getRandomNumberInRange(1, 15);
		synchronized (this) {
			if((value % 2) != 0) {
				try {
					super.wait(this.TIME);
					this.setWait(true);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				this.num = value;
			}
		}
	}
	
	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isWait() {
		return wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}
}
