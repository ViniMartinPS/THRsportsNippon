package olimpiadas.games.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jogo {

	private int id;
	private int idEquipe1;
	private int idEquipe2;
	private int placarEqp1;
	private int placarEqp2;
	private String esporte;
	private String local;
	private String status;
	private int faseLevel;
	
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
	public int getIdEquipe1() {
		return idEquipe1;
	}
	public void setIdEquipe1(int idEquipe1) {
		this.idEquipe1 = idEquipe1;
	}
	public int getIdEquipe2() {
		return idEquipe2;
	}
	public void setIdEquipe2(int idEquipe2) {
		this.idEquipe2 = idEquipe2;
	}
	public int getFaseLevel() {
		return faseLevel;
	}
	public void setFaseLevel(int faseLevel) {
		this.faseLevel = faseLevel;
	}
	
}
