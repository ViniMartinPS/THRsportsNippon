package olimpiadas.games.negocios;


import java.util.ArrayList;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.Equipe;

public class RegrasEquipe {
	
	public Equipe getEquipe(int id){
		return BaseDados.getEquipe(id);
	}
		
	public void createEquipe (Equipe equipe){
		BaseDados.createEquipe(equipe);
	}
	
	public void insereJogador(String nome, int idEquipe){
		BaseDados.insereJogador(nome, idEquipe);
	}
	
	public ArrayList<Equipe> getEquipes(){
		return BaseDados.getEquipes();
	}
	
}
