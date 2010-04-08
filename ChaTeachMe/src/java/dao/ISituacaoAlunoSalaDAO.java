package dao;

public interface ISituacaoAlunoSalaDAO {
  public ISalaDAO getSala();
  public void setSala(ISalaDAO sala) throws DAOException;

  public IUsuarioDAO getUsuario();
  public void setUsuario(IUsuarioDAO usuario) throws DAOException;

  public String getSituacao();
  public void setSituacao(String situacao) throws DAOException;
}
