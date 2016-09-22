package olimpiadas.games.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import olimpiadas.games.modelo.Equipe;
import olimpiadas.games.negocios.RegrasEquipe;

@Path("/equipes")
public class EquipeResource {
	
	RegrasEquipe regras = new RegrasEquipe();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Equipe getEquipe(@PathParam("id") int id){
		return regras.getEquipe(id);
	}
	
}
