package dao;

import java.util.Collection;

public interface IUsuarioDAO {
  public void insertUsuario(IUsuarioDAO usuario);
  public void deleteUsuario(IUsuarioDAO usuario);

  public IUsuarioDAO findUsuario(String login);
  public Collection findAll();

  public String getLogin();
  public void setLogin(String login);

  public String getSenha();
  public void setSenha(String senha);

  public String getNome();
  public void setNome(String nome);

  public String getEmail();
  public void setEmail(String email);

  public Collection getMensagensEnviadas();
  public Collection getSituacoesAlunoSala();
}
