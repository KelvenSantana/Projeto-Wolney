package br.com.ProjetoAP2.repositorio;

import org.springframework.stereotype.Repository;

import br.com.ProjetoAP2.dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
