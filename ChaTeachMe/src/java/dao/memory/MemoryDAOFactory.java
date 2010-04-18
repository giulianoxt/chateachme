package dao.memory;

import dao.*;
import java.util.ArrayList;
import java.util.Collection;

public class MemoryDAOFactory extends DAOFactory {
  private Collection usuarios = new ArrayList();
  private Collection professores = new ArrayList();
  private Collection administradores = new ArrayList();
  private Collection salas = new ArrayList();
  private Collection mensagens = new ArrayList();
  private Collection situacoes = new ArrayList();

  private static MemoryDAOFactory instance = new MemoryDAOFactory();

  private MemoryDAOFactory() { }

  public static MemoryDAOFactory getInstance() {
    return instance;
  }

  public void insertUsuario(IUsuarioDAO usuario) throws DAOException {
    usuarios.add(usuario);
  }

  public void deleteUsuario(IUsuarioDAO usuario) {
    usuarios.remove(usuario);
  }

  public IUsuarioDAO findUsuario(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllUsuarios() {
    return usuarios;
  }

  public void insertProfessor(IProfessorDAO professor) throws DAOException {
    professores.add(professor);
  }

  public void deleteProfessor(IProfessorDAO professor) {
    professores.remove(professor);
  }

  public IProfessorDAO findProfessor(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllProfessores() {
    return professores;
  }

  public void insertAdministrador(IAdministradorDAO administrador) throws DAOException {
    administradores.add(administrador);
  }

  public void deleteAdministrador(IAdministradorDAO administrador) {
    administradores.remove(administrador);
  }

  public IAdministradorDAO findAdministrador(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllAdministradores() {
    return administradores;
  }

  public void insertSala(ISalaDAO sala) throws DAOException {
    salas.add(sala);
  }

  public void deleteSala(ISalaDAO sala) {
    salas.remove(sala);
  }

  public ISalaDAO findSala(String titulo) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllSalas() {
    return salas;
  }

  public void insertMensagem(IMensagemDAO mensagem) throws DAOException {
    mensagens.add(mensagem);
  }

  public void deleteMensagem(IMensagemDAO mensagem) {
    mensagens.remove(mensagem);
  }

  public IMensagemDAO findMensagem(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findMensagensUsuario(IUsuarioDAO usuario) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findMensagensSala(ISalaDAO sala) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllMensagens() {
    return mensagens;
  }

  public void insertSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao) throws DAOException {
    situacoes.add(situacao);
  }

  public void deleteSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao) {
    situacoes.remove(situacao);
  }

  public Collection findSituacoesUsuario(IUsuarioDAO usuario) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findSituacoesSala(ISalaDAO sala) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllSituacoesUsuarioSala() {
    return situacoes;
  }
}
