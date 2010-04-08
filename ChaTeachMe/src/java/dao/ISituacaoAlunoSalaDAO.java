package dao;

import java.util.Collection;

public interface ISituacaoAlunoSalaDAO {
  public void insertSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao);
  public void deleteSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao);

  public ISituacaoAlunoSalaDAO findSituacaoAlunoSala(
          ISalaDAO sala, IUsuarioDAO usuario);

  public Collection findAll();

  public ISalaDAO getSala();
  public void setSala(ISalaDAO sala);

  public IUsuarioDAO getUsuario();
  public void setUsuario(IUsuarioDAO usuario);

  public String getSituacao();
  public void setSituacao(String situacao);
}
