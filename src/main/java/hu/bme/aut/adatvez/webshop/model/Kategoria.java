package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the KATEGORIA database table.
 * 
 */
@Entity
@NamedQuery(name="Kategoria.findAll", query="SELECT k FROM Kategoria k")
public class Kategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nev;

	//bi-directional many-to-one association to Kategoria
	@ManyToOne
	@JoinColumn(name="SZULOKATEGORIA")
	private Kategoria kategoria;

	//bi-directional many-to-one association to Kategoria
	@OneToMany(mappedBy="kategoria")
	private List<Kategoria> kategorias;

	//bi-directional many-to-one association to Termek
	@OneToMany(mappedBy="kategoria")
	private List<Termek> termeks;

	public Kategoria() {
	}

	public Kategoria(long id, String nev) {
		super();
		this.id = id;
		this.nev = nev;
		this.termeks = new ArrayList<>();
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

	public Kategoria getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public List<Kategoria> getKategorias() {
		return this.kategorias;
	}

	public void setKategorias(List<Kategoria> kategorias) {
		this.kategorias = kategorias;
	}

	public Kategoria addKategoria(Kategoria kategoria) {
		getKategorias().add(kategoria);
		kategoria.setKategoria(this);

		return kategoria;
	}

	public Kategoria removeKategoria(Kategoria kategoria) {
		getKategorias().remove(kategoria);
		kategoria.setKategoria(null);

		return kategoria;
	}

	public List<Termek> getTermeks() {
		return this.termeks;
	}

	public void setTermeks(List<Termek> termeks) {
		this.termeks = termeks;
	}

	public Termek addTermek(Termek termek) {
		getTermeks().add(termek);
		termek.setKategoria(this);

		return termek;
	}

	public Termek removeTermek(Termek termek) {
		getTermeks().remove(termek);
		termek.setKategoria(null);

		return termek;
	}

}