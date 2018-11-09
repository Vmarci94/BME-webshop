package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FIZETESMOD database table.
 * 
 */
@Entity
@NamedQuery(name="Fizetesmod.findAll", query="SELECT f FROM Fizetesmod f")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "fizModSP", 
			procedureName = "FizetesModLetrehozasa",
			parameters = {
	        	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_mod", type = String.class),
	        	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hatarido", type = BigDecimal.class),
	        	@StoredProcedureParameter(mode = ParameterMode.OUT, name = "CurrentId", type = Long.class)
	        })	  
})
public class Fizetesmod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@NotNull
	private BigDecimal hatarido;

	@Column(name="MOD")
	@NotEmpty
	private String mod;

	//bi-directional many-to-one association to Megrendeles
	@OneToMany(mappedBy="fizetesmod")
	private List<Megrendeles> megrendeles;

	public Fizetesmod() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getHatarido() {
		return this.hatarido;
	}

	public void setHatarido(BigDecimal hatarido) {
		this.hatarido = hatarido;
	}

	public String getMod() {
		return this.mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public List<Megrendeles> getMegrendeles() {
		return this.megrendeles;
	}

	public void setMegrendeles(List<Megrendeles> megrendeles) {
		this.megrendeles = megrendeles;
	}

	public Megrendeles addMegrendele(Megrendeles megrendele) {
		getMegrendeles().add(megrendele);
		megrendele.setFizetesmod(this);

		return megrendele;
	}

	public Megrendeles removeMegrendele(Megrendeles megrendele) {
		getMegrendeles().remove(megrendele);
		megrendele.setFizetesmod(null);

		return megrendele;
	}

}