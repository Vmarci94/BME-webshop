package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SZAMLA database table.
 * 
 */
@Entity
@NamedQuery(name="Szamla.findAll", query="SELECT s FROM Szamla s")
public class Szamla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	private Date fizetesihatarido;

	private String fizetesimod;

	@Temporal(TemporalType.DATE)
	private Date kiallitasdatum;

	private String megrendeloir;

	private String megrendelonev;

	private String megrendeloutca;

	private String megrendelovaros;

	private BigDecimal nyomtatottpeldanyszam;

	private String sztorno;

	@Temporal(TemporalType.DATE)
	private Date teljesitesdatum;

	//bi-directional many-to-one association to Szamlakiallito
	@ManyToOne
	@JoinColumn(name="KIALLITOID")
	private Szamlakiallito szamlakiallito;

	//bi-directional many-to-one association to Megrendeles
	@ManyToOne
	@JoinColumn(name="MEGRENDELESID")
	private Megrendeles megrendele;

	//bi-directional many-to-one association to Szamlatetel
	@OneToMany(mappedBy="szamla")
	private List<Szamlatetel> szamlatetels;

	public Szamla() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFizetesihatarido() {
		return this.fizetesihatarido;
	}

	public void setFizetesihatarido(Date fizetesihatarido) {
		this.fizetesihatarido = fizetesihatarido;
	}

	public String getFizetesimod() {
		return this.fizetesimod;
	}

	public void setFizetesimod(String fizetesimod) {
		this.fizetesimod = fizetesimod;
	}

	public Date getKiallitasdatum() {
		return this.kiallitasdatum;
	}

	public void setKiallitasdatum(Date kiallitasdatum) {
		this.kiallitasdatum = kiallitasdatum;
	}

	public String getMegrendeloir() {
		return this.megrendeloir;
	}

	public void setMegrendeloir(String megrendeloir) {
		this.megrendeloir = megrendeloir;
	}

	public String getMegrendelonev() {
		return this.megrendelonev;
	}

	public void setMegrendelonev(String megrendelonev) {
		this.megrendelonev = megrendelonev;
	}

	public String getMegrendeloutca() {
		return this.megrendeloutca;
	}

	public void setMegrendeloutca(String megrendeloutca) {
		this.megrendeloutca = megrendeloutca;
	}

	public String getMegrendelovaros() {
		return this.megrendelovaros;
	}

	public void setMegrendelovaros(String megrendelovaros) {
		this.megrendelovaros = megrendelovaros;
	}

	public BigDecimal getNyomtatottpeldanyszam() {
		return this.nyomtatottpeldanyszam;
	}

	public void setNyomtatottpeldanyszam(BigDecimal nyomtatottpeldanyszam) {
		this.nyomtatottpeldanyszam = nyomtatottpeldanyszam;
	}

	public String getSztorno() {
		return this.sztorno;
	}

	public void setSztorno(String sztorno) {
		this.sztorno = sztorno;
	}

	public Date getTeljesitesdatum() {
		return this.teljesitesdatum;
	}

	public void setTeljesitesdatum(Date teljesitesdatum) {
		this.teljesitesdatum = teljesitesdatum;
	}

	public Szamlakiallito getSzamlakiallito() {
		return this.szamlakiallito;
	}

	public void setSzamlakiallito(Szamlakiallito szamlakiallito) {
		this.szamlakiallito = szamlakiallito;
	}

	public Megrendeles getMegrendele() {
		return this.megrendele;
	}

	public void setMegrendele(Megrendeles megrendele) {
		this.megrendele = megrendele;
	}

	public List<Szamlatetel> getSzamlatetels() {
		return this.szamlatetels;
	}

	public void setSzamlatetels(List<Szamlatetel> szamlatetels) {
		this.szamlatetels = szamlatetels;
	}

	public Szamlatetel addSzamlatetel(Szamlatetel szamlatetel) {
		getSzamlatetels().add(szamlatetel);
		szamlatetel.setSzamla(this);

		return szamlatetel;
	}

	public Szamlatetel removeSzamlatetel(Szamlatetel szamlatetel) {
		getSzamlatetels().remove(szamlatetel);
		szamlatetel.setSzamla(null);

		return szamlatetel;
	}

}