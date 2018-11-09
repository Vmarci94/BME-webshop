package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TERMEK database table.
 * 
 */
@Entity
@Table(name = "TERMEK")
@NamedQueries({
	@NamedQuery(name="Termek.findAll", query="SELECT t FROM Termek t"),
	@NamedQuery(name="Termek.findLegdragabb", query="SELECT t FROM Termek t WHERE t.nettoar IN (SELECT MAX(t2.nettoar) FROM Termek t2)")
})
public class Termek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private double nettoar;

	private String nev;

    /**
     * Egy termék raktáron elérhető darabszámát reprezentálja
     */
	private BigDecimal raktarkeszlet;

	//bi-directional many-to-one association to Megrendelestetel
	@OneToMany(mappedBy="termek", fetch = FetchType.EAGER)
	private List<Megrendelestetel> megrendelestetels;

	//bi-directional many-to-one association to Afa
	@ManyToOne
	@JoinColumn(name="AFAID")
	private Afa afa;

	//bi-directional many-to-one association to Kategoria
	@ManyToOne
	@JoinColumn(name="KATEGORIAID")
	private Kategoria kategoria;

	public Termek() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getRaktarkeszlet() {
		return this.raktarkeszlet;
	}

	public void setRaktarkeszlet(BigDecimal raktarkeszlet) {
		this.raktarkeszlet = raktarkeszlet;
	}

	public List<Megrendelestetel> getMegrendelestetels() {
		return this.megrendelestetels;
	}

	public void setMegrendelestetels(List<Megrendelestetel> megrendelestetels) {
		this.megrendelestetels = megrendelestetels;
	}

	public Megrendelestetel addMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().add(megrendelestetel);
		megrendelestetel.setTermek(this);

		return megrendelestetel;
	}

	public Megrendelestetel removeMegrendelestetel(Megrendelestetel megrendelestetel) {
		getMegrendelestetels().remove(megrendelestetel);
		megrendelestetel.setTermek(null);

		return megrendelestetel;
	}

	public Afa getAfa() {
		return this.afa;
	}

	public void setAfa(Afa afa) {
		this.afa = afa;
	}

	public Kategoria getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

}