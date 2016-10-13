package olimpiadas.games.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.Jogo;

public class BD_Jogo {

	public Campeonato getJogosCampeonato(Campeonato campeonato){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		ArrayList<Jogo> jogosGrupo1 = new ArrayList<Jogo>();
		ArrayList<Jogo> jogosGrupo2 = new ArrayList<Jogo>();
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "select* from table_jogo where idCampeonato = " + campeonato.getId() + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				int grupo = rs.getInt("idGrupo");
				if (grupo == 1){
					Jogo jogo = new Jogo();
					jogo.setId(rs.getInt("idJogo"));
					jogo.setIdEquipe1(rs.getInt("idEqp1"));
					jogo.setIdEquipe2(rs.getInt("idEqp2"));
					jogo.setPlacarEqp1(rs.getInt("placarEquipe1"));
					jogo.setPlacarEqp2(rs.getInt("placarEquipe2"));
					jogo.setLocal(rs.getString("local_jogo"));
					jogo.setEsporte(rs.getString("esporte"));
					jogo.setStatus(rs.getString("status_jogo"));
					jogo.setFaseLevel(grupo -1);
					jogosGrupo1.add(jogo);
				} else if (grupo == 2){
					Jogo jogo = new Jogo();
					jogo.setId(rs.getInt("idJogo"));
					jogo.setIdEquipe1(rs.getInt("idEqp1"));
					jogo.setIdEquipe2(rs.getInt("idEqp2"));
					jogo.setPlacarEqp1(rs.getInt("placarEquipe1"));
					jogo.setPlacarEqp2(rs.getInt("placarEquipe2"));
					jogo.setLocal(rs.getString("local_jogo"));
					jogo.setEsporte(rs.getString("esporte"));
					jogo.setStatus(rs.getString("status_jogo"));
					jogo.setFaseLevel(grupo -1);
					jogosGrupo2.add(jogo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		campeonato.setJogosGrupo1(jogosGrupo1);
		campeonato.setJogosGrupo2(jogosGrupo2);
		return campeonato;
	}

		
	public String alteraJogo(Jogo jogo){
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "update table_jogo set placarEquipe1 = ?, placarEquipe2 = ?, local_jogo = ? , status_jogo = ? where idJogo = "+ jogo.getId() + ";";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setInt(1, jogo.getPlacarEqp1());
			stm.setInt(2, jogo.getPlacarEqp2());
			stm.setString(3, jogo.getLocal());
			stm.setString(4, jogo.getStatus());
			
			stm.executeUpdate();
			}catch (SQLException e){

				return "Error";
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
		}
		return "Jogo Atualizado";
	}
	
	public String alteraMataMata(Jogo jogo){
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "update table_jogo set idEqp1 = ?, idEqp2 = ? where idJogo = "+ jogo.getId() + ";";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setInt(1, jogo.getIdEquipe1());
			stm.setInt(2, jogo.getIdEquipe2());
			
			stm.executeUpdate();
			}catch (SQLException e){

				return "Error";
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
		}
		return "Jogo Atualizado";
	}
	
		public Campeonato getJogosMataMata(Campeonato campeonato){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		ArrayList<Jogo> jogosMataMata = new ArrayList<Jogo>();
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "select* from table_jogo where idCampeonato = " + campeonato.getId() + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				int grupo = rs.getInt("idGrupo");
				if (grupo >= 3){
					Jogo jogo = new Jogo();
					jogo.setId(rs.getInt("idJogo"));
					jogo.setIdEquipe1(rs.getInt("idEqp1"));
					jogo.setIdEquipe2(rs.getInt("idEqp2"));
					jogo.setPlacarEqp1(rs.getInt("placarEquipe1"));
					jogo.setPlacarEqp2(rs.getInt("placarEquipe2"));
					jogo.setLocal(rs.getString("local_jogo"));
					jogo.setEsporte(rs.getString("esporte"));
					jogo.setStatus(rs.getString("status_jogo"));
					jogo.setFaseLevel(grupo-1);
					jogosMataMata.add(jogo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		campeonato.setJogosMataMata(jogosMataMata);
		return campeonato;
	}
}
