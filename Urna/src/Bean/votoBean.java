package Bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.urnaDAO;
import Entidades.Candidato;
import Entidades.Eleitor;
import Entidades.Pessoa;
import Entidades.Votacao;
import Entidades.Voto;
@ManagedBean(name = "votoBean")
@ViewScoped
public class votoBean {
	private Voto voto = new Voto();
	private Candidato candidato = new Candidato();
	private urnaDAO urna = new urnaDAO();
	private List<Votacao> lista = new ArrayList<Votacao>();
	private List<Votacao> segundoTurno = new ArrayList<Votacao>();
	private Pessoa pessoa = new Pessoa();
	
	public List<Votacao> getSegundoTurno() throws ClassNotFoundException{
		this.segundoTurno = urna.segundoTurno();
		return segundoTurno;
	}
	public List<Votacao> getLista() throws ClassNotFoundException{
		this.lista = urna.cadastrarVotacao();
		for(Votacao e : this.lista){
			System.out.println(e.getNome());
			System.out.println(e.getNum());
		}
		return lista;
	}
	
	public void setLista(List<Votacao> lista) {
		this.lista = lista;
	}

	public int votosBrancos() throws ClassNotFoundException{
		return urna.votosBrancos();
	}
	
	public int votosNulos() throws ClassNotFoundException{
		return urna.votosNulos();
	}
	public String maisVotado() throws ClassNotFoundException{
		return urna.maisVotado();
	}
	public String menosVotado() throws ClassNotFoundException{
		return urna.menosVotado();
	}
	public int eleitores() throws ClassNotFoundException{
		return urna.eleitores();
	}
	public void votar() throws SQLException, ClassNotFoundException{
		voto.setBranco("F");
		voto.setNulo("F");
		String x = urna.cadastrarVoto(voto, candidato, pessoa);
		if(x=="votou"){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto efetuado com sucesso", "Voto realizado!"));
		}else if(x=="candidatonaoexiste"){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Candidato não existe!", "Voto não realizado!"));
		}
		voto = new Voto();
	}
	
	public void votoBranco() throws SQLException, ClassNotFoundException{
		voto.setNulo("F");
		voto.setBranco("V");
		voto.setNum(0);
		urna.cadastrarVoto(voto, candidato, pessoa);
		voto = new Voto();
	}
	
	public void votoNulo() throws SQLException, ClassNotFoundException{
		voto.setBranco("F");
		voto.setNulo("V");
		voto.setNum(0);
		urna.cadastrarVoto(voto, candidato, pessoa);
		voto = new Voto();
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	
	public String candidatoEleito(Votacao voto) throws ClassNotFoundException{
		return urna.candidatoEleito(voto);
	}
}
