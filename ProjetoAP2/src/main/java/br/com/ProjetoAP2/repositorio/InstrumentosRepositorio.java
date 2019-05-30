package br.com.ProjetoAP2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ProjetoAP2.dominio.Instrumentos;

public interface InstrumentosRepositorio extends JpaRepository<Instrumentos, Integer> {

}
