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

import br.com.ProjetoAP2.dominio.Acessorios;
import br.com.ProjetoAP2.servico.AcessorioServico;



@RestController
@RequestMapping(value = "/acessorios")
public class AcessorioRecurso {
	
	@Autowired
	private AcessorioServico acessorioservico;
	
	// Buscar Acessorio Pelo ID
	@RequestMapping(value = "/{cod}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer cod) {
		Acessorios acessorios = acessorioservico.buscarPorCodigo(cod);
		return ResponseEntity.ok(acessorios);
		
	}
	
	// Salvar Acessorios
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Acessorios acessorios) {
		acessorios = acessorioservico.salvar(acessorios);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{cod}")
				.buildAndExpand(acessorios.getCod())
				.toUri();
		return ResponseEntity.created(uri).build();
				
	}
	
	// Atualizar Acessorios
	@RequestMapping(value = "/{cod}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer cod, @RequestBody Acessorios acessorios) {
		acessorios.setCod(cod);
		acessorios = acessorioservico.atualizar(acessorios);
		return ResponseEntity.noContent().build();
	}
	
	// Deletar Acessorios
	@RequestMapping(value = "/{cod}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer cod){
		acessorioservico.deletar(cod);
		return ResponseEntity.noContent().build();
	}
	
	// Listar Acessorios
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Acessorios> lista = acessorioservico.listar();
		return ResponseEntity.ok().body(lista);
	}

}
