package projeto_web.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity(name="Professor")
@DiscriminatorValue("professor")
 
public class Professor extends Usuario {
	
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}
   
}
