package business;

import dao.DAOException;
import dao.DAOFactory;
import dao.IMensagemDAO;
import dao.ISalaDAO;
import dao.ISituacaoUsuarioSalaDAO;
import dao.IUsuarioDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

class Chat {
  private static DAOFactory daoFactory = DAOFactory.getDAOFactory();

  public static void entrarEmSala(IUsuarioDAO usuario, ISalaDAO sala)
          throws BusinessException {
    try {
      ISituacaoUsuarioSalaDAO situacao = daoFactory.newSituacaoUsuarioSala();
      situacao.setSala(sala);
      situacao.setUsuario(usuario);
      situacao.setTempoEmSala(Long.valueOf(System.currentTimeMillis()));
      situacao.setSituacao("Online");
      daoFactory.insertSituacaoUsuarioSala(situacao);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static void enviarMensagem(IUsuarioDAO usuario, IMensagemDAO mensagem)
          throws BusinessException {
    try {
      mensagem.setDataEnvio(new Date(System.currentTimeMillis()));
      daoFactory.insertMensagem(mensagem);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static Collection getMensagensNaoLidas(IUsuarioDAO usuario, ISalaDAO sala, Date lastUpdate) {
    Collection mensagens = daoFactory.findMensagensSala(sala);
    Collection naoLidas = new ArrayList();

    for (Iterator it = mensagens.iterator(); it.hasNext(); ) {
      IMensagemDAO msg = (IMensagemDAO)it.next();
      if (msg.getDataEnvio().after(lastUpdate)) {
        naoLidas.add(msg);
      }
    }

    return naoLidas;
  }
}
