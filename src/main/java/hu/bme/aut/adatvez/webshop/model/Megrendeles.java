package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MEGRENDELES database table.
 * 
 */
@Entity
@NamedQuery(name="Megrendeles.findAll", query="SELECT m FROM Megrendeles m")
public class Megrendeles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	@Temporal(TemporalType.DATE)
	private Date hatarido;

	//bi-directional many-to-one association to Telephely
	@ManyToOne
	@JoinColumn(name="TELEPHELYID")
	private Telephely telephely;

	//bi-directional many-to-one association to Statusz
	@ManyToOne
	@JoinColumn(name="STATUSZID")
	private Statusz statusz;

	//bi-directional many-to-one association to Fizetesmod
	@ManyToOne
	@JoinColumn(name="FIZETESMODID")
	private Fizetesmod fizetesmod;

	//bi-directional many-to-one association to Megrendelestetel
	@OneToMany(mappedBy= "megrendeles")
	private List<Megrendelestetel> megrendelestetels;

	//bi-directional many-to-one association to Szamla
	@OneToMany(mappedBy="megrendele")
	private List<Szamla> szamlas;

	public Megrendeles() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getHatarido() {
		return this.hatarido;
	}

	public void setHatarido(Date hatarido) {
		this.hatarido = hatarido;
	}

	public Telephely getTelephely() {
		return this.telephely;
	}

	public void setTelephely(Telephely telephely) {
		this.telephely = telephely;
	}

	public Statusz getStatusz() {
		return this.statusz;
	}

	public void setStatusz(Statusz statusz) {
		this.statusz = statusz;
	}

	public Fizetesmod getFizetesmod() {
		return this.fizetesmod;
	}

	public void setFizetesmod(Fizetesmod fizetesmod) {
		this.fizetesmod = fizetesmod;
	}

	public List<Megrendelestetel> getMegrendelestetels() {
		return this.megrendelestetels;
	}

	public void setMegrendelestetels(List<Megrendelestetel> megrendelestetels) {
		this.megrendelestetels = megrendelestetels;
	}

	public Megrendelestetel addMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().add(megrendelestetel);
		megrendelestetel.setMegrendeles(this);

		return megrendelestetel;
	}

	public Megrendelestetel removeMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().remove(megrendelestetel);
		megrendelestetel.setMegrendeles(null);

		return megrendelestetel;
	}

	public List<Szamla> getSzamlas() {
		return this.szamlas;
	}

	public void setSzamlas(List<Szamla> szamlas) {
		this.szamlas = szamlas;
	}

	public Szamla addSzamla(Szamla szamla) {
		getSzamlas().add(szamla);
		szamla.setMegrendele(this);

		return szamla;
	}

	public Szamla removeSzamla(Szamla szamla) {
		getSzamlas().remove(szamla);
		szamla.setMegrendele(null);

		return szamla;
	}

}