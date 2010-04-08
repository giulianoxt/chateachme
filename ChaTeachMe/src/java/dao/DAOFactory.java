package dao;

import java.util.Collection;
import dao.memory.MemoryDAOFactory;

public abstract class DAOFactory {
  public static DAOFactory getDAOFactory() {
    return new MemoryDAOFactory();
  }

  public abstract void insertUsuario(IUsuarioDAO usuario) throws DAOException;
  public abstract void deleteUsuario(IUsuarioDAO usuario);
  public abstract IUsuarioDAO findUsuario(String login);
  public abstract Collection findAllUsuarios();

  public abstract void insertProfessor(IProfessorDAO professor) throws DAOException;
  public abstract void deleteProfessor(IProfessorDAO professor);
  public abstract IProfessorDAO findProfessor(String login);
  public abstract Collection findAllProfessores();

  public abstract void insertAdministrador(IAdministradorDAO administrador) throws DAOException;
  public abstract void deleteAdministrador(IAdministradorDAO administrador);
  public abstract IAdministradorDAO findAdministrador(String login);
  public abstract Collection findAllAdministradores();

  public abstract void insertSala(ISalaDAO sala) throws DAOException;
  public abstract void deleteSala(ISalaDAO sala);
  public abstract ISalaDAO findSala(String titulo);
  public abstract Collection findAllSalas();

  public abstract void insertMensagem(IMensagemDAO mensagem) throws DAOException;
  public abstract void deleteMensagem(IMensagemDAO mensagem);
  public abstract IMensagemDAO findMensagem(Integer id);
  public abstract Collection findAllMensagens();

  public abstract void insertSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao) throws DAOException;
  public abstract void deleteSituacaoAlunoSala(ISituacaoAlunoSalaDAO situacao);
  public abstract ISituacaoAlunoSalaDAO findSituacaoAlunoSala(
          ISalaDAO sala, IUsuarioDAO usuario);
  public abstract Collection findAllSituacoesAlunoSala();
}
