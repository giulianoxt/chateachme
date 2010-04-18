package dao.memory;

import dao.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.hsqldb.lib.Iterator;

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

            dao.memory.UsuarioDAO u1 = new dao.memory.UsuarioDAO();
            u1.setEmail("m.r650200@gmail.com");
            u1.setLogin("m.r650200");
            u1.setSenha("1234");

            dao.memory.UsuarioDAO u2 = new dao.memory.UsuarioDAO();
            u2.setEmail("ex1@ex.com.br");
            u2.setLogin("ex1");
            u2.setSenha("1234");

            dao.memory.UsuarioDAO u3 = new dao.memory.UsuarioDAO();
            u3.setEmail("ex2");
            u3.setLogin("ex3");
            u3.setSenha("1234");

            dao.memory.UsuarioDAO u4 = new dao.memory.UsuarioDAO();
            u4.setEmail("m.r650200@gmail.com");
            u4.setLogin("m.r650200");
            u4.setSenha("1234");

            usuarios.add(u1);
            usuarios.add(u2);
            usuarios.add(u3);
            usuarios.add(u4);

        } catch (DAOException ex) {
            ex.printStackTrace();
        }
  }
  
  private void addProfessor() {
        try {
            ProfessorDAO p1;
            ProfessorDAO p2;
            
            p1 = new ProfessorDAO();
            p1.setEmail("prof1@ex.com");
            p1.setNome("Prof Um");
            p1.setLogin("prof1");
            p1.setSenha("1234");

            p2 = new ProfessorDAO();
            p2.setEmail("prof2@ex.com");
            p2.setNome("Prof Dois");
            p2.setLogin("prof2");
            p2.setSenha("1234");

            professores.add(p1);
            professores.add(p2);
        } catch (DAOException ex) {
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
                m1.setId(Integer.valueOf(++id));
                m1.setMensagem("Hello World " + id);
                m1.setSala(s);

                m2 = new MensagemDAO();
                m2.setDataEnvio(new Date());
                m2.setId(Integer.valueOf(++id));
                m2.setMensagem("Hello World " + id);
                m2.setSala(s);

                mensagens.add(m1);
                mensagens.add(m2);
                
            } catch (DAOException ex) {
                ex.printStackTrace();
            }
     }
  }

  private void addAdministrador() {
        try {
            AdministradorDAO a1;
            AdministradorDAO a2;

            a1 = new AdministradorDAO();
            a1.setEmail("admin@ex.com");
            a1.setLogin("admin1");
            a1.setSenha("1234");
            a1.setNome("Admin Um");
            
            a2 = new AdministradorDAO();
            a2.setEmail("admin@ex.com");
            a2.setLogin("admin2");
            a2.setSenha("1234");
            a2.setNome("Admin Dois");

            administradores.add(a1);
            administradores.add(a2);
        } catch (DAOException ex) {
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
