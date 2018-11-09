package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SZAMLAKIALLITO database table.
 * 
 */
@Entity
@NamedQuery(name="Szamlakiallito.findAll", query="SELECT s FROM Szamlakiallito s")
public class Szamlakiallito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String adoszam;

	private String ir;

	private String nev;

	private String szamlaszam;

	private String utca;

	private String varos;

	//bi-directional many-to-one association to Szamla
	@OneToMany(mappedBy="szamlakiallito")
	private List<Szamla> szamlas;

	public Szamlakiallito() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdoszam() {
		return this.adoszam;
	}

	public void setAdoszam(String adoszam) {
		this.adoszam = adoszam;
	}

	public String getIr() {
		return this.ir;
	}

	public void setIr(String ir) {
		this.ir = ir;
	}

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getSzamlaszam() {
		return this.szamlaszam;
	}

	public void setSzamlaszam(String szamlaszam) {
		this.szamlaszam = szamlaszam;
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

	public List<Szamla> getSzamlas() {
		return this.szamlas;
	}

	public void setSzamlas(List<Szamla> szamlas) {
		this.szamlas = szamlas;
	}

	public Szamla addSzamla(Szamla szamla) {
		getSzamlas().add(szamla);
		szamla.setSzamlakiallito(this);

		return szamla;
	}

	public Szamla removeSzamla(Szamla szamla) {
		getSzamlas().remove(szamla);
		szamla.setSzamlakiallito(null);

		return szamla;
	}

}