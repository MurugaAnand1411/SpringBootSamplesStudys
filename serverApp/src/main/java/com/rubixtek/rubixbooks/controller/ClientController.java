package com.rubixtek.rubixbooks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.Client;
import com.rubixtek.rubixbooks.entities.Customer;
import com.rubixtek.rubixbooks.service.ClientService;





@RestController
@RequestMapping("Client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping("/CreateClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
		clientService.saveClient(client);
        URI uri = URI.create("/" + client.getId());
        return ResponseEntity.created(uri).body(client);
    }


	@GetMapping("/GetAllClient")
    public ResponseEntity<List<Client>> getAllPayment() {
        List<Client> c = clientService.getAllClient();
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }

	@GetMapping("/GetClient/{id}")
    public ResponseEntity<Client> getPaymentById(@PathVariable long id) {
		Client c = clientService.getClientbyId(id);
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }
	
	@PutMapping("UpdateClient/{id}")
    public ResponseEntity<Client> updatePayment(@RequestBody Client client, @PathVariable long id) {
		Client updClient = clientService.getClientbyId(id);
		updClient.setId(id);
		updClient.setAddress1(client.getAddress1());
		updClient.setAddress2(client.getAddress2());
		updClient.setCity(client.getCity());
		updClient.setCountry(client.getCountry());
		updClient.setName(client.getName());
		updClient.setState(client.getState());
		updClient.setTaxIdentifier(client.getTaxIdentifier());
		updClient.setActive(client.isActive());
		clientService.updateClient(updClient, id);
        URI uri = URI.create("/" + client.getId());
        return ResponseEntity.created(uri).body(updClient);
    }
	
	 @DeleteMapping("DeleteClient/{id}")
	    public String deleteClient(@PathVariable long id) {
		 clientService.deleteClientById(id);
	        return "Deleted successfully : " + id;
	    }
}
