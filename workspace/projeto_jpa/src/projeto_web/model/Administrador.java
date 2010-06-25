package projeto_web.model;

import java.io.Serializable;
import javax.persistence.*;

import projeto_web.model.Usuario;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario implements Serializable {
	public Administrador() {
		super();
	}
   
	private static final long serialVersionUID = 1L;
}
