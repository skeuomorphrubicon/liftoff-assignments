import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Resident{

	@Id
	@GeneratedValue(strategy = GeneratedType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String passwordHash;
	private boolean enabled;
	private boolean tokenExpired;
	
	@ManyToMany
	@JoinTable(
		name = "user_roles",
		joinColumns = @JoinColumn(
			name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
}
	
	