package Bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.pessoaDAO;
import Entidades.Pessoa;

@ManagedBean(name = "loginBean")
@ViewScoped
public class loginBean {
	private pessoaDAO a = new pessoaDAO();
	private Pessoa pessoa = new Pessoa();
	
	public String envia() throws ClassNotFoundException{
		boolean x = a.login(pessoa);
		if(x==false){
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return "false";
		}else{
			return "/funcoes.xhtml";
		}
	}
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
