package olimpiadas.games.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.Classificacao;
import olimpiadas.games.modelo.Jogo;

public class BD_Classificacao {

	public Campeonato getClassificacoesCampeonato(Campeonato campeonato){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		ArrayList<Classificacao> grupo1 = new ArrayList<Classificacao>();
		ArrayList<Classificacao> grupo2 = new ArrayList<Classificacao>();
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "select* from table_classificacao where idCampeonato = " + campeonato.getId() + " ;";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				int grupo = rs.getInt("idGrupo");
				if (grupo == 1){
					Classificacao classificacao = new Classificacao();
					classificacao.setIdCampeonato(rs.getInt("idCampeonato"));
					classificacao.setIdEqp(rs.getInt("idEquipe"));
					classificacao.setPontos(rs.getInt("pontos"));
					classificacao.setPos(rs.getInt("pros"));
					classificacao.setContra(rs.getInt("contra"));
					classificacao.setSaldo(rs.getInt("saldo"));
					classificacao.setIdGrupo(rs.getInt("idGrupo"));
					classificacao.setPrioridade(rs.getInt("prioridade"));
					grupo1.add(classificacao);
				} else if (grupo == 2){
					Classificacao classificacao = new Classificacao();
					classificacao.setIdCampeonato(rs.getInt("idCampeonato"));
					classificacao.setIdEqp(rs.getInt("idEquipe"));
					classificacao.setPontos(rs.getInt("pontos"));
					classificacao.setPos(rs.getInt("pros"));
					classificacao.setContra(rs.getInt("contra"));
					classificacao.setSaldo(rs.getInt("saldo"));
					classificacao.setIdGrupo(rs.getInt("idGrupo"));
					classificacao.setPrioridade(rs.getInt("prioridade"));
					grupo2.add(classificacao);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		campeonato.setGrupo1(grupo1);
		campeonato.setGrupo2(grupo2);
		return ordenaClassificacao(campeonato);
	}

	public void updateClassificacao(Classificacao classificacao){
			String sqlUpdate;
			Connection conn = null;
			PreparedStatement stm = null;
			
			try {
				ConexaoBD bd = new ConexaoBD();
				conn = bd.obtemConexao();
				sqlUpdate = "update table_classificacao set pros = ?, contra = ?, pontos = ? , saldo = ? "
						+ "where idCampeonato = "+ classificacao.getIdCampeonato() + " AND "
						+ " idEquipe = " + classificacao.getIdEqp() + ";";

				stm = conn.prepareStatement(sqlUpdate);
				stm.setInt(1, classificacao.getPos());
				stm.setInt(2, classificacao.getContra());
				stm.setInt(3, classificacao.getPontos());
				stm.setInt(4, classificacao.getSaldo());
				
				stm.executeUpdate();
				}catch (SQLException e){

			}finally{
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e) {
					}
				}
				// fecha a conexao
				//
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		}
		
