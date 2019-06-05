package br.com.ProjetoAP2.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoAP2.dominio.Cliente;
import br.com.ProjetoAP2.repositorio.ClienteRepositorio;


@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio clienterepositorio;
	
	public Cliente buscarPorCodigo(Integer id) {
		Optional<Cliente> obj = clienterepositorio.findById(id);
		return obj.orElseThrow(null);
		
	}
	
	public Cliente salvar(Cliente cliente) {
		cliente.setId(null);
		return clienterepositorio.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		return clienterepositorio.saveAndFlush(cliente);
	}
	
	public void deletar(Integer id) {
		clienterepositorio.deleteById(id);
	}
	
	public List<Cliente> listar(){
		return clienterepositorio.findAll();
	}
	
}

