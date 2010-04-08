package dao;

import java.util.Collection;

public interface IUsuarioDAO {
  public String getLogin();
  public void setLogin(String login) throws DAOException;

  public String getSenha();
  public void setSenha(String senha);

  public String getNome();
  public void setNome(String nome);

  public String getEmail();
  public void setEmail(String email);

  public Collection getMensagensEnviadas();
  public Collection getSituacoesUsuarioSala();
}
