package dao.memory;

import dao.IProfessorDAO;

public class ProfessorDAO extends UsuarioDAO implements IProfessorDAO {
  public boolean isProfessor() {
    return true;
  }
}
