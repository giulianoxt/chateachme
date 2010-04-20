package dao.memory;

import dao.*;
import java.util.Collection;
import java.util.Date;

public class SalaDAO implements ISalaDAO {
  private String titulo;
  private String descricao;
  private Date dataCriacao;
  private Integer ipCamera;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) throws DAOException {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Date data) {
    this.dataCriacao = data;
  }

  public Integer getIpCamera() {
    return ipCamera;
  }

  public void setIpCamera(Integer ip) {
    this.ipCamera = ip;
  }

  public Collection getMensagens() {
    return MemoryDAOFactory.getInstance().findMensagensSala(this);
  }

  public Collection getSituacoesUsuarioSala() {
    return MemoryDAOFactory.getInstance().findSituacoesSala(this);
  }
}
