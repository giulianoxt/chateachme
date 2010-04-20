package business;

import dao.DAOException;
import dao.DAOFactory;
import dao.ISalaDAO;
import dao.ISituacaoUsuarioSalaDAO;
import java.util.Collection;
import java.util.Iterator;

public class Administracao {
  private static DAOFactory daoFactory = DAOFactory.getDAOFactory();

  public static void cadastrarSala(ISalaDAO sala) throws BusinessException {
    try {
      sala.setSalaAberta(Boolean.FALSE);
      daoFactory.insertSala(sala);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static void abrirSala(ISalaDAO sala) {
    sala.setSalaAberta(Boolean.TRUE);
  }

  public static void fecharSala(ISalaDAO sala) {
    clearSituacoes(sala);
    sala.setSalaAberta(Boolean.FALSE);
  }

  public static void excluirSala(ISalaDAO sala) {
    clearSituacoes(sala);
    daoFactory.deleteSala(sala);
  }

  private static void clearSituacoes(ISalaDAO sala) {
    Collection situacoes = sala.getSituacoesUsuarioSala();
    Iterator it = situacoes.iterator();

    while (it.hasNext()) {
      ISituacaoUsuarioSalaDAO situacao = (ISituacaoUsuarioSalaDAO)it.next();
      daoFactory.deleteSituacaoUsuarioSala(situacao);
    }
  }
}
