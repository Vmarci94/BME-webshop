package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AFA database table.
 * 
 */
@Entity
@NamedQuery(name="Afa.findAll", query="SELECT a FROM Afa a")
public class Afa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal kulcs;

	//bi-directional many-to-one association to Termek
	@OneToMany(mappedBy="afa")
	private List<Termek> termeks;

	public Afa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getKulcs() {
		return this.kulcs;
	}

	public void setKulcs(BigDecimal kulcs) {
		this.kulcs = kulcs;
	}

	public List<Termek> getTermeks() {
		return this.termeks;
	}

	public void setTermeks(List<Termek> termeks) {
		this.termeks = termeks;
	}

	public Termek addTermek(Termek termek) {
		getTermeks().add(termek);
		termek.setAfa(this);

		return termek;
	}

	public Termek removeTermek(Termek termek) {
		getTermeks().remove(termek);
		termek.setAfa(null);

		return termek;
	}

}