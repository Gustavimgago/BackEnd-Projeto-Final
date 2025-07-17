package org.example.services;

//@Service
public class VendasService {/*

    @Autowired
    private VendasRepository vendaRepository;


    @Autowired
    private ClienteService clienteService; // Para validar o cliente

    public List<Vendas> findAll() {
        return vendaRepository.findAll();
    }

    public Vendas findById(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Vendas insert(VendasDTO vendaDTO) {
        // Validação do cliente
        Cliente cliente = clienteService.findById(vendaDTO.getClienteId());

        // Criação da nova venda
        Vendas novaVenda = new Vendas();
        novaVenda.setCliente(cliente);
        novaVenda.setTotal(vendaDTO.getTotal());
        novaVenda.setMetodoPagamento(vendaDTO.getMetodoPagamento());
        novaVenda.setData(vendaDTO.getData());

        // Aqui você pode adicionar a lógica para associar os produtos da venda
        // Exemplo: novaVenda.setProdutosVenda(...);

        return vendaRepository.save(novaVenda);
    }

    public Vendas update(Long id, VendasDTO vendaDTO) {
        // Verifica se a venda existe
        Vendas existingVenda = findById(id);

        // Atualiza os campos da venda existente
        existingVenda.setMetodoPagamento(vendaDTO.getMetodoPagamento());
        existingVenda.setTotal(vendaDTO.getTotal());
        existingVenda.setData(vendaDTO.getData());

        // Se necessário, você pode validar o cliente novamente
        if (vendaDTO.getClienteId() != null) {
            Cliente cliente = clienteService.findById(vendaDTO.getClienteId());
            existingVenda.setCliente(cliente); // Atualiza o cliente associado
        }


        return vendaRepository.save(existingVenda);
    }

    public void delete(Long id) {
        vendaRepository.deleteById(id);
    }

    public List<ProdutoVenda> getProdutosDaVenda(Long vendaId) {
        Vendas vendas = findById(vendaId);
        return vendas.getProdutosVenda(); // Retorna a lista de produtos da venda
    }*/
}

