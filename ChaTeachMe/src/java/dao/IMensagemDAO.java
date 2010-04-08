package dao;

import java.util.Date;

public interface IMensagemDAO {
  public Integer getId();
  public void setId(Integer id) throws DAOException;

  public String getMensagem();
  public void setMensagem(String mensagem);

  public Date getDataEnvio();
  public void setDataEnvio(Date data);

  public String getTipo();
  public void setTipo(String tipo);

  public ISalaDAO getSala();
  public void setSala(ISalaDAO sala);

  public IUsuarioDAO getUsuario();
  public void setUsuario(IUsuarioDAO usuario);
}
