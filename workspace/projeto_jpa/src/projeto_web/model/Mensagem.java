package projeto_web.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import projeto_web.model.Sala;
import projeto_web.model.Usuario;

/**
 * Entity implementation class for Entity: Mensagem
 *
 */
@Entity
@Table(name="mensagem")
public class Mensagem implements Serializable {
	@Id
	private Integer id;
	
	private String mensagem;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataEnvio;
	
	private String tipo;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Usuario usuario;

	public Mensagem() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}   
	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}   
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}   
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}   
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
   
	private static final long serialVersionUID = 1L;
}
