package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.Client;



public interface ClientService {
	
    public Client saveClient(Client client);
	
	public List<Client> getAllClient();
	
	public Client getClientbyId(Long id);
	
	public String updateClient(Client client,long id);
	
	public void deleteClientById(Long id);

}
