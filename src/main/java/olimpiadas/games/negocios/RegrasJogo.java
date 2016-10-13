package olimpiadas.games.negocios;

import java.util.ArrayList;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.bd.BD_Jogo;
import olimpiadas.games.modelo.Jogo;

public class RegrasJogo {
	
	/*
	public ArrayList<Jogo> getAllJogos(){
		return BaseDados.getAllJogos();
	}

	public void createJogo(Jogo jogo){
		BaseDados.createJogo(jogo);
	}
	
	public void atualizaPlacarJogo(int idJogo, int placarEqp1, int placarEqp2 , int idCampeonato){
		BaseDados.atualizaPlacarJogo(idJogo, placarEqp1, placarEqp2, idCampeonato);
	}
	
	public void atualizaStatusJogo(String status, int idJogo){
		BaseDados.atualizaStatusJogo(status, idJogo);
	}
	
	public Jogo getJogo (int id){
		return BaseDados.getJogo(id);
	}
*/
	public String updateJogo(Jogo jogo){
		BD_Jogo jogoBD = new BD_Jogo();
		return jogoBD.alteraJogo(jogo);
	}
	
}
