package org.example.resources;

import org.example.DTO.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Vendas;
import org.example.services.ClienteService;
import org.example.services.VendasService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Autowired
 //   private VendasService vendaService; // Injetar o VendaService

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody ClienteDTO clienteDTO) {
        Cliente createdCliente = clienteService.insert(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDto) {
        try {
            Cliente updatedCliente = clienteService.update(id, clienteDto);
            return ResponseEntity.ok(updatedCliente);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* Método para adicionar uma nova venda ao cliente
    @PostMapping("/{clienteId}/vendas")
    public ResponseEntity<Cliente> addVenda(@PathVariable Long clienteId, @RequestBody Vendas vendas) {
        Cliente cliente = clienteService.addVenda(clienteId, vendas);
        return ResponseEntity.ok(cliente);
    } */

    /* Método para listar todas as vendas de um cliente
    @GetMapping("/{clienteId}/vendas")
    public ResponseEntity<List<Vendas>> findVendasByClienteId(@PathVariable Long clienteId) {
        List<Vendas> vendas = clienteService.findVendasByClienteId(clienteId);
        return ResponseEntity.ok(vendas);
    }*/
}


