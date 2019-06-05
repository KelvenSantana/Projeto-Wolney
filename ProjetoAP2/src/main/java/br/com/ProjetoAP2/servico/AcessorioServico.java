package br.com.ProjetoAP2.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoAP2.dominio.Acessorios;
import br.com.ProjetoAP2.repositorio.AcessoriosRepositorio;

@Service
public class AcessorioServico {
	
	@Autowired
	private AcessoriosRepositorio acessoriorep;
	
	public Acessorios buscarPorCodigo(Integer id) {
		Optional<Acessorios> obj = acessoriorep.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Acessorios salvar(Acessorios acessorios) {
		acessorios.setCod(null);
		return acessoriorep.save(acessorios);
	}
	
	public Acessorios atualizar(Acessorios acessorios) {
		return acessoriorep.saveAndFlush(acessorios);
	}
	
	public void deletar(Integer cod) {
		acessoriorep.deleteById(cod);
	}
	
	public List<Acessorios> listar(){
		return acessoriorep.findAll();
	}
	
}
