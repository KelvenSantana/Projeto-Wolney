package br.com.ProjetoAP2.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "acessorios")
public class Acessorios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	
	@Column
	private String correia;
	
	@Column
	private String tipodecorda;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCorreia() {
		return correia;
	}

	public void setCorreia(String correia) {
		this.correia = correia;
	}

	public String getTipodecorda() {
		return tipodecorda;
	}

	public void setTipodecorda(String tipodecorda) {
		this.tipodecorda = tipodecorda;
	}

	public String getCabo() {
		return cabo;
	}

	public void setCabo(String cabo) {
		this.cabo = cabo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column
	private String cabo;

}
