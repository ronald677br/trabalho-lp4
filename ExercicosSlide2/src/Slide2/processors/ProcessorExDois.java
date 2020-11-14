package Slide2.processors;

import java.text.MessageFormat;
import java.util.Date;

public class ProcessorExDois implements Runnable{
	
	private int id;
	private String[] noticia;
	
	public ProcessorExDois(int id, String[] noticia) {
		this.id = id;
		this.noticia = noticia;
		
	}
	
	@Override
	public void run() {
		try {
			if(getId() == 1) {
				for(int i = 0; i < getNoticia().length; i++) {
					System.out.println(getNoticia()[i]);
					Thread.sleep(5000);
				}
			}else {
				for(int i = 0; i < getNoticia().length; i++) {
					Date date = new Date(System.currentTimeMillis());
					System.out.println(formatDate(date));
					Thread.sleep(10000);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	@SuppressWarnings("deprecation")
	public String formatDate(Date date) {
		return MessageFormat.format("{0}:{1}:{2}", date.getHours(), date.getMinutes(), date.getSeconds());
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getNoticia() {
		return noticia;
	}

	public void setNoticia(String[] noticia) {
		this.noticia = noticia;
	}

}
