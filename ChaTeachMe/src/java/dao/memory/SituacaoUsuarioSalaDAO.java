package dao.memory;

import dao.*;

public class SituacaoUsuarioSalaDAO implements ISituacaoUsuarioSalaDAO {
  private String salaTitulo;
  private String usuarioLogin;
  private String situacao;
  private Integer tempoEmSala;

  public ISalaDAO getSala() {
    return MemoryDAOFactory.getInstance().findSala(salaTitulo);
  }

  public void setSala(ISalaDAO sala) throws DAOException {
    this.salaTitulo = sala.getTitulo();
  }

  public IUsuarioDAO getUsuario() {
    return MemoryDAOFactory.getInstance().findUsuario(usuarioLogin);
  }

  public void setUsuario(IUsuarioDAO usuario) throws DAOException {
    this.usuarioLogin = usuario.getLogin();
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) throws DAOException {
    this.situacao = situacao;
  }

  public Integer getTempoEmSala() {
    return tempoEmSala;
  }

  public void setTempoEmSala(Integer tempoEmSala) throws DAOException {
    this.tempoEmSala = tempoEmSala;
  }
}
