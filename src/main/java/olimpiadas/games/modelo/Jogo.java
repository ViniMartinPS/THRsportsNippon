package olimpiadas.games.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jogo {

	private int id;
	private Equipe equipe1;
	private Equipe equipe2;
	private int placarEqp1;
	private int placarEqp2;
	private String esporte;
	private String local;
	private String status;
	
	public Equipe getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}
	public Equipe getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	public int getPlacarEqp1() {
		return placarEqp1;
	}
	public void setPlacarEqp1(int placarEqp1) {
		this.placarEqp1 = placarEqp1;
	}
	public int getPlacarEqp2() {
		return placarEqp2;
	}
	public void setPlacarEqp2(int placarEqp2) {
		this.placarEqp2 = placarEqp2;
	}
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
