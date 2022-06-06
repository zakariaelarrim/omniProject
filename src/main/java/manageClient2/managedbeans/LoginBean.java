package manageClient2.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import manageClient2.dto.ClientDto;
import manageClient2.entities.Client;
import manageClient2.mapper.ClientMapper;
import manageClient2.service.IClientService;
import manageClient2.service.impl.ClientServiceImpl;

@Controller
@ManagedBean
@RequestScope
public class LoginBean implements Serializable {
	private String username;
	private String password;
	@Autowired
	private IClientService service;
	@Autowired
	private ClientMapper mapper ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginBean() {
		
	}
	
	public String checkuser() {		
		Client client = new Client();
		client.setEmail("zakaria elarrim");
		client.setFirstname(username);
		client.setLastname(password);
		client.setId(0L);
		client.setTelephone("06xxxxxx");
		ClientDto savedClient = service.save(mapper.entityToDto(client));
		if(savedClient != null)
			return "success.xhtml";
		return "index.xhtml";
		
		
	}
	public String test() {
		return "create-client";
	}
	

}
