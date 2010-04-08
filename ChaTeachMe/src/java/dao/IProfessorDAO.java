package dao;

import java.util.Collection;

public interface IProfessorDAO extends IUsuarioDAO {
  public void insertProfessor(IProfessorDAO professor);
  public void deleteProfessor(IProfessorDAO professor);

  public IProfessorDAO findProfessor(String login);
  public Collection findAll();
}
