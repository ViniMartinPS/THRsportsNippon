package olimpiadas.games.bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import olimpiadas.games.modelo.Campeonato;

public class BD_Campeonato {

	public Campeonato getCampeonato(String esporte){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		Campeonato campeonato = new Campeonato();
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "select* from table_campeonato where esporte = \"" + esporte + "\" ;";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				campeonato.setId(rs.getInt("idCampeonato"));
				campeonato.setNome(rs.getString("nomeCampeonato"));
				campeonato.setEsporte(rs.getString("esporte"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return campeonato;
	}
	
}
