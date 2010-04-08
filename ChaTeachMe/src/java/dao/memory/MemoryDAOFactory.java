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
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteUsuario(IUsuarioDAO usuario) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public IUsuarioDAO findUsuario(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllUsuarios() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertProfessor(IProfessorDAO professor) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteProfessor(IProfessorDAO professor) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public IProfessorDAO findProfessor(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllProfessores() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertAdministrador(IAdministradorDAO administrador) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteAdministrador(IAdministradorDAO administrador) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public IAdministradorDAO findAdministrador(String login) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllAdministradores() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertSala(ISalaDAO sala) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteSala(ISalaDAO sala) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public ISalaDAO findSala(String titulo) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllSalas() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertMensagem(IMensagemDAO mensagem) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteMensagem(IMensagemDAO mensagem) {
    throw new UnsupportedOperationException("Not supported yet.");
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
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findSituacoesUsuario(IUsuarioDAO usuario) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findSituacoesSala(ISalaDAO sala) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllSituacoesUsuarioSala() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
