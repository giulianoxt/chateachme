package business;

import dao.*;
import java.util.Collection;
import java.util.Date;

public class Facade {
  public static IUsuarioDAO login(String login, String senha) throws BusinessException {
    return Autenticacao.login(login, senha);
  }

  public static void cadastrarUsuario(
          String nome, String email, String login, String senha) throws BusinessException {
    Autenticacao.cadastrarUsuario(nome, email, login, senha);
  }

  public static void cadastrarProfessor(
          String nome, String email, String login, String senha) throws BusinessException {
    Autenticacao.cadastrarProfessor(nome, email, login, senha);
  }

  public static void cadastrarAdministrador(
          String nome, String email, String login, String senha) throws BusinessException {
    Autenticacao.cadastrarAdministrador(nome, email, login, senha);
  }

  public static void cadastrarSala(ISalaDAO sala) throws BusinessException {
    Administracao.cadastrarSala(sala);
  }

  public static void abrirSala(ISalaDAO sala) {
    Administracao.abrirSala(sala);
  }

  public static void fecharSala(ISalaDAO sala) {
    Administracao.fecharSala(sala);
  }

  public static void excluirSala(ISalaDAO sala) {
    Administracao.excluirSala(sala);
  }

  public static void entrarEmSala(IUsuarioDAO usuario, ISalaDAO sala)
          throws BusinessException {
    Chat.entrarEmSala(usuario, sala);
  }

  public static void enviarMensagem(IUsuarioDAO usuario, IMensagemDAO mensagem)
          throws BusinessException {
    Chat.enviarMensagem(usuario, mensagem);
  }

  public static Collection getMensagensNaoLidas(
          IUsuarioDAO usuario, ISalaDAO sala, Date lastUpdate) {
    return Chat.getMensagensNaoLidas(usuario, sala, lastUpdate);
  }
}
