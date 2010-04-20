package dao;

import java.util.Collection;
import dao.memory.MemoryDAOFactory;

public abstract class DAOFactory {
  public static DAOFactory getDAOFactory() {
    return MemoryDAOFactory.getInstance();
  }

  public abstract IUsuarioDAO newUsuario();
  public abstract void insertUsuario(IUsuarioDAO usuario) throws DAOException;
  public abstract void deleteUsuario(IUsuarioDAO usuario);
  public abstract IUsuarioDAO findUsuario(String login);
  public abstract Collection findAllUsuarios();

  public abstract IProfessorDAO newProfessor();
  public abstract void insertProfessor(IProfessorDAO professor) throws DAOException;
  public abstract void deleteProfessor(IProfessorDAO professor);
  public abstract IProfessorDAO findProfessor(String login);
  public abstract Collection findAllProfessores();

  public abstract IAdministradorDAO newAdministrador();
  public abstract void insertAdministrador(IAdministradorDAO administrador) throws DAOException;
  public abstract void deleteAdministrador(IAdministradorDAO administrador);
  public abstract IAdministradorDAO findAdministrador(String login);
  public abstract Collection findAllAdministradores();

  public abstract ISalaDAO newSala();
  public abstract void insertSala(ISalaDAO sala) throws DAOException;
  public abstract void deleteSala(ISalaDAO sala);
  public abstract ISalaDAO findSala(String titulo);
  public abstract Collection findAllSalas();

  public abstract IMensagemDAO newMensagem();
  public abstract void insertMensagem(IMensagemDAO mensagem) throws DAOException;
  public abstract void deleteMensagem(IMensagemDAO mensagem);
  public abstract IMensagemDAO findMensagem(Integer id);
  public abstract Collection findMensagensUsuario(IUsuarioDAO usuario);
  public abstract Collection findMensagensSala(ISalaDAO sala);
  public abstract Collection findAllMensagens();

  public abstract ISituacaoUsuarioSalaDAO newSituacaoUsuarioSala();
  public abstract void insertSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao) throws DAOException;
  public abstract void deleteSituacaoUsuarioSala(ISituacaoUsuarioSalaDAO situacao);
  public abstract Collection findSituacoesUsuario(IUsuarioDAO usuario);
  public abstract Collection findSituacoesSala(ISalaDAO sala);
  public abstract Collection findAllSituacoesUsuarioSala();
}
