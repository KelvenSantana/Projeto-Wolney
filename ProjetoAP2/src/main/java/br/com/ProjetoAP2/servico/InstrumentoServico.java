package br.com.ProjetoAP2.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoAP2.dominio.Instrumentos;
import br.com.ProjetoAP2.repositorio.InstrumentosRepositorio;

@Service
public class InstrumentoServico {
	
	@Autowired
	private InstrumentosRepositorio instrumentosrepositorio;
	
	public Instrumentos buscarPorCodigo(Integer cod) {
		Optional<Instrumentos> obj = instrumentosrepositorio.findById(cod);
		return obj.orElseThrow(null);
		
	}
	
	public Instrumentos salvar(Instrumentos instrumentos) {
		instrumentos.setCod(null);
		return instrumentosrepositorio.save(instrumentos);
	}
	
	public Instrumentos atualizar(Instrumentos instrumentos) {
		return instrumentosrepositorio.saveAndFlush(instrumentos);
	}
	
	public void deletar(Integer cod) {
		instrumentosrepositorio.deleteById(cod);
	}
	
	public List<Instrumentos> listar(){
		return instrumentosrepositorio.findAll();
	}

}
