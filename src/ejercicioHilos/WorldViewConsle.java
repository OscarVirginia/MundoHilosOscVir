package ejercicioHilos;


public class WorldViewConsle extends WorldView {

	@Override
	public void showInstant(WorldPresenter worldPresenter) {
		System.out.println("-------------------------------");
		System.out.println("------  ESTADO DEL MUNDO  -----");
		for (Being being : worldPresenter.getBeings()) {
			being.present();
		}
		System.err.println("hemos comsumido "+worldPresenter.getConsumedFood());
	}

}
