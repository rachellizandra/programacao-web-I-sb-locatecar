package br.com.ada.programacaowebIsblocatecar.service;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import br.com.ada.programacaowebIsblocatecar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public void cadastrarCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public Page<Cliente> listarPaginado(Integer numeroPagina, Integer tamanhoPagina) {
        return this.clienteRepository
                .findAll(PageRequest.of(numeroPagina, tamanhoPagina, Sort.by(Sort.Order.asc("id"))));
    }

    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> listarClienteId(Long id) {
        return this.clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarNumeroDocumento(String numeroDocumento){
        return this.clienteRepository.findByNumeroDocumento(numeroDocumento);
    }

    public void removerClienteId(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
