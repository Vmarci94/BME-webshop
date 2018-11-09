package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SZAMLATETEL database table.
 * 
 */
@Entity
@NamedQuery(name="Szamlatetel.findAll", query="SELECT s FROM Szamlatetel s")
public class Szamlatetel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal afakulcs;

	private BigDecimal mennyiseg;

	private double nettoar;

	private String nev;

	//bi-directional many-to-one association to Szamla
	@ManyToOne
	@JoinColumn(name="SZAMLAID")
	private Szamla szamla;

	//bi-directional many-to-one association to Megrendelestetel
	@ManyToOne
	@JoinColumn(name="MEGRENDELESTETELID")
	private Megrendelestetel megrendelestetel;

	public Szamlatetel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAfakulcs() {
		return this.afakulcs;
	}

	public void setAfakulcs(BigDecimal afakulcs) {
		this.afakulcs = afakulcs;
	}

	public BigDecimal getMennyiseg() {
		return this.mennyiseg;
	}

	public void setMennyiseg(BigDecimal mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	public double getNettoar() {
		return this.nettoar;
	}

	public void setNettoar(double nettoar) {
		this.nettoar = nettoar;
	}

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public Szamla getSzamla() {
		return this.szamla;
	}

	public void setSzamla(Szamla szamla) {
		this.szamla = szamla;
	}

	public Megrendelestetel getMegrendelestetel() {
		return this.megrendelestetel;
	}

	public void setMegrendelestetel(Megrendelestetel megrendelestetel) {
		this.megrendelestetel = megrendelestetel;
	}

}