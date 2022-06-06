package manageClient2.service;

import java.util.List;

import manageClient2.dto.ClientDto;
import manageClient2.entities.Client;

public interface IClientService {
	List<ClientDto> getAllClients();
	List<ClientDto> getClientByFirstname(String firstname);
	List<ClientDto> getClientByLastname(String lastname);
	ClientDto save(ClientDto client);
	String update(ClientDto clientDto);
    ClientDto getById(Long idclient);
	void delete(Long idClient);

}
