package ejercicioHilos;

import java.util.Random;

public class Being extends Thread{
	private final int MAXLONGLIFE = 80;
	private final int ANNUALFEED = 1;
	private static int order=0;
	private Cornucopia cornucopia;
	
	private int id;
	private int lifeExpectancy;
	private int actualLife = 0;
	private boolean dead = false;
	
	
	public Being(Cornucopia cornucopia) {
		super();
		lifeExpectancy = new Random().nextInt(MAXLONGLIFE);
		id=order++;
		this.cornucopia= cornucopia;
	}
	
	@Override
	public void run() {
		super.run();
		do {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			feed();
			aging();
			present();
			if (isDead()) {
				System.out.println("SOY "+ id+ " HE MUERTO");
			}
			
			//Si el mundo ha terminado y la cornucopia ha desaparecido mueren todos.
			if(!cornucopia.isEnable()) {
				everyoneDead();
				System.out.println("SOY "+ id+ " HE MUERTO POR LA CORNUCOPIA");
			}
			
		}while(!isDead());
	}
	
	

	private void feed() {
		actualLife += cornucopia.provide(ANNUALFEED);
	}

	
	private void aging() {
		actualLife++;
		setDead(!(actualLife < lifeExpectancy));
	}

	private void setDead(boolean result) {
		dead = result;
	}

	public boolean isDead() {
		return dead;
	}
	public void everyoneDead() {
		if(!cornucopia.isEnable()) {
			this.setDead(true);
		}
	}

	public void present() {
		System.out.println("Soy "+id+" y tengo "+actualLife+" estoy vivo? "+ !isDead());
		
	}
}
