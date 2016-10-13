package olimpiadas.games.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Campeonato {

	private int id;
	private String nome;
	private ArrayList<Jogo> jogosGrupo1;
	private ArrayList<Jogo> jogosGrupo2;
	private ArrayList<Jogo>jogosMataMata;
	private ArrayList<Classificacao> grupo1;
	private ArrayList<Classificacao> grupo2;
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
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	public ArrayList<Classificacao> getGrupo1() {
		return grupo1;
	}
	public void setGrupo1(ArrayList<Classificacao> grupo1) {
		this.grupo1 = grupo1;
	}
	public ArrayList<Classificacao> getGrupo2() {
		return grupo2;
	}
	public void setGrupo2(ArrayList<Classificacao> grupo2) {
		this.grupo2 = grupo2;
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
	public ArrayList<Jogo> getJogosMataMata() {
		return jogosMataMata;
	}
	public void setJogosMataMata(ArrayList<Jogo> jogosMataMata) {
		this.jogosMataMata = jogosMataMata;
	}
	
	
	
}
