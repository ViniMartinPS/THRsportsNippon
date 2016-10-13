package olimpiadas.games.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import olimpiadas.games.bd.BD_Equipe;
import olimpiadas.games.modelo.Equipe;
import olimpiadas.games.negocios.RegrasEquipe;

@Path("/equipes")
public class EquipeResource {
	
	RegrasEquipe regras = new RegrasEquipe();
/*
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Equipe getEquipe(@PathParam("id") int id){
		return regras.getEquipe(id);
	}
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Equipe> getEquipes(){
		BD_Equipe bd = new BD_Equipe();
		return bd.getEquipes();
	}
	
}
