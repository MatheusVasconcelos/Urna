package Bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.pessoaDAO;
import Entidades.Candidato;

@ManagedBean(name="candidatoBean")
@SessionScoped
public class candidatoBean {
	private Candidato candidato = new Candidato();
	private pessoaDAO a = new pessoaDAO();
	
	public void adicionar() throws ClassNotFoundException{
		boolean z = a.verificarNum(candidato);
		if(z==true){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Número do candidato já existe!", "Número do candidato já existe!"));
		}
		if(z==false){
		boolean x = a.cadastrarCandidato(candidato);
		if(x==false){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidato cadastrado!", "Candidato cadastrado!"));
		}else{
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Candidato já existente!", "Candidato já existente!"));
		}
		}
		candidato = new Candidato();
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
