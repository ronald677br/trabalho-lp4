package Slide2.processors;

import java.util.Random;

public class ThreadDivFive extends Thread{
	
	private int num = -1;
	private boolean wait;
	
	private final long TIME = 5000;
	
	public ThreadDivFive() {
		int value = ThreadDivFive.getRandomNumberInRange(0, 50);
		synchronized (this) {
			if((value % 5) != 0) {
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
