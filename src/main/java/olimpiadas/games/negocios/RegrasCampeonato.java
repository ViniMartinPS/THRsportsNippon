package olimpiadas.games.negocios;

import java.util.ArrayList;

import olimpiadas.games.banco.BaseDados;
import olimpiadas.games.bd.BD_Campeonato;
import olimpiadas.games.bd.BD_Classificacao;
import olimpiadas.games.bd.BD_Jogo;
import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.CampeonatoJSON;
import olimpiadas.games.modelo.Classificacao;
import olimpiadas.games.modelo.Jogo;

public class RegrasCampeonato {
	/*
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
	*/
	public Campeonato getCampeonatoBD(String esporte){
		Campeonato campeonato = new Campeonato();
		
		BD_Campeonato bdCamp = new BD_Campeonato();
		BD_Jogo bdJogo = new BD_Jogo();
		BD_Classificacao bdClassificacoes = new BD_Classificacao();
		
		campeonato = bdCamp.getCampeonato(esporte);
		campeonato = bdJogo.getJogosCampeonato(campeonato);
		campeonato = bdJogo.getJogosMataMata(campeonato);
		campeonato = bdClassificacoes.getClassificacoesCampeonato(campeonato);
		return campeonato;
	}
	
	public void updateClassificacao(String esporte){
		Campeonato campeonato = getCampeonatoBD(esporte);
		for (int eqpCount = 1 ; eqpCount<=6 ; eqpCount++){
			ArrayList<Jogo> listaJogos = new ArrayList<Jogo>();
			for (int i = 0;i<campeonato.getJogosGrupo1().size();i++){
				if (campeonato.getJogosGrupo1().get(i).getIdEquipe1() == eqpCount ||
						campeonato.getJogosGrupo1().get(i).getIdEquipe2() == eqpCount){
					listaJogos.add(campeonato.getJogosGrupo1().get(i));
				}
			}
			
			for (int i = 0;i<campeonato.getJogosGrupo2().size();i++){
				if (campeonato.getJogosGrupo2().get(i).getIdEquipe1() == eqpCount ||
						campeonato.getJogosGrupo2().get(i).getIdEquipe2() == eqpCount){
					listaJogos.add(campeonato.getJogosGrupo2().get(i));
				}
			}

			Classificacao classificacao = verificaEquipe(listaJogos,eqpCount, campeonato.getId());
			BD_Classificacao classBD = new BD_Classificacao();
			classBD.updateClassificacao(classificacao);
		}
		
		
	}
	
	public Classificacao verificaEquipe(ArrayList<Jogo> listaJogos, int idEquipe, int idCampeonato){
		Classificacao classificacao = new Classificacao();

		classificacao.setIdCampeonato(idCampeonato);
		classificacao.setIdEqp(idEquipe);
		
		int pros = 0;
		int contra = 0;
		int pontos = 0;
				
		for (int i = 0 ; i<listaJogos.size(); i++){
			if (listaJogos.get(i).getIdEquipe1() == idEquipe){
				pros = pros + listaJogos.get(i).getPlacarEqp1();
				contra = contra + listaJogos.get(i).getPlacarEqp2();
				if (listaJogos.get(i).getPlacarEqp1() > listaJogos.get(i).getPlacarEqp2()) pontos = pontos + 3;
				else if (listaJogos.get(i).getPlacarEqp1() == listaJogos.get(i).getPlacarEqp2()) pontos = pontos + 1;
				else pontos = pontos + 0;
			}
			else {
				pros = pros + listaJogos.get(i).getPlacarEqp2();
				contra = contra + listaJogos.get(i).getPlacarEqp1();
				if (listaJogos.get(i).getPlacarEqp2() > listaJogos.get(i).getPlacarEqp1()) pontos = pontos + 3;
				else if (listaJogos.get(i).getPlacarEqp2() == listaJogos.get(i).getPlacarEqp1()) pontos = pontos + 1;
				else pontos = pontos + 0;
			}
			
		}
		
		classificacao.setContra(contra);
		classificacao.setPos(pros);
		classificacao.setPontos(pontos);
		classificacao.setSaldo(pros - contra);
		
		return classificacao;
		
	}
	
	public void inicializaMataMata(String esporte){
		Campeonato campeonato = getCampeonatoBD(esporte);
		BD_Jogo bdJogo = new BD_Jogo();
		boolean finalizado = true;
		for (int i = 0;i<campeonato.getJogosGrupo1().size();i++){
			if (campeonato.getJogosGrupo1().get(i).getStatus().equals("NAO INICIADO") || campeonato.getJogosGrupo2().get(i).getStatus().equals("NAO INICIADO")){
				finalizado = false;
				return;
			}
		}
		if (finalizado){
			for (int i = 0; i<campeonato.getJogosMataMata().size();i++){
				if (campeonato.getJogosMataMata().get(i).getIdEquipe1() == 0 && 
						campeonato.getJogosMataMata().get(i).getFaseLevel() == 2 ){
							finalizado = false;
						}
			}
			
			if (!finalizado){
				int idEquipe1Grupo1 = campeonato.getGrupo1().get(0).getIdEqp();
							int idEquipe2Grupo1 = campeonato.getGrupo1().get(1).getIdEqp();
							int idEquipe1Grupo2 = campeonato.getGrupo2().get(0).getIdEqp();
							int idEquipe2Grupo2 = campeonato.getGrupo2().get(1).getIdEqp();
							
							campeonato.getJogosMataMata().get(0).setIdEquipe1(idEquipe1Grupo1);
							campeonato.getJogosMataMata().get(0).setIdEquipe2(idEquipe2Grupo2);
							bdJogo.alteraMataMata(campeonato.getJogosMataMata().get(0));
							
							campeonato.getJogosMataMata().get(1).setIdEquipe1(idEquipe2Grupo1);
							campeonato.getJogosMataMata().get(1).setIdEquipe2(idEquipe1Grupo2);
							bdJogo.alteraMataMata(campeonato.getJogosMataMata().get(1));
							return;
			}
			finalizado = false;
			for (int i = 0; i<campeonato.getJogosMataMata().size();i++){
				if (campeonato.getJogosMataMata().get(i).getIdEquipe1() == 0 && 
						campeonato.getJogosMataMata().get(i).getFaseLevel() >= 3){
							finalizado = true;
			}
		}
			
			if (finalizado){
				for (int i = 0; i<campeonato.getJogosMataMata().size();i++){
					if (campeonato.getJogosMataMata().get(i).getFaseLevel()==2 && 
							campeonato.getJogosMataMata().get(i).getStatus().equals("NAO INICIADO")){
						finalizado = false;
						return;
					}
				}
			}
			
			if (finalizado){
							int idEquipe1Final=0;
							int idEquipe2Final=0;
							int idEquipe1TerQuar=0;
							int idEquipe2TerQuar=0;
							
							if (campeonato.getJogosMataMata().get(0).getPlacarEqp1() > 
							campeonato.getJogosMataMata().get(0).getPlacarEqp2() ){
								idEquipe1Final = campeonato.getJogosMataMata().get(0).getIdEquipe1();
								idEquipe1TerQuar = campeonato.getJogosMataMata().get(0).getIdEquipe2();
							} else if(campeonato.getJogosMataMata().get(0).getPlacarEqp1() < 
							campeonato.getJogosMataMata().get(0).getPlacarEqp2() ){
								idEquipe1Final = campeonato.getJogosMataMata().get(0).getIdEquipe2();
								idEquipe1TerQuar = campeonato.getJogosMataMata().get(0).getIdEquipe1();
							} 	

							if (campeonato.getJogosMataMata().get(1).getPlacarEqp1() > 
							campeonato.getJogosMataMata().get(1).getPlacarEqp2() ){
								idEquipe2Final = campeonato.getJogosMataMata().get(1).getIdEquipe1();
								idEquipe2TerQuar = campeonato.getJogosMataMata().get(1).getIdEquipe2();
							} else if(campeonato.getJogosMataMata().get(1).getPlacarEqp1() < 
							campeonato.getJogosMataMata().get(1).getPlacarEqp2() ){
								idEquipe2Final = campeonato.getJogosMataMata().get(1).getIdEquipe2();
								idEquipe2TerQuar = campeonato.getJogosMataMata().get(1).getIdEquipe1();
							} 	
							
							campeonato.getJogosMataMata().get(3).setIdEquipe1(idEquipe1Final);
							campeonato.getJogosMataMata().get(3).setIdEquipe2(idEquipe2Final);
							bdJogo.alteraMataMata(campeonato.getJogosMataMata().get(3));
							
							campeonato.getJogosMataMata().get(2).setIdEquipe1(idEquipe1TerQuar);
							campeonato.getJogosMataMata().get(2).setIdEquipe2(idEquipe2TerQuar);
							bdJogo.alteraMataMata(campeonato.getJogosMataMata().get(2));
							return;
						}
			}
		}
}
