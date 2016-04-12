package Bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.pessoaDAO;
import Entidades.Eleitor;
import Entidades.Pessoa;

@ManagedBean(name="eleitorBean")
@SessionScoped
public class eleitorBean {
	private Eleitor eleitor = new Eleitor();
	private pessoaDAO a = new pessoaDAO();
	
	public void adicionar() throws ClassNotFoundException, SQLException{
		boolean x = a.cadastrarEleitor(eleitor);
		if(x==false){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eleitor cadastrado!", "Eleitor cadastrado!"));
		}else{
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eleitor já existente!", "Eleitor já existente!"));
		}
		eleitor = new Eleitor();
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
}
