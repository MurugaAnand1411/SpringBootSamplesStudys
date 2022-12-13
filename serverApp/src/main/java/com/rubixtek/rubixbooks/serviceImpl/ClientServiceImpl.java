package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Client;
import com.rubixtek.rubixbooks.repository.ClientRepository;
import com.rubixtek.rubixbooks.service.ClientService;



@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientbyId(Long id) {
		return clientRepository.findById(id).get();
	}
	
	@Override
	public String updateClient(Client client,long id) {
		client.setId(id);
		clientRepository.save(client);
		return "Successfully updated";
	}

	@Override
	public void deleteClientById(Long id) {
		 clientRepository.deleteById(id);
		
	}

}
