package manageClient2.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class ClientDto {
	private Long id;
	@NotNull(message = "Firstname can't be empty")  
	@Min(value = 3,  message = "Firstname must have 3 characters at least")  
	private String fristname;
	@NotNull(message = "Lastname can't be empty")  
	private String lastname;
	@NotNull(message = "Email can't be empty")  
	private String email;
	@NotNull(message = "Telephone can't be empty")
	@Size(min = 10, max = 10, message = "Telephone must have 10 digits")  
	private String telephone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return fristname;
	}
	public void setFirstname(String pristname) {
		this.fristname = pristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public ClientDto(Long id, String pristname, String lastname, String email, String telephone) {
		super();
		this.id = id;
		this.fristname = pristname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
	}
	public ClientDto() {}
	
}
