package projeto_web.model;

import javax.persistence.*;
import java.io.Serializable;

import projeto_web.model.Sala;
import projeto_web.model.Usuario;

/**
 * Entity implementation class for Entity: SituacaoUsuarioSala
 *
 */
@Entity
@Table(name="situacao_usuario_sala")
public class SituacaoUsuarioSala implements Serializable {
	@Id
	private Integer id;
	
	private String situacao;
	
	private Long tempoEmSala;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Usuario usuario;

	public SituacaoUsuarioSala() {
		super();
	}   
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
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
	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}   
	public Long getTempoEmSala() {
		return this.tempoEmSala;
	}

	public void setTempoEmSala(Long tempoEmSala) {
		this.tempoEmSala = tempoEmSala;
	}
   
	private static final long serialVersionUID = 1L;
}
