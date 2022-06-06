package manageClient2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manageClient2.dto.ClientDto;
import manageClient2.entities.Client;
import manageClient2.mapper.ClientMapper;
import manageClient2.repository.ClientRepo;
import manageClient2.service.IClientService;
@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepo repo;
	@Autowired
	private ClientMapper mapper;
	@Override
	public List<ClientDto> getAllClients() {
		List<Client> list = repo.findAll();
		return mapper.listClienstToDto(list);
	}

	@Override
	public List<ClientDto> getClientByFirstname(String firstname) {
		List<Client> list = repo.findByFirstnameLike("%"+firstname+"%");
		return mapper.listClienstToDto(list);
	}

	@Override
	public List<ClientDto> getClientByLastname(String lastname) {
		List<Client> list = repo.findByLastname(lastname);
		return mapper.listClienstToDto(list);
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		if(clientDto == null)
			return null;
		Client client = mapper.dtoToEntity(clientDto);
		return mapper.entityToDto(repo.save(client));
	}

	@Override
	public String update(ClientDto clientDto) {
		if(clientDto == null && clientDto.getId() <= 0)
			return null;
		Client client = repo.findOne(clientDto.getId());
		if(client == null)
			return null;
		client = mapper.dtoToEntity(clientDto);
		 mapper.entityToDto(repo.save(client));
		 
		 return "listclients.xhmtl";
	}
	@Override
	public ClientDto getById(Long idClient) {
		Client client = repo.findOne(idClient);
		return mapper.entityToDto(client);
		
	}

	@Override
	public void delete(Long idClient) {
	   Client client = repo.findOne(idClient);
	   if(client != null)
		   repo.delete(idClient);
	}

}
