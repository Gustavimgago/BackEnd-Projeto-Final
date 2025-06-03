package org.example.services;

import org.example.entities.Funcionario;
import org.example.entities.Pedido;
import org.example.repositories.PedidoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> getAll() { return repository.findAll(); }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pedido insert(Pedido pedido){ return repository.save(pedido); }

    public boolean update(Long id, Pedido pedido){
        Optional<Pedido> optionalPedido = repository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido pedido1 = optionalPedido.get();
            pedido1.setPddDataPedido(pedido.getPddDataPedido());
            pedido1.setPddStatusPedido(pedido.getPddStatusPedido());
            pedido1.setPddTotalPedido(pedido.getPddTotalPedido());
            repository.save(pedido1);
            return true;
        }
        return false;
    }
    public void delete(Long id) { repository.deleteById(id); }

}
