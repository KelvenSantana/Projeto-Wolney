package br.com.ProjetoAP2.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instrumentos")
public class Instrumentos implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@Column
	private String bateria;
	
	@Column
	private String baixo;
	
	@Column
	private String guitarra;
	
	@Column
	private String teclado;
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getBaixo() {
		return baixo;
	}

	public void setBaixo(String baixo) {
		this.baixo = baixo;
	}

	public String getGuitarra() {
		return guitarra;
	}

	public void setGuitarra(String guitarra) {
		this.guitarra = guitarra;
	}

	public String getTeclado() {
		return teclado;
	}

	public void setTeclado(String teclado) {
		this.teclado = teclado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
