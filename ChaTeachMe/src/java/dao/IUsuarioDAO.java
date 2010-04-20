package dao;

import java.util.Collection;

public interface IUsuarioDAO {
  public String getLogin();
  public void setLogin(String login) throws DAOException;

  public byte[] getSenha();
  public void setSenha(byte[] senha);

  public String getNome();
  public void setNome(String nome);

  public String getEmail();
  public void setEmail(String email);

  public Collection getMensagensEnviadas();
  public Collection getSituacoesUsuarioSala();
}
