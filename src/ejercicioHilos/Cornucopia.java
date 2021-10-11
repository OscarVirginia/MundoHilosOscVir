package ejercicioHilos;


public class Cornucopia {
	

	private long consumed = 0;
	private static Cornucopia cornucopia;
	private boolean enable= true;
	
	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	private Cornucopia() {
		super();
	}

	public static Cornucopia getInstance() {
		if (cornucopia == null) {
			cornucopia = new Cornucopia();
		}
		return cornucopia;
	}
	
	public long getConsumed() {
		return consumed;
	}

	public int provide(int amount) {
		if(enable) {
			consumed+=amount;
			return amount;
		}
		return 0;
		
	}

}
