package br.com.ProjetoAP2;

import java.util.Arrays;

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
		Acessorios acessorios = new Acessorios();
		acessorios.setNome("Correia");
		acessorios.setQuant(1);
		
		Acessorios acessorios2 = new Acessorios();
		acessorios2.setNome("Cabo");
		acessorios2.setQuant(1);
		
		Acessorios acessorios3 = new Acessorios();
		acessorios3.setNome("Tipo de Corda");
		acessorios3.setQuant(1);
		
		acessoriorep.saveAll(Arrays.asList(acessorios, acessorios2, acessorios3));
		
		Instrumentos instrumentos = new Instrumentos();
		instrumentos.setNome("Baixo");
		instrumentos.setQuant(1);
		
		Instrumentos instrumentos2 = new Instrumentos();
		instrumentos2.setNome("Bateria");
		instrumentos2.setQuant(1);
		
		Instrumentos instrumentos3 = new Instrumentos();
		instrumentos3.setNome("Guitarra");
		instrumentos3.setQuant(1);
		
		Instrumentos instrumentos4 = new Instrumentos();
		instrumentos4.setNome("Teclado");
		instrumentos4.setQuant(1);
		
		instrumentorep.saveAll(Arrays.asList(instrumentos, instrumentos2, instrumentos3, instrumentos4));
		
		Cliente cliente = new Cliente();
		cliente.setNome("Kelven Santana");
		cliente.setCpf("666.666.666-92");
		cliente.setEmail("Kelven.santana022@gmail.com");
		cliente.setAcessorios(acessorios);
		cliente.setInstrumentos(instrumentos4);


		clienterep.save(cliente);
		

		
	}

}
