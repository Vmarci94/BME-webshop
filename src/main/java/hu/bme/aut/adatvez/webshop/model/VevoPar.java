package hu.bme.aut.adatvez.webshop.model;

public class VevoPar {
	
	private Vevo vevo1;
	private Vevo vevo2;
	
	public VevoPar(Vevo vevo1, Vevo vevo2) {
		super();
		this.vevo1 = vevo1;
		this.vevo2 = vevo2;
	}
	public Vevo getVevo1() {
		return vevo1;
	}
	public void setVevo1(Vevo vevo1) {
		this.vevo1 = vevo1;
	}
	public Vevo getVevo2() {
		return vevo2;
	}
	public void setVevo2(Vevo vevo2) {
		this.vevo2 = vevo2;
	}
}
