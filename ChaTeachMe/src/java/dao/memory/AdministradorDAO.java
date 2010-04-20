package dao.memory;

import dao.IAdministradorDAO;

public class AdministradorDAO extends ProfessorDAO implements IAdministradorDAO {
  public boolean isProfessor() {
    return false;
  }

  public boolean isAdministrador() {
    return true;
  }
}
