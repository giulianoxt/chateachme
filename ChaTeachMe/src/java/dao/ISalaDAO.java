package dao;

import java.util.Collection;
import java.util.Date;

public interface ISalaDAO {
  public void insertSala(ISalaDAO sala);
  public void deleteSala(ISalaDAO sala);

  public ISalaDAO findSala(String titulo);
  public Collection findAll();

  public String getDescricao();
  public void setDescricao(String descricao);

  public Date getDataCriacao();
  public void setDataCriacao(Date data);

  public Integer getIpCamera();
  public void setIpCamera(Integer ip);

  public Collection getMensagens();
  public Collection getSituacoesAlunoSala();
}
