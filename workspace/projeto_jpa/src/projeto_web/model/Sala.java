package projeto_web.model;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Sala
 *
 */
@Entity
@Table(name="sala")
public class Sala implements Serializable {
	@Id
	private String titulo;
	private Boolean salaAberta;
	private String descricao;
	private Date dataCriacao;
	private Integer ipCamera;

	public Sala() {
		super();
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public Boolean getSalaAberta() {
		return this.salaAberta;
	}

	public void setSalaAberta(Boolean salaAberta) {
		this.salaAberta = salaAberta;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}   
	public Integer getIpCamera() {
		return this.ipCamera;
	}

	public void setIpCamera(Integer ipCamera) {
		this.ipCamera = ipCamera;
    }
	
	private static final long serialVersionUID = 1L;
}
