package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TELEPHELY database table.
 * 
 */
@Entity
@NamedQuery(name="Telephely.findAll", query="SELECT t FROM Telephely t")
public class Telephely implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String fax;

	private String ir;

	private String tel;

	private String utca;

	private String varos;

	//bi-directional many-to-one association to Megrendeles
	@OneToMany(mappedBy="telephely")
	private List<Megrendeles> megrendeles;

	//bi-directional many-to-one association to Vevo
	@ManyToOne
	@JoinColumn(name="VEVOID")
	private Vevo vevo;

	//bi-directional many-to-one association to Vevo
	@OneToMany(mappedBy="telephely")
	private List<Vevo> vevos;

	public Telephely() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIr() {
		return this.ir;
	}

	public void setIr(String ir) {
		this.ir = ir;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUtca() {
		return this.utca;
	}

	public void setUtca(String utca) {
		this.utca = utca;
	}

	public String getVaros() {
		return this.varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public List<Megrendeles> getMegrendeles() {
		return this.megrendeles;
	}

	public void setMegrendeles(List<Megrendeles> megrendeles) {
		this.megrendeles = megrendeles;
	}

	public Megrendeles addMegrendele(Megrendeles megrendele) {
		getMegrendeles().add(megrendele);
		megrendele.setTelephely(this);

		return megrendele;
	}

	public Megrendeles removeMegrendele(Megrendeles megrendele) {
		getMegrendeles().remove(megrendele);
		megrendele.setTelephely(null);

		return megrendele;
	}

	public Vevo getVevo() {
		return this.vevo;
	}

	public void setVevo(Vevo vevo) {
		this.vevo = vevo;
	}

	public List<Vevo> getVevos() {
		return this.vevos;
	}

	public void setVevos(List<Vevo> vevos) {
		this.vevos = vevos;
	}

	public Vevo addVevo(Vevo vevo) {
		getVevos().add(vevo);
		vevo.setTelephely(this);

		return vevo;
	}

	public Vevo removeVevo(Vevo vevo) {
		getVevos().remove(vevo);
		vevo.setTelephely(null);

		return vevo;
	}

}