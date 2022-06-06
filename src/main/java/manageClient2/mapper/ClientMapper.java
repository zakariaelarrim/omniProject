package manageClient2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import manageClient2.dto.ClientDto;
import manageClient2.entities.Client;
@Component
public class ClientMapper {
   public ClientDto entityToDto(Client client) {
	   if(client == null)
		   return null;
	   ClientDto dto = new ClientDto();
	   dto.setFirstname(client.getFirstname());
	   dto.setLastname(client.getLastname());
	   dto.setEmail(client.getEmail());
	   dto.setTelephone(client.getTelephone());
	   dto.setId(client.getId());
	   
	   return dto;
   }
   
   public Client dtoToEntity(ClientDto client2) {
	   if(client2 == null)
		   return null;
	   Client client  = new Client();
	   client.setFirstname(client2.getFirstname());
	   client.setLastname(client2.getLastname());
	   client.setEmail(client2.getEmail());
	   client.setTelephone(client2.getTelephone());
	   client.setId(client2.getId());
	   return  client;
   }
   
   public List<ClientDto> listClienstToDto(List<Client> listClient){
	   if(listClient == null)
		   return null;
	   List<ClientDto> listDto = new ArrayList<ClientDto>();
	   listClient.forEach(item -> listDto.add(entityToDto(item)));
	   return listDto;
   }
   public List<Client> listDtoToClients(List<ClientDto> listClientsDto){
	   if(listClientsDto == null)
		   return null;
	   List<Client> listClients = new ArrayList<Client>();
	   listClientsDto.forEach(item -> listClients.add(dtoToEntity(item)));
	   return listClients;
   }
}
