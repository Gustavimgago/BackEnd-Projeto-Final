package org.example.resources;

import org.example.entities.Cliente;
import org.example.entities.Pedido;
import org.example.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        List<Pedido> pedidos = pedidoService.getAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido>findById(@PathVariable Long id) {
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pedido> insert(@RequestBody Pedido pedido) {
        Pedido createdPedido = pedidoService.insert(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pedido pedido){
        if(pedidoService.update(id, pedido)) {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
