package dao.memory;

import dao.*;
import java.util.Date;

public class MensagemDAO implements IMensagemDAO {
  private Integer id;
  private String mensagem;
  private Date data;
  private String tipo;
  private String salaTitulo;
  private String usuarioLogin;
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) throws DAOException {
    this.id = id;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public Date getDataEnvio() {
    return data;
  }

  public void setDataEnvio(Date data) {
    this.data = data;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public ISalaDAO getSala() {
    return MemoryDAOFactory.getInstance().findSala(salaTitulo);
  }

  public void setSala(ISalaDAO sala) {
    this.salaTitulo = sala.getTitulo();
  }

  public IUsuarioDAO getUsuario() {
    return MemoryDAOFactory.getInstance().findUsuario(usuarioLogin);
  }

  public void setUsuario(IUsuarioDAO usuario) {
    this.usuarioLogin = usuario.getLogin();
  }

  public String toString() {
    return "[" + id + " / " + data + "] " + usuarioLogin + ": " + mensagem;
  }
}
