package br.com.ada.programacaowebIsblocatecar.repository;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}