		public Campeonato ordenaClassificacao(Campeonato campeonato){
			ArrayList<Classificacao> newGrupo1 = new ArrayList<Classificacao>();
			ArrayList<Classificacao> newGrupo2 = new ArrayList<Classificacao>();
			
			for (int j =0 ; j<campeonato.getGrupo1().size();j=j){
			int maxPts =-1;
			int maxSald=-10;
			int indice =-1;
			for (int i = 0;i<campeonato.getGrupo1().size();i++){
				if ((campeonato.getGrupo1().get(i).getPontos() > maxPts) || 
				((campeonato.getGrupo1().get(i).getPontos() == maxPts) &&(campeonato.getGrupo1().get(i).getSaldo() > maxSald) )){
					maxPts = campeonato.getGrupo1().get(i).getPontos();
					maxSald = campeonato.getGrupo1().get(i).getSaldo(); 
					indice = i;
				} else if (((campeonato.getGrupo1().get(i).getPontos() == maxPts) &&(campeonato.getGrupo1().get(i).getSaldo() == maxSald) )){
					Jogo jogo = getJogoDesempate(campeonato,1,campeonato.getGrupo1().get(indice).getIdEqp(),campeonato.getGrupo1().get(i).getIdEqp());
					if (vencedor(jogo,i)){
					maxPts = campeonato.getGrupo1().get(i).getPontos();
					maxSald = campeonato.getGrupo1().get(i).getSaldo(); 
					indice = i;	
					} else if (empate(jogo)){
						if(campeonato.getGrupo1().get(i).getPrioridade() > campeonato.getGrupo1().get(indice).getPrioridade()){
							maxPts = campeonato.getGrupo1().get(i).getPontos();
							maxSald = campeonato.getGrupo1().get(i).getSaldo(); 
							indice = i;
						}
					}
				}
			}
			newGrupo1.add(campeonato.getGrupo1().get(indice));
			campeonato.getGrupo1().remove(indice);
			}
			
			for (int j =0 ; j<campeonato.getGrupo2().size();j=j){
			int maxPts =-1;
			int maxSald=-10;
			int indice =-1;
			for (int i = 0;i<campeonato.getGrupo2().size();i++){
				if ((campeonato.getGrupo2().get(i).getPontos() > maxPts) || ((campeonato.getGrupo2().get(i).getPontos() == maxPts) && (campeonato.getGrupo2().get(i).getSaldo() > maxSald) )){
					maxPts = campeonato.getGrupo2().get(i).getPontos();
					maxSald = campeonato.getGrupo2().get(i).getSaldo(); 
					indice = i;
				} else if ((campeonato.getGrupo2().get(i).getPontos() > maxPts) || 
				((campeonato.getGrupo2().get(i).getPontos() == maxPts) &&(campeonato.getGrupo2().get(i).getSaldo() == maxSald) )){
					Jogo jogo = getJogoDesempate(campeonato,2,campeonato.getGrupo2().get(indice).getIdEqp(),campeonato.getGrupo2().get(i).getIdEqp());
					if (vencedor(jogo,i)){
					maxPts = campeonato.getGrupo2().get(i).getPontos();
					maxSald = campeonato.getGrupo2().get(i).getSaldo(); 
					indice = i;	
					}else if (empate(jogo)){
						if(campeonato.getGrupo2().get(i).getPrioridade() > campeonato.getGrupo2().get(indice).getPrioridade()){
							maxPts = campeonato.getGrupo2().get(i).getPontos();
							maxSald = campeonato.getGrupo2().get(i).getSaldo(); 
							indice = i;
						}
					}
				}
			}
			newGrupo2.add(campeonato.getGrupo2().get(indice));
			campeonato.getGrupo2().remove(indice);
			}
			
			
			campeonato.setGrupo1(newGrupo1);
			campeonato.setGrupo2(newGrupo2);
			return campeonato;
			
			
		}
	
	public Jogo getJogoDesempate(Campeonato campeonato, int idGrupo, int idEqp1, int idEqp2){
		if (idGrupo == 1){
			for (int i = 0; i<campeonato.getJogosGrupo1().size();i++){
				if ((campeonato.getJogosGrupo1().get(i).getIdEquipe1() == idEqp1) &&
						(campeonato.getJogosGrupo1().get(i).getIdEquipe2() == idEqp2)
						||
						(campeonato.getJogosGrupo1().get(i).getIdEquipe2() == idEqp1) &&
						(campeonato.getJogosGrupo1().get(i).getIdEquipe1() == idEqp2)){
							return campeonato.getJogosGrupo1().get(i);
						}
			}
		} else if (idGrupo == 2){
			for (int i = 0; i<campeonato.getJogosGrupo2().size();i++){
				if ((campeonato.getJogosGrupo2().get(i).getIdEquipe1() == idEqp1) &&
						(campeonato.getJogosGrupo2().get(i).getIdEquipe2() == idEqp2)
						||
						(campeonato.getJogosGrupo2().get(i).getIdEquipe2() == idEqp1) &&
						(campeonato.getJogosGrupo2().get(i).getIdEquipe1() == idEqp2)){
							return campeonato.getJogosGrupo2().get(i);
						}
			}
		}
		return null;
	}
	
	public boolean vencedor(Jogo jogo, int idEqp){
		if (jogo.getIdEquipe1() == idEqp){
		if (jogo.getPlacarEqp1() > jogo.getPlacarEqp2()) return true;
		else return false;
		} else if (jogo.getIdEquipe2() == idEqp){
		if (jogo.getPlacarEqp1() < jogo.getPlacarEqp2()) return true;
		else return false;
		}
		return false;
	}
	
	public boolean empate (Jogo jogo){
		if (jogo.getPlacarEqp1() == jogo.getPlacarEqp2()) return true;
		else return false;
	}
	
}
