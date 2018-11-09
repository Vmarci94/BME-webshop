package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUSZ database table.
 * 
 */
@Entity
@NamedQuery(name="Statusz.findAll", query="SELECT s FROM Statusz s")
public class Statusz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nev;

	//bi-directional many-to-one association to Megrendeles
	@OneToMany(mappedBy="statusz")
	private List<Megrendeles> megrendeles;

	//bi-directional many-to-one association to Megrendelestetel
	@OneToMany(mappedBy="statusz")
	private List<Megrendelestetel> megrendelestetels;

	public Statusz() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public List<Megrendeles> getMegrendeles() {
		return this.megrendeles;
	}

	public void setMegrendeles(List<Megrendeles> megrendeles) {
		this.megrendeles = megrendeles;
	}

	public Megrendeles addMegrendele(Megrendeles megrendele) {
		getMegrendeles().add(megrendele);
		megrendele.setStatusz(this);

		return megrendele;
	}

	public Megrendeles removeMegrendele(Megrendeles megrendele) {
		getMegrendeles().remove(megrendele);
		megrendele.setStatusz(null);

		return megrendele;
	}

	public List<Megrendelestetel> getMegrendelestetels() {
		return this.megrendelestetels;
	}

	public void setMegrendelestetels(List<Megrendelestetel> megrendelestetels) {
		this.megrendelestetels = megrendelestetels;
	}

	public Megrendelestetel addMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().add(megrendelestetel);
		megrendelestetel.setStatusz(this);

		return megrendelestetel;
	}

	public Megrendelestetel removeMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().remove(megrendelestetel);
		megrendelestetel.setStatusz(null);

		return megrendelestetel;
	}

}