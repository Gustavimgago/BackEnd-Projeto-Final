package org.example.services;


import org.example.entities.Categoria;
import org.example.entities.Cliente;
import org.example.repositories.CategoriaRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> getAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    public boolean update(Long id, Categoria categoria) {
        Optional<Categoria> optionalCategoria = repository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoria1 = optionalCategoria.get();
            categoria1.setCateNome(categoria.getCateNome());
            categoria1.setCateDescricao(categoria.getCateDescricao());
            repository.save(categoria1);
            return true;
        }
        return false;
    }

    public void delete(Long id) { repository.deleteById(id); }


}
