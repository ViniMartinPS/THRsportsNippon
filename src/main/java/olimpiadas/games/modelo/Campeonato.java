package olimpiadas.games.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Campeonato {

	private int id;
	private String nome;
	private ArrayList<Integer> jogosGrupo1;
	private ArrayList<Integer> jogosGrupo2;
	private HashMap<Integer,Integer>  grupo1;
	private HashMap<Integer,Integer>  grupo2;
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
	public ArrayList<Integer> getJogosGrupo1() {
		return jogosGrupo1;
	}
	public void setJogosGrupo1(ArrayList<Integer> jogosGrupo1) {
		this.jogosGrupo1 = jogosGrupo1;
	}
	public ArrayList<Integer> getJogosGrupo2() {
		return jogosGrupo2;
	}
	public void setJogosGrupo2(ArrayList<Integer> jogosGrupo2) {
		this.jogosGrupo2 = jogosGrupo2;
	}
	public HashMap<Integer, Integer> getGrupo1() {
		return grupo1;
	}
	public void setGrupo1(HashMap<Integer, Integer> grupo1) {
		this.grupo1 = grupo1;
	}
	public HashMap<Integer, Integer> getGrupo2() {
		return grupo2;
	}
	public void setGrupo2(HashMap<Integer, Integer> grupo2) {
		this.grupo2 = grupo2;
	}
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	
	
	
}
