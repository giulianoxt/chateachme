package projeto_web.service;
import javax.ejb.Local;

@Local
public interface UsuarioBeanLocal {
	public void cadastrarUsuario(String login, String senha, String nome, String email);
	public void cadastrarProfessor(String login, String senha, String nome, String email);
}
