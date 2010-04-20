package business;

import dao.DAOException;
import dao.DAOFactory;
import dao.IAdministradorDAO;
import dao.IProfessorDAO;
import dao.IUsuarioDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Autenticacao {
  private static DAOFactory daoFactory = DAOFactory.getDAOFactory();

  public static IUsuarioDAO login(String login, String senha) throws BusinessException {
    byte[] hash = hashSenha(senha);
    IUsuarioDAO usuario = daoFactory.findUsuario(login);

    if (usuario != null && java.util.Arrays.equals(hash, usuario.getSenha())) {
      return usuario;
    } else {
      throw new BusinessException("Autenticacao Falhou: " + login);
    }
  }

  public static void cadastrarUsuario(
          String nome, String email, String login, String senha) throws BusinessException {
    try {
      IUsuarioDAO usuario = daoFactory.newUsuario();
      usuario.setNome(nome);
      usuario.setEmail(email);
      usuario.setLogin(login);
      usuario.setSenha(hashSenha(senha));
      daoFactory.insertUsuario(usuario);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static void cadastrarProfessor(
          String nome, String email, String login, String senha) throws BusinessException {
    try {
      IProfessorDAO professor = daoFactory.newProfessor();
      professor.setNome(nome);
      professor.setEmail(email);
      professor.setLogin(login);
      professor.setSenha(hashSenha(senha));
      daoFactory.insertProfessor(professor);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static void cadastrarAdministrador(
          String nome, String email, String login, String senha) throws BusinessException {
    try {
      IAdministradorDAO administrador = daoFactory.newAdministrador();
      administrador.setNome(nome);
      administrador.setEmail(email);
      administrador.setLogin(login);
      administrador.setSenha(hashSenha(senha));
      daoFactory.insertAdministrador(administrador);
    } catch (DAOException e) {
      throw new BusinessException(e.getMessage());
    }
  }

  public static byte[] hashSenha(String senha) {
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      return digest.digest(senha.getBytes());
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }
}
