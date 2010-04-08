package dao;

import java.util.Date;
import java.util.Collection;

public interface IMensagemDAO {
  public void insertMensagem(IMensagemDAO mensagem);
  public void deleteMensagem(IMensagemDAO mensagem);

  public IMensagemDAO findMensagem(Integer id);
  public Collection findAll();

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
