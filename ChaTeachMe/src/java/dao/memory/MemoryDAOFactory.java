package dao.memory;

import dao.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class MemoryDAOFactory extends DAOFactory {
  private Collection usuarios = new ArrayList();
  private Collection professores = new ArrayList();
  private Collection administradores = new ArrayList();
  private Collection salas = new ArrayList();
  private Collection mensagens = new ArrayList();
  private Collection situacoes = new ArrayList();

  private static MemoryDAOFactory instance = new MemoryDAOFactory();

  private void addUsers() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] senha1234 = md.digest("1234".getBytes());
          
            dao.memory.UsuarioDAO u1 = new dao.memory.UsuarioDAO();
            u1.setEmail("m.r650200@gmail.com");
            u1.setLogin("m.r650200");
            u1.setSenha(senha1234);

            dao.memory.UsuarioDAO u2 = new dao.memory.UsuarioDAO();
            u2.setEmail("ex1@ex.com.br");
            u2.setLogin("ex1");
            u2.setSenha(senha1234);

            dao.memory.UsuarioDAO u3 = new dao.memory.UsuarioDAO();
            u3.setEmail("ex2");
            u3.setLogin("ex3");
            u3.setSenha(senha1234);

            dao.memory.UsuarioDAO u4 = new dao.memory.UsuarioDAO();
            u4.setEmail("m.r650200@gmail.com");
            u4.setLogin("m.r650200");
            u4.setSenha(senha1234);

            usuarios.add(u1);
            usuarios.add(u2);
            usuarios.add(u3);
            usuarios.add(u4);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
  }
  
  private void addProfessor() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] senha1234 = md.digest("1234".getBytes());
            ProfessorDAO p1;
            ProfessorDAO p2;
            
            p1 = new ProfessorDAO();
            p1.setEmail("prof1@ex.com");
            p1.setNome("Prof Um");
            p1.setLogin("prof1");
            p1.setSenha(senha1234);

            p2 = new ProfessorDAO();
            p2.setEmail("prof2@ex.com");
            p2.setNome("Prof Dois");
            p2.setLogin("prof2");
            p2.setSenha(senha1234);

            professores.add(p1);
            professores.add(p2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

  }

  private void addSalas() {
        try {
            SalaDAO s1;
            SalaDAO s2;

            int local = (127 << 24) + (0 << 16) + (0 << 8) + 1;

            s1 = new SalaDAO();
            s1.setDataCriacao(new Date());
            s1.setDescricao("Exemplo de descrição de sala");
            s1.setIpCamera(Integer.valueOf(local));
            s1.setTitulo("Exemplo 1 de sala");
            
            s2 = new SalaDAO();
            s2.setDataCriacao(new Date());
            s2.setDescricao("Exemplo de descrição de sala");
            s2.setIpCamera(Integer.valueOf(local));
            s2.setTitulo("Exemplo 2 de sala");

            salas.add(s1);
            salas.add(s2);
        } catch (DAOException ex) {
            ex.printStackTrace();
        }
  }

  private void addMensagens() {
     MensagemDAO m1, m2;
     java.util.Iterator it = salas.iterator();
     int id = 0;

     while (it.hasNext()) {
            try {
                SalaDAO s = (SalaDAO) it.next();

                m1 = new MensagemDAO();
                m1.setDataEnvio(new Date());
                m1.setUsuario((IUsuarioDAO) usuarios.toArray()[0]);
                m1.setId(Integer.valueOf(++id));
                m1.setMensagem("Hello World " + id);
                m1.setSala(s);
                m1.setTipo("texto");

                m2 = new MensagemDAO();
                m2.setDataEnvio(new Date());
                m2.setUsuario((IUsuarioDAO) usuarios.toArray()[0]);
                m2.setId(Integer.valueOf(++id));
                m2.setMensagem("1 + sin(x)");
                m2.setSala(s);
                m2.setTipo("latex");

                mensagens.add(m1);
                mensagens.add(m2);
                
            } catch (DAOException ex) {
                ex.printStackTrace();
            }
     }
  }

  private void addAdministrador() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] senha1234 = md.digest("1234".getBytes());

            AdministradorDAO a1;
            AdministradorDAO a2;

            a1 = new AdministradorDAO();
            a1.setEmail("admin@ex.com");
            a1.setLogin("admin1");
            a1.setSenha(senha1234);
            a1.setNome("Admin Um");
            
            a2 = new AdministradorDAO();
            a2.setEmail("admin@ex.com");
            a2.setLogin("admin2");
            a2.setSenha(senha1234);
            a2.setNome("Admin Dois");

            administradores.add(a1);
            administradores.add(a2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
  }

  private void addSituacoes() {
      java.util.Iterator it_s = salas.iterator();
      while (it_s.hasNext()) {
          java.util.Iterator it_u = usuarios.iterator();
          SalaDAO s = (SalaDAO) it_s.next();
          while (it_u.hasNext()) {
                try {
                    UsuarioDAO u = (UsuarioDAO) it_u.next();
                    SituacaoUsuarioSalaDAO sit = new SituacaoUsuarioSalaDAO();
                    sit.setSala(s);
                    sit.setSituacao("Online");
                    sit.setUsuario(u);
                    situacoes.add(sit);
                } catch (DAOException ex) {
                    ex.printStackTrace();
                }
          }
      }
  }

  private MemoryDAOFactory() {
    addUsers();
    addProfessor();
    addAdministrador();
    addSalas();
    addMensagens();
    addSituacoes();
  }

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
      java.util.Iterator it_u = usuarios.iterator();
      UsuarioDAO res = null;
      while (it_u.hasNext()) {
          UsuarioDAO u = (UsuarioDAO) it_u.next();
          if (u.getLogin().equals(login)) {
              res = u;
              break;
          }
      }
      return res;
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
      java.util.Iterator it_p = professores.iterator();
      ProfessorDAO res = null;
      while (it_p.hasNext()) {
          ProfessorDAO p = (ProfessorDAO) it_p.next();
          if (p.getLogin().equals(login)) {
              res = p;
              break;
          }
      }
      return res;
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
      java.util.Iterator it_a = administradores.iterator();
      AdministradorDAO res = null;
      while (it_a.hasNext()) {
          AdministradorDAO a = (AdministradorDAO) it_a.next();
          if (a.getLogin().equals(login)) {
              res = a;
              break;
          }
      }
      return res;
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
      java.util.Iterator it_s = salas.iterator();
      SalaDAO res = null;
      while (it_s.hasNext()) {
          SalaDAO s = (SalaDAO) it_s.next();
          if (s.getTitulo().equals(titulo)) {
              res = s;
              break;
          }
      }
      return res;
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
      java.util.Iterator it_m = mensagens.iterator();
      MensagemDAO res = null;
      while (it_m.hasNext()) {
          MensagemDAO m = (MensagemDAO) it_m.next();
          if (m.getId() == id) {
              res = m;
              break;
          }
      }
      return res;
  }
  
  public Collection findMensagensUsuario(IUsuarioDAO usuario) {
      Collection res = new ArrayList();
      java.util.Iterator it_m = mensagens.iterator();
      while (it_m.hasNext()) {
          MensagemDAO m = (MensagemDAO) it_m.next();
          if (m.getUsuario().getLogin().equals(usuario.getLogin())) {
              res.add(m);
          }
      }
      return res;
  }

  public Collection findMensagensSala(ISalaDAO sala) {
      Collection res = new ArrayList();
      java.util.Iterator it_m = mensagens.iterator();
      while (it_m.hasNext()) {
          MensagemDAO m = (MensagemDAO) it_m.next();
          if (m.getSala().getTitulo().equals(sala.getTitulo())) {
              res.add(m);
          }
      }
      return res;
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
      Collection res = new ArrayList();
      java.util.Iterator it_sit = situacoes.iterator();
      while (it_sit.hasNext()) {
          SituacaoUsuarioSalaDAO sit = (SituacaoUsuarioSalaDAO) it_sit.next();
          if (sit.getUsuario().getLogin().equals(usuario.getLogin())) {
              res.add(sit);
          }
      }
      return res;
  }

  public Collection findSituacoesSala(ISalaDAO sala) {
      Collection res = new ArrayList();
      java.util.Iterator it_sit = situacoes.iterator();
      while (it_sit.hasNext()) {
          SituacaoUsuarioSalaDAO sit = (SituacaoUsuarioSalaDAO) it_sit.next();
          if (sit.getSala().getTitulo().equals(sala.getTitulo())) {
              res.add(sit);
          }
      }
      return res;
  }

  public Collection findAllSituacoesUsuarioSala() {
    return situacoes;
  }

  public IUsuarioDAO newUsuario() {
    return new UsuarioDAO();
  }

  public IProfessorDAO newProfessor() {
    return new ProfessorDAO();
  }

  public IAdministradorDAO newAdministrador() {
    return new AdministradorDAO();
  }

  public ISalaDAO newSala() {
    return new SalaDAO();
  }

  public IMensagemDAO newMensagem() {
    return new MensagemDAO();
  }

  public ISituacaoUsuarioSalaDAO newSituacaoUsuarioSala() {
    return new SituacaoUsuarioSalaDAO();
  }
}
