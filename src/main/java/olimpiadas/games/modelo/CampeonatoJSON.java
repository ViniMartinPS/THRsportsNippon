package olimpiadas.games.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CampeonatoJSON {

	private int id;
	private String nome;
	private ArrayList<Jogo> jogosGrupo1;
	private ArrayList<Jogo> jogosGrupo2;
	private HashMap<Equipe,Integer>  grupo1;
	private HashMap<Equipe,Integer>  grupo2;
	private ArrayList<Equipe> grupo1Class;
	private ArrayList<Equipe> grupo2Class;
	private String esporte;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Jogo> getJogosGrupo1() {
		return jogosGrupo1;
	}
	public void setJogosGrupo1(ArrayList<Jogo> jogosGrupo1) {
		this.jogosGrupo1 = jogosGrupo1;
	}
	public ArrayList<Jogo> getJogosGrupo2() {
		return jogosGrupo2;
	}
	public void setJogosGrupo2(ArrayList<Jogo> jogosGrupo2) {
		this.jogosGrupo2 = jogosGrupo2;
	}
	public HashMap<Equipe, Integer> getGrupo1() {
		return grupo1;
	}
	public void setGrupo1(HashMap<Equipe, Integer> grupo1) {
		this.grupo1 = grupo1;
	}
	public HashMap<Equipe, Integer> getGrupo2() {
		return grupo2;
	}
	public void setGrupo2(HashMap<Equipe, Integer> grupo2) {
		this.grupo2 = grupo2;
	}
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	public ArrayList<Equipe> getGrupo1Class() {
		return grupo1Class;
	}
	public void setGrupo1Class(ArrayList<Equipe> grupo1Class) {
		this.grupo1Class = grupo1Class;
	}
	public ArrayList<Equipe> getGrupo2Class() {
		return grupo2Class;
	}
	public void setGrupo2Class(ArrayList<Equipe> grupo2Class) {
		this.grupo2Class = grupo2Class;
	}
	
	
	
}
