package br.com.ada.programacaowebIsblocatecar.controller;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import br.com.ada.programacaowebIsblocatecar.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteControllerMVC {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String listarTodos(Model model) {
        List<Cliente> clientes = this.clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/cliente/add")
    public String buscarCliente(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("cliente", new Cliente());
        return "cliente-add";
    }
    @PostMapping("/cliente/add")
    public String cadastrarCliente(@Valid @ModelAttribute("cliente") Cliente cliente) {
        if(cliente.getTipoDocumento().equals("cpf") && cliente.getNumeroDocumento().length() != 11) {
            //throw new MethodArgumentNotValidException("Número de caracteres inválidos");
        }
        this.clienteService.cadastrarCliente(cliente);
        return "redirect:/clientes";
    }
}
