package org.example.services;

import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.repositories.ContatoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> getAll() { return  repository.findAll(); }

    public Contato findById(Long id) {
        Optional<Contato> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Contato insert(Contato contato) { return repository.save(contato);}

    public boolean update(Long id, Contato contato) {
        Optional<Contato> optionalContato = repository.findById(id);
        if (optionalContato.isPresent()) {
            Contato contato1 = optionalContato.get();
            contato1.setConCelular(contato.getConCelular());
            contato1.setConTelefoneComercial(contato.getConTelefoneComercial());
            contato1.setConEmail(contato.getConEmail());
            repository.save(contato1);
        }
    return false;
    }

    public void delete(Long id) { repository.deleteById(id); }
}
