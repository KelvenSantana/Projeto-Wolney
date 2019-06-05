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

import br.com.ProjetoAP2.dominio.Instrumentos;
import br.com.ProjetoAP2.servico.InstrumentoServico;

@RestController
@RequestMapping(value = "/instrumentos")
public class InstrumentoRecurso {
	
	@Autowired
	private InstrumentoServico instrumentoservico;
	
	// Buscar Instrumentos Pelo ID
		@RequestMapping(value = "/{cod}", method = RequestMethod.GET)
		public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer cod) {
			Instrumentos instrumentos = instrumentoservico.buscarPorCodigo(cod);
			return ResponseEntity.ok(instrumentos);
			
		}
		
		// Salvar Instrumentos
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<?> salvar(@RequestBody Instrumentos instrumentos) {
			instrumentos = instrumentoservico.salvar(instrumentos);
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{cod}")
					.buildAndExpand(instrumentos.getCod())
					.toUri();
			return ResponseEntity.created(uri).build();
					
		}
		
		// Atualizar Instrumentos
		@RequestMapping(value = "/{cod}", method = RequestMethod.PUT)
		public ResponseEntity<?> atualizar(@PathVariable Integer cod, @RequestBody Instrumentos instrumentos) {
			instrumentos.setCod(cod);
			instrumentos = instrumentoservico.atualizar(instrumentos);
			return ResponseEntity.noContent().build();
		}
		
		// Deletar Instrumentos
		@RequestMapping(value = "/{cod}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deletar(@PathVariable Integer cod){
			instrumentoservico.deletar(cod);
			return ResponseEntity.noContent().build();
		}
		
		// Listar Instrumentos
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<?> listar(){
			List<Instrumentos> lista = instrumentoservico.listar();
			return ResponseEntity.ok().body(lista);
		}
}
