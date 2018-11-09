package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEGRENDELESTETEL database table.
 * 
 */
@Entity
@NamedQuery(name="Megrendelestetel.findAll", query="SELECT m FROM Megrendelestetel m")
public class Megrendelestetel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal mennyiseg;

	private Double nettoar;

	//bi-directional many-to-one association to Megrendeles
	@ManyToOne
	@JoinColumn(name="MEGRENDELESID")
	private Megrendeles megrendeles;

	//bi-directional many-to-one association to Termek
	@ManyToOne
	@JoinColumn(name="TERMEKID")
	private Termek termek;

	//bi-directional many-to-one association to Statusz
	@ManyToOne
	@JoinColumn(name="STATUSZID")
	private Statusz statusz;

	//bi-directional many-to-one association to Szamlatetel
	@OneToMany(mappedBy="megrendelestetel")
	private List<Szamlatetel> szamlatetels;

	public Megrendelestetel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getMennyiseg() {
		return this.mennyiseg;
	}

	public void setMennyiseg(BigDecimal mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	public Double getNettoar() {
		return this.nettoar;
	}

	public void setNettoar(Double nettoar) {
		this.nettoar = nettoar;
	}

	public Megrendeles getMegrendeles() {
		return this.megrendeles;
	}

	public void setMegrendeles(Megrendeles megrendele) {
		this.megrendeles = megrendele;
	}

	public Termek getTermek() {
		return this.termek;
	}

	public void setTermek(Termek termek) {
		this.termek = termek;
	}

	public Statusz getStatusz() {
		return this.statusz;
	}

	public void setStatusz(Statusz statusz) {
		this.statusz = statusz;
	}

	public List<Szamlatetel> getSzamlatetels() {
		return this.szamlatetels;
	}

	public void setSzamlatetels(List<Szamlatetel> szamlatetels) {
		this.szamlatetels = szamlatetels;
	}

	public Szamlatetel addSzamlatetel(Szamlatetel szamlatetel) {
		getSzamlatetels().add(szamlatetel);
		szamlatetel.setMegrendelestetel(this);

		return szamlatetel;
	}

	public Szamlatetel removeSzamlatetel(Szamlatetel szamlatetel) {
		getSzamlatetels().remove(szamlatetel);
		szamlatetel.setMegrendelestetel(null);

		return szamlatetel;
	}

}