package projeto_web.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("usuario")
public class Usuario implements Serializable {
	@Id
	private String login;

	private String email;

	private String nome;

	private String senha;
	
	@OneToMany
	@JoinColumn(name = "usuario_login")
	private Collection<Mensagem> mensagens;
	
	@OneToMany
	@JoinColumn(name = "usuario_login")
	private Collection<SituacaoUsuarioSala> situacoes;

    public Usuario() {
    }

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setMensagens(Collection<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Collection<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setSituacoes(Collection<SituacaoUsuarioSala> situacoes) {
		this.situacoes = situacoes;
	}

	public Collection<SituacaoUsuarioSala> getSituacoes() {
		return situacoes;
	}

	private static final long serialVersionUID = 1L;
}
