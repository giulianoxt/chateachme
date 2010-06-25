package projeto_web.managedbean;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import projeto_web.service.UsuarioBeanLocal;

/**
 * Session Bean implementation class GerenciadorUsuario
 */
@LocalBean
@Stateless
public class GerenciadorUsuario {
	@EJB
	private UsuarioBeanLocal usuarioBean;
	
	private String login;
	private String senha;
	private String nome;
	private String email;
	
    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * Default constructor. 
     */
    public GerenciadorUsuario() {
        // TODO Auto-generated constructor stub
    }
    
    public String cadastrarUsuario()
    {
    	usuarioBean.cadastrarUsuario(login, senha, nome, email);
    	
    	return "success";
    }

}
