package olimpiadas.games.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.Jogo;
import olimpiadas.games.negocios.RegrasJogo;

@Path("/jogos")
public class JogoResource {
	
	RegrasJogo regras = new RegrasJogo();

	@GET
	@Path("/initialize")
	public void initialize(){
		BaseDados.inicialize();
		System.out.println("INICIOU");
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Jogo> getAllJogos(){
		return regras.getAllJogos();
	}
	
	@POST
	@Path("/atualizaplacar/{idCampeonato}/{idJogo}/{placarEqp1}/{placarEqp2}")
	public void atualizaPlacar (@PathParam("idCampeonato") int idCampeonato,
								@PathParam("idJogo") int idJogo,
								@PathParam("placarEqp1") int placarEqp1,
								@PathParam("placarEqp2") int placarEqp2){
		regras.atualizaPlacarJogo(idJogo, placarEqp1, placarEqp2, idCampeonato);
	}
	
}
