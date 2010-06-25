package projeto_web.model;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity(name="Professor")
@DiscriminatorValue("professor") 
public class Professor extends Usuario {
	
	public Professor() {
		super();
	}
   
	private static final long serialVersionUID = 1L;
}
