package br.com.ProjetoAP2.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "cod_instrumentos")
	private Instrumentos instrumentos;
	
	@ManyToOne
	@JoinColumn(name = "cod_acessorios")
	private Acessorios acessorios;

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}

	public Instrumentos getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(Instrumentos instrumentos) {
		this.instrumentos = instrumentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
