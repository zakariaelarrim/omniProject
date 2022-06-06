package manageClient2.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import manageClient2.dto.ClientDto;
import manageClient2.entities.Client;
import manageClient2.mapper.ClientMapper;
import manageClient2.service.IClientService;
@Controller
@ManagedBean
@RequestScope
public class ClientBean implements Serializable {
	@Autowired
	private IClientService service;
	@Autowired
	private ClientMapper mapper;
	private String filter;
	private static Long clientid = 0L;
	private ClientDto client;
	private List<ClientDto> clientsList;
	public ClientDto getClient() {
		return client;
	}
	
	public static Long getClientid() {
		return clientid;
	}

	public static void setClientid(Long clientid) {
		ClientBean.clientid = clientid;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public ClientBean() {
		super();
	}
	public static String getFacesParamValue() {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("clientid");
    }
	@PostConstruct
	public void init() {
		client = new ClientDto();
		String id = getFacesParamValue();
		if(id != null) {
			clientid = Long.parseLong(id);
	      if(clientid > 0)
	    	client = service.getById(clientid);
		}
	    
	}
	public String filterClients(){
		clientsList = new ArrayList();
		clientsList = service.getClientByFirstname(filter);
		return "listclients";
	}
	public List<ClientDto> clientsList(){
		if(filter == null) {
		   clientsList = new ArrayList();
		   clientsList = service.getAllClients();
		}
		
		return clientsList;
	}
	public String addClient() {
		ClientDto savedC = service.save(client);
		if(savedC != null)
			return "listclients.xhtml";
		return "createclient.xhtml";
	}
	public String save() {
		if( null != clientid) { 
			client.setId(clientid);
			return updateClient(client);
		}
		return addClient();
		
	}
	public String updateClient(ClientDto client) {
//		ClientDto savedC = service.save(client);
		if(service.update(client) != null)
			return "listclients.xhtml";
		return null;
	}
	public String removeClient(Long id) {
		service.delete(id);
		return "listclients.xhtml";
	}

}
