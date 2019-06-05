package br.com.ProjetoAP2.recurso;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ProjetoAP2.dominio.Cliente;
import br.com.ProjetoAP2.servico.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteRecurso {
	

	@Autowired
	private ClienteServico clienteservico;
	
	// Buscar Cliente Pelo ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
		Cliente cliente = clienteservico.buscarPorCodigo(id);
		return ResponseEntity.ok(cliente);
		
	}
	
	// Salvar Cliente
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
		cliente = clienteservico.salvar(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
				
	}
	
	// Atualizar Cliente
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		cliente = clienteservico.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	// Deletar Cliente
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		clienteservico.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	// Listar Clientes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Cliente> lista = clienteservico.listar();
		return ResponseEntity.ok().body(lista);
	}
}
