package olimpiadas.games.bd;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import olimpiadas.games.modelo.Equipe;

public class BD_Equipe {

	public ArrayList<Equipe> getEquipes(){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		ArrayList<Equipe> listaEquipes = new ArrayList<Equipe>();
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "select* from table_equipe;";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				Equipe equipe = new Equipe();
				equipe.setId(rs.getInt("idEqp"));
				equipe.setNome(rs.getString("nomeEquipe"));
				listaEquipes.add(equipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEquipes;
	}
	
}
