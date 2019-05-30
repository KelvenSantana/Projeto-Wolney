package br.com.ProjetoAP2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ProjetoAP2.dominio.Cliente;
import br.com.ProjetoAP2.dominio.Acessorios;
import br.com.ProjetoAP2.dominio.Instrumentos;
import br.com.ProjetoAP2.repositorio.AcessoriosRepositorio;
import br.com.ProjetoAP2.repositorio.ClienteRepositorio;
import br.com.ProjetoAP2.repositorio.InstrumentosRepositorio;




@SpringBootApplication
public class ProjetoAp2Application implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienterep;
	
	@Autowired
	private AcessoriosRepositorio acessoriorep;
	
	@Autowired
	private InstrumentosRepositorio instrumentorep;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome("Kelven Santana");
		cliente.setCpf("666.666.666-92");
		cliente.setEmail("Kelven.santana022@gmail.com");
		

		clienterep.save(cliente);
		
		Acessorios acessorios = new Acessorios();
		acessorios.setCabo("Cabo");
		acessorios.setCorreia("Correia");
		acessorios.setTipodecorda("Tipo de Corda");
		
		acessoriorep.save(acessorios);
		
		Instrumentos instrumento = new Instrumentos();
		instrumento.setBaixo("Baixo");
		instrumento.setBateria("Bateria");
		instrumento.setGuitarra("guitarra");
		instrumento.setTeclado("teclado");
		
		instrumentorep.save(instrumento);
	}

}
