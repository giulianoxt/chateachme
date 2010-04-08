package dao;

import java.util.Collection;

public interface IAdministradorDAO extends IProfessorDAO {
  public void insertAdministrador(IAdministradorDAO administrador);
  public void deleteAdministrador(IAdministradorDAO administrador);

  public IAdministradorDAO findAdministrador(String login);
  public Collection findAll();
}
