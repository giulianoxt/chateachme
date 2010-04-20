package dao.memory;

import dao.DAOException;
import dao.IUsuarioDAO;
import java.util.Collection;

public class UsuarioDAO implements IUsuarioDAO {
  private String login;
  private byte[] senha;
  private String nome;
  private String email;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) throws DAOException {
    this.login = login;
  }

  public byte[] getSenha() {
    return senha;
  }

  public void setSenha(byte[] senha) {
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

  public Collection getMensagensEnviadas() {
    return MemoryDAOFactory.getInstance().findMensagensUsuario(this);
  }

  public Collection getSituacoesUsuarioSala() {
    return MemoryDAOFactory.getInstance().findSituacoesUsuario(this);
  }

  public boolean isProfessor() {
    return false;
  }

  public boolean isAdministrador() {
    return false;
  }
}
