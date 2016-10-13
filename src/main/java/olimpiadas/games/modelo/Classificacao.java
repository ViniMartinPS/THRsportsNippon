package olimpiadas.games.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Classificacao{

	private int idCampeonato;
	private int idEqp;
	private int pontos;
	private int idGrupo;
	private int pos;
	private int contra;
	private int saldo;
	private int prioridade;
	public int getIdCampeonato() {
		return idCampeonato;
	}
	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	public int getIdEqp() {
		return idEqp;
	}
	public void setIdEqp(int idEqp) {
		this.idEqp = idEqp;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getContra() {
		return contra;
	}
	public void setContra(int contra) {
		this.contra = contra;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}


	
}