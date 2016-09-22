package olimpiadas.games.negocios;

import java.util.ArrayList;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.CampeonatoJSON;

public class RegrasCampeonato {
	
	public void createCampeonato(String nome, String esporte){
		BaseDados.createCampeonato(nome, esporte);
	}
	
	public void insereEquipeCampeonato(int idEquipe, String esporteCampeonato, int grupo){
		BaseDados.insereEquipeCampeonato(idEquipe, esporteCampeonato, grupo);
	}
	
	public void insereJogoCampeonato(int idJogo, int idCampeonato, int grupo){
		BaseDados.insereJogoCampeonato(idJogo, idCampeonato, grupo);
	}
	
	public void atualizaClassificacao(Campeonato campeonato){
		BaseDados.atualizaClassificacao(campeonato);
	}
	
	public ArrayList<Campeonato> getCampeonatos(){
		return BaseDados.getCampeonatos();
	}
	
	public CampeonatoJSON getCampeonato(String esporteCampeonato){
		return BaseDados.getCampeonato(esporteCampeonato);
	}

}
