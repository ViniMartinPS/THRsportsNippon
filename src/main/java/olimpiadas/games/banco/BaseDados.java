package olimpiadas.games.banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import olimpiadas.games.modelo.Campeonato;
import olimpiadas.games.modelo.CampeonatoJSON;
import olimpiadas.games.modelo.Equipe;
import olimpiadas.games.modelo.Jogo;

public class BaseDados {

	/*
	public static Equipe equipe1 ;
	public static Equipe equipe2 ;
	public static Equipe equipe3 ;
	public static Equipe equipe4 ;
	public static Equipe equipe5 ;
	public static Equipe equipe6 ;
	public static Jogo jogo1 ;
	public static Jogo jogo2 ;
	public static Jogo jogo3 ;
	public static Jogo jogo4 ;
	public static Jogo jogo5 ;
	public static Jogo jogo6 ;
	public static HashMap<Integer, Integer> grupo1 ;
	public static HashMap<Integer, Integer> grupo2 ;
	public static ArrayList<Integer> jogosGrupo1 ;
	public static ArrayList<Integer> jogosGrupo2 ;
	public static Campeonato campeonato ;
	
	
	public static void inicialize(){
		
		   equipe1 = new Equipe();
		   equipe2 = new Equipe();
		   equipe3 = new Equipe();
		   equipe4 = new Equipe();
		   equipe5 = new Equipe();
		   equipe6 = new Equipe();
		   jogo1 = new Jogo();
		   jogo2 = new Jogo();
		   jogo3 = new Jogo();
		   jogo4 = new Jogo();
		   jogo5 = new Jogo();
		   jogo6 = new Jogo();
		   grupo1 = new HashMap<Integer,Integer>();
		   grupo2 = new HashMap<Integer,Integer>();
		   jogosGrupo1 = new ArrayList<Integer>();
		   jogosGrupo2 = new ArrayList<Integer>();
		   campeonato = new Campeonato();
		
		equipe1.setId(1);
		equipe1.setJogadores(null);
		equipe1.setNome("Brasil");
		createEquipe(equipe1);
		
		equipe2.setId(2);
		equipe2.setJogadores(null);
		equipe2.setNome("Alemanha");
		createEquipe(equipe2);
			
		equipe3.setId(3);
		equipe3.setJogadores(null);
		equipe3.setNome("Franca");
		createEquipe(equipe3);
		
		equipe4.setId(4);
		equipe4.setJogadores(null);
		equipe4.setNome("Brasil1");
		createEquipe(equipe4);
		
		equipe5.setId(5);
		equipe5.setJogadores(null);
		equipe5.setNome("Alemanha1");
		createEquipe(equipe5);
		
		equipe6.setId(6);
		equipe6.setJogadores(null);
		equipe6.setNome("Franca1");
		createEquipe(equipe6);
		
		jogo1.setEquipe1(equipe1);
		jogo1.setEquipe2(equipe2);
		jogo1.setEsporte("Futebol");
		jogo1.setId(1);
		jogo1.setLocal("Campo1");
		jogo1.setPlacarEqp1(4);
		jogo1.setPlacarEqp2(2);
		jogo1.setStatus("ABERTO");
		createJogo(jogo1);
		
		jogo2.setEquipe1(equipe1);
		jogo2.setEquipe2(equipe3);
		jogo2.setEsporte("Futebol");
		jogo2.setId(2);
		jogo2.setLocal("Campo2");
		jogo2.setPlacarEqp1(2);
		jogo2.setPlacarEqp2(1);
		jogo2.setStatus("ABERTO");
		createJogo(jogo2);
		
		jogo3.setEquipe1(equipe2);
		jogo3.setEquipe2(equipe3);
		jogo3.setEsporte("Futebol");
		jogo3.setId(3);
		jogo3.setLocal("Campo1");
		jogo3.setPlacarEqp1(1);
		jogo3.setPlacarEqp2(0);
		jogo3.setStatus("FECHADO");
		createJogo(jogo3);
		
		jogo4.setEquipe1(equipe4);
		jogo4.setEquipe2(equipe5);
		jogo4.setEsporte("Futebol");
		jogo4.setId(4);
		jogo4.setLocal("Campo1");
		jogo4.setPlacarEqp1(6);
		jogo4.setPlacarEqp2(2);
		jogo4.setStatus("NAO INICIADO");
		createJogo(jogo4);
		
		jogo5.setEquipe1(equipe4);
		jogo5.setEquipe2(equipe6);
		jogo5.setEsporte("Futebol");
		jogo5.setId(5);
		jogo5.setLocal("Campo1");
		jogo5.setPlacarEqp1(5);
		jogo5.setPlacarEqp2(2);
		jogo5.setStatus("NAO INICIADO");
		createJogo(jogo5);
		
		jogo6.setEquipe1(equipe5);
		jogo6.setEquipe2(equipe6);
		jogo6.setEsporte("Futebol");
		jogo6.setId(6);
		jogo6.setLocal("Campo1");
		jogo6.setPlacarEqp1(3);
		jogo6.setPlacarEqp2(1);
		jogo6.setStatus("FECHADO");
		createJogo(jogo6);
		
		grupo1.put(equipe1.getId(), 6);
		grupo1.put(equipe2.getId(), 3);
		grupo1.put(equipe3.getId(), 0);
		
		grupo2.put(equipe4.getId(), 6);
		grupo2.put(equipe5.getId(), 3);
		grupo2.put(equipe6.getId(), 0);
		
		jogosGrupo1.add(jogo1.getId());
		jogosGrupo1.add(jogo2.getId());
		jogosGrupo1.add(jogo3.getId());
		
		jogosGrupo2.add(jogo4.getId());
		jogosGrupo2.add(jogo5.getId());
		jogosGrupo2.add(jogo6.getId());
		
		
		campeonato.setEsporte("Futebol");
		campeonato.setGrupo1(grupo1);
		campeonato.setGrupo2(grupo2);
		campeonato.setId(1);
		campeonato.setNome("Fut");
		campeonato.setJogosGrupo1(jogosGrupo1);
		campeonato.setJogosGrupo2(jogosGrupo2);
		createCampeonato("Fut", "Futebol");
		insereEquipeCampeonato(1, "Futebol", 1);
		insereEquipeCampeonato(2, "Futebol", 1);
		insereEquipeCampeonato(3, "Futebol", 1);
		insereEquipeCampeonato(4, "Futebol", 2);
		insereEquipeCampeonato(5, "Futebol", 2);
		insereEquipeCampeonato(6, "Futebol", 2);
		insereJogoCampeonato(1, 1, 1);
		insereJogoCampeonato(2, 1, 1);
		insereJogoCampeonato(3, 1, 1);
		insereJogoCampeonato(4, 1, 2);
		insereJogoCampeonato(5, 1, 2);
		insereJogoCampeonato(6, 1, 2);
		
	}
	
	public static void createEquipe(Equipe equipe){
		BancoEquipe.id.add(BancoEquipe.id.size() + 1);
		BancoEquipe.nomeEquipe.add(equipe.getNome());
		BancoEquipe.jogadores.add(equipe.getJogadores());
	}
	
	public static Equipe getEquipe(int id){
		
		for (int i = 0;i <BancoEquipe.id.size();i++){
			if (BancoEquipe.id.get(i) == id){
				Equipe equipe = new Equipe();
				equipe.setNome(BancoEquipe.nomeEquipe.get(i));
				equipe.setId(BancoEquipe.id.get(i));
				equipe.setJogadores(BancoEquipe.jogadores.get(i));
				return equipe;
			}
		}
		return null;		
	}
	
	public static void createJogo(Jogo jogo){
		BaseJogo.equipe1.add(jogo.getEquipe1().getId());
		BaseJogo.equipe2.add(jogo.getEquipe2().getId());
		BaseJogo.esporte.add(jogo.getEsporte());
		BaseJogo.id.add(BaseJogo.id.size() + 1);
		BaseJogo.status.add(jogo.getStatus());
		BaseJogo.local.add(jogo.getLocal());
		BaseJogo.placarEqp1.add(jogo.getPlacarEqp1());
		BaseJogo.placarEqp2.add(jogo.getPlacarEqp2());
	}
	
	public static Jogo getJogo(int id){
		for (int i = 0;i <BancoEquipe.id.size(); i++){
			if (BaseJogo.id.get(i) == id ){
				Jogo jogo = new Jogo();
				jogo.setEquipe1(getEquipe(BaseJogo.equipe1.get(i)));
				jogo.setEquipe2(getEquipe(BaseJogo.equipe2.get(i)));
				jogo.setEsporte(BaseJogo.esporte.get(i));	
				jogo.setStatus(BaseJogo.status.get(i));
				jogo.setLocal(BaseJogo.local.get(i));
				jogo.setPlacarEqp1(BaseJogo.placarEqp1.get(i));
				jogo.setPlacarEqp2(BaseJogo.placarEqp2.get(i));
				return jogo;
			}
		}
		return null;
	}
	
	public static ArrayList<Jogo> getAllJogos(){
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();

		for (int i = 0;i<BaseJogo.id.size() ; i++){
			Jogo jogo = new Jogo();
			jogo.setEquipe1(getEquipe(BaseJogo.equipe1.get(i)));
			jogo.setEquipe2(getEquipe(BaseJogo.equipe2.get(i)));
			jogo.setEsporte(BaseJogo.esporte.get(i));	
			jogo.setLocal(BaseJogo.local.get(i));
			jogo.setPlacarEqp1(BaseJogo.placarEqp1.get(i));
			jogo.setPlacarEqp2(BaseJogo.placarEqp2.get(i));
			jogos.add(jogo);
		}
		
		return jogos;
	}
	
	public static void createCampeonato(String nome, String esporte){
		BaseCampeonato.id.add(BaseCampeonato.id.size() + 1);
		BaseCampeonato.esporte.add(esporte);
		BaseCampeonato.grupo1.add(new HashMap<Integer,Integer>());
		BaseCampeonato.grupo2.add(new HashMap<Integer, Integer>());
		BaseCampeonato.jogosGrupo1.add(new ArrayList<Integer>());
		BaseCampeonato.jogosGrupo2.add(new ArrayList<Integer>());
		BaseCampeonato.nome.add(nome);
	}
	
	public static void insereEquipeCampeonato(int idEquipe, String esporteCampeonato, int grupo){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.esporte.get(i).equals(esporteCampeonato)){
				if (grupo ==1){
					BaseCampeonato.grupo1.get(i).put(idEquipe, 0);
				} else if (grupo ==2){
					BaseCampeonato.grupo2.get(i).put(idEquipe, 0);
				}
			}
		}
		
		
	}
	
	public static void insereJogoCampeonato(int idJogo, int idCampeonato, int grupo){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.id.get(i) == idCampeonato){
				if (grupo ==1){
					BaseCampeonato.jogosGrupo1.get(i).add(idJogo);
				} else if (grupo ==2){
					BaseCampeonato.jogosGrupo2.get(i).add(idJogo);
				}
			}
		}
	}
	
	public static void atualizaPlacarJogo(int idJogo, int placarEqp1, int placarEqp2 , int idCampeonato){
		for (int i = 0; i>BaseCampeonato.id.size(); i++){
			if  (BaseCampeonato.id.get(i) == idCampeonato){
				for (int j = 0 ; j< BaseCampeonato.grupo1.get(i).size() ; j++){
					if (BaseCampeonato.jogosGrupo1.get(i).contains(idJogo)){
						getJogo(idJogo).setPlacarEqp1(placarEqp1);
						getJogo(idJogo).setPlacarEqp2(placarEqp2);
					}
					else if (BaseCampeonato.jogosGrupo2.get(i).contains(idJogo)){
						getJogo(idJogo).setPlacarEqp1(placarEqp1);
						getJogo(idJogo).setPlacarEqp2(placarEqp2);
					}
				}
			}
		}
	}
	
	public static CampeonatoJSON atualizaClassificacao(Campeonato campeonato){
		CampeonatoJSON camp = new CampeonatoJSON();
		
		HashMap<Equipe,Integer> grupo1 = new HashMap<Equipe,Integer>();
		for (Map.Entry<Integer,Integer> entry : campeonato.getGrupo1().entrySet()) {
		    Equipe key = getEquipe(entry.getKey());
		    Integer value = entry.getValue();
		    grupo1.put(key, value);
		}
		
		HashMap<Equipe,Integer> grupo2 = new HashMap<Equipe,Integer>();
		for (Map.Entry<Integer,Integer> entry : campeonato.getGrupo2().entrySet()) {
		    Equipe key = getEquipe(entry.getKey());
		    Integer value = entry.getValue();
		    grupo2.put(key, value);
		}
		
		ArrayList<Jogo> jogosGrupo1 = new ArrayList<Jogo>();
		for (int i = 0 ; i<campeonato.getJogosGrupo1().size(); i++){
			jogosGrupo1.add(getJogo(campeonato.getJogosGrupo1().get(i)));
		}
		
		ArrayList<Jogo> jogosGrupo2 = new ArrayList<Jogo>();
		for (int i = 0 ; i<campeonato.getJogosGrupo2().size(); i++){
			jogosGrupo2.add(getJogo(campeonato.getJogosGrupo2().get(i)));
		}
		
		ArrayList<Equipe> grupo1Class = new ArrayList<Equipe>();
		for (Map.Entry<Integer,Integer> entry : campeonato.getGrupo1().entrySet()) {
		    grupo1Class.add(getEquipe(entry.getKey()));
		}
	
		ArrayList<Equipe> grupo2Class = new ArrayList<Equipe>();
		for (Map.Entry<Integer,Integer> entry : campeonato.getGrupo2().entrySet()) {
		    grupo2Class.add(getEquipe(entry.getKey()));
		}
		
		
		camp.setEsporte(campeonato.getEsporte());
		camp.setGrupo1(grupo1);
		camp.setGrupo2(grupo2);
		camp.setId(campeonato.getId());
		camp.setNome(campeonato.getNome());
		camp.setJogosGrupo1(jogosGrupo1);
		camp.setJogosGrupo2(jogosGrupo2);
		camp.setGrupo1Class(grupo1Class);
		camp.setGrupo2Class(grupo2Class);
		
		
		return camp;
	}
	
	public static void atualizaStatusJogo(String status, int idJogo){
		getJogo(idJogo).setStatus(status);
	}
	
	public static ArrayList<Campeonato> getCampeonatos (){
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();
		for (int i = 0 ; i<BaseCampeonato.id.size() ; i++){
			Campeonato campeonato = new Campeonato();
			campeonato.setEsporte(BaseCampeonato.esporte.get(i));
			campeonato.setGrupo1(BaseCampeonato.grupo1.get(i));
			campeonato.setGrupo2(BaseCampeonato.grupo2.get(i));
			campeonato.setId(BaseCampeonato.id.get(i));
			campeonato.setJogosGrupo1(BaseCampeonato.jogosGrupo1.get(i));
			campeonato.setJogosGrupo2(BaseCampeonato.jogosGrupo2.get(i));
			campeonato.setNome(BaseCampeonato.nome.get(i));
			listaCampeonatos.add(campeonato);
		}
		return listaCampeonatos;
	}
	
	public static void insereJogador(String nome, int idEquipe){
		getEquipe(idEquipe).setNome(nome);
	}
	
	public static CampeonatoJSON getCampeonato(String esporteCampeonato){
		for (int i = 0 ; i<BaseCampeonato.id.size() ; i++){
			if (BaseCampeonato.esporte.get(i).equals(esporteCampeonato)){
			Campeonato campeonato = new Campeonato();
			campeonato.setEsporte(BaseCampeonato.esporte.get(i));
			campeonato.setGrupo1(BaseCampeonato.grupo1.get(i));
			campeonato.setGrupo2(BaseCampeonato.grupo2.get(i));
			campeonato.setId(BaseCampeonato.id.get(i));
			campeonato.setJogosGrupo1(BaseCampeonato.jogosGrupo1.get(i));
			campeonato.setJogosGrupo2(BaseCampeonato.jogosGrupo2.get(i));
			campeonato.setNome(BaseCampeonato.nome.get(i));
			
			return atualizaClassificacao(campeonato);
			}
			
		}
		return null;
	}
	
	public static ArrayList<Equipe> getEquipes(){
		return null;
	}
	*/
}
