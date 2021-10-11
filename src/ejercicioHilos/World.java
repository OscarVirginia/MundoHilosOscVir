package ejercicioHilos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World{
	private List<Being> beings = new ArrayList<>();
	private final int MAXBEINGS = 10;
	private Cornucopia cornucopia = Cornucopia.getInstance();
	private boolean fullWorld = false;
	private WorldView view;
	
	public World(WorldView view) {
		super();
		this.view = view;
	}
	

	public void makeHistory() {
	
			for (int i = 0; i < MAXBEINGS; i++) {
				Being being =new Being(this.cornucopia);
				beings.add(being);
				being.start();
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			
			//Cuando termina el mundo la cornucopia tb desaparece
			cornucopia.setEnable(false);
			System.out.println("");
			System.out.println("FIN DEL MUNDO");
	}

	public boolean isFullWorld() {
		return fullWorld;
	}

	public void setFullWorld(boolean fullWorld) {
		this.fullWorld = fullWorld;
	}

	private boolean isAnyoneIn() {
		return beings.size() > 0;
	}

	public List<Being> getBeings() {
		return beings;
	}

	public long getConsumed() {
		return cornucopia.getConsumed();
	}

	private boolean checkFullBox() {
		return beings.size() >= MAXBEINGS;
	}
	public Cornucopia getCornucopia() {
		return cornucopia;
	}


}
