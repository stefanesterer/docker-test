package hello;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GreetingId implements Serializable {

	private static final long serialVersionUID = 2536058720748131631L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer count;

	public GreetingId() {

	}

	public static GreetingId CREATE_FIRST_GREETING_ID() {
		GreetingId result = new GreetingId();
		result.count = 0;
		return result;
	}

	public Integer incrementAndCount() {
		count++;
		return count;
	}

}
