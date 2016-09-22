package olimpiadas.games.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.CampeonatoJSON;
import olimpiadas.games.negocios.RegrasCampeonato;

@Path("/campeonato")
public class CampeonatoResource {

	RegrasCampeonato regras = new RegrasCampeonato();
	
	@GET
	@Path("/{esporte}")
	@Produces(MediaType.APPLICATION_JSON)
	public CampeonatoJSON getCampeonato(@PathParam("esporte") String esporteCampeonato){
		BaseDados.inicialize();
		return BaseDados.atualizaClassificacao(BaseDados.campeonato);
		//return regras.getCampeonato(esporteCampeonato);
		
	}
	
	
}
