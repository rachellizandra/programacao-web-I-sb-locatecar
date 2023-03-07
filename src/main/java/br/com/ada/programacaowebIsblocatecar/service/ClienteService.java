package br.com.ada.programacaowebIsblocatecar.service;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import br.com.ada.programacaowebIsblocatecar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> listarClienteId(Long id) {
        return this.clienteRepository.findById(id);
    }
}
