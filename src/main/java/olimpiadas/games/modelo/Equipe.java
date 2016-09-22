package olimpiadas.games.modelo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Equipe {

	private int id;
	private String nome;
	private ArrayList<String> jogadores;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<String> jogadores) {
		this.jogadores = jogadores;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
