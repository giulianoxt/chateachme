package projeto_web.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projeto_web.model.Professor;
import projeto_web.model.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {

	@PersistenceContext(name="projeto_jpa")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean existeUsuario(String usuario)
    {
    	return false;
    }
    
    public void cadastrarUsuario(String login, String senha, String nome, String email)
    {
    	Usuario usuario = new Usuario();
    	
    	usuario.setNome(nome);
    	usuario.setSenha(senha);
    	usuario.setLogin(login);
    	usuario.setEmail(email);
    	
    	em.persist(usuario);
    }
     
    public void cadastrarProfessor(String login, String senha, String nome, String email)
    {
    	Professor professor = new Professor();
    	
    	professor.setEmail(email);
    	professor.setNome(nome);
    	professor.setLogin(login);
    	professor.setSenha(senha);
    	
    	em.persist(professor);
    }
}
