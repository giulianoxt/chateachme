package dao;

import java.util.Collection;
import java.util.Date;

public interface ISalaDAO {
  public String getTitulo();
  public void setTitulo(String titulo) throws DAOException;

  public Boolean isSalaAberta();
  public void setSalaAberta(Boolean salaAberta);

  public String getDescricao();
  public void setDescricao(String descricao);

  public Date getDataCriacao();
  public void setDataCriacao(Date data);

  public Integer getIpCamera();
  public void setIpCamera(Integer ip);

  public Collection getMensagens();
  public Collection getSituacoesUsuarioSala();
}
