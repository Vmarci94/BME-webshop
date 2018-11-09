package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VEVO database table.
 * 
 */
@Entity
@NamedQuery(name="Vevo.findAll", query="SELECT v FROM Vevo v")
public class Vevo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String email;

	private String jelszo;

	private String login;

	private String nev;

	private String szamlaszam;

	//bi-directional many-to-one association to Telephely
	@OneToMany(mappedBy="vevo")
	private List<Telephely> telephelies;

	//bi-directional many-to-one association to Telephely
	@ManyToOne
	@JoinColumn(name="KOZPONTITELEPHELY")
	private Telephely telephely;

	public Vevo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJelszo() {
		return this.jelszo;
	}

	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public List<Telephely> getTelephelies() {
		return this.telephelies;
	}

	public void setTelephelies(List<Telephely> telephelies) {
		this.telephelies = telephelies;
	}

	public Telephely addTelephely(Telephely telephely) {
		getTelephelies().add(telephely);
		telephely.setVevo(this);

		return telephely;
	}

	public Telephely removeTelephely(Telephely telephely) {
		getTelephelies().remove(telephely);
		telephely.setVevo(null);

		return telephely;
	}

	public Telephely getTelephely() {
		return this.telephely;
	}

	public void setTelephely(Telephely telephely) {
		this.telephely = telephely;
	}

}