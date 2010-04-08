package dao.memory;

import dao.*;
import java.util.ArrayList;
import java.util.Collection;

public class MemoryDAOFactory extends DAOFactory {
  public Collection usuarios = new ArrayList();
  public Collection professores = new ArrayList();
  public Collection administradores = new ArrayList();
  public Collection salas = new ArrayList();
  public Collection mensagens = new ArrayList();
  public Collection situacoes = new ArrayList();

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

  public Collection findAllMensagens() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void insertSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao) throws DAOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public ISituacaoAlunoSalaDAO findSituacaoAlunoSala(ISalaDAO sala, IUsuarioDAO usuario) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public Collection findAllSituacoesAlunoSala() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
