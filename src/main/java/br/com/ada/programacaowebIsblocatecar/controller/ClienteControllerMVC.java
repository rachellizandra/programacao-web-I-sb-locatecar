package br.com.ada.programacaowebIsblocatecar.controller;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import br.com.ada.programacaowebIsblocatecar.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
public class ClienteControllerMVC {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView clientes(
            @RequestParam(defaultValue = "1", value = "page") Integer numeroPagina,
            @RequestParam(defaultValue = "3", value = "size") Integer tamanhoPagina) {
        //Model, ModelMap e ModelAndView
        ModelAndView modelAndView = new ModelAndView("clientes");
        Page<Cliente> clientePage = this.clienteService.listarPaginado(numeroPagina-1, tamanhoPagina);
        modelAndView.addObject("clientes", clientePage.getContent());
        modelAndView.addObject("totalPages", clientePage.getTotalPages());
        modelAndView.addObject("currentPage", numeroPagina);
        modelAndView.addObject("pageSize", clientePage.getSize());
        return modelAndView;
    }

    @GetMapping("/cliente/add")
    public String addCliente(Model model, Cliente cliente) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("cliente", Objects.nonNull(cliente) ? cliente : new Cliente());
        return "cliente-add";
    }

    @PostMapping("/cliente/add")
    public String criarCliente(@Valid @ModelAttribute("cliente") Cliente cliente,
                               BindingResult result,
                               Model model) {

        if(result.hasErrors()) {
            return addCliente(model, cliente);
        }

        this.clienteService.cadastrarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{clienteId}/delete")
    public String deletarCliente(@PathVariable("clienteId") Long clienteId) {
        this.clienteService.removerClienteId(clienteId);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/{clienteId}/edit")
    public String mostrarEdicaoCliente(Model model, @PathVariable("clienteId") Long clienteId) {
        Optional<Cliente> optionalCliente = this.clienteService.listarClienteId(clienteId);
        optionalCliente.ifPresent(cliente -> model.addAttribute("cliente", cliente));
        model.addAttribute("add", Boolean.FALSE);
        return "cliente-add";
    }

    @GetMapping("/cliente/{numeroDocumento}/edit")
    public String mostrarClienteDocumento(Model model, @PathVariable("numeroDocumento") String numeroDocumento) {
        Optional<Cliente> optionalCliente = this.clienteService.buscarNumeroDocumento(numeroDocumento);
        optionalCliente.ifPresent(cliente -> model.addAttribute("cliente", cliente));
        model.addAttribute("add", Boolean.FALSE);
        return "cliente-add";
    }

    @PutMapping("/cliente/{clienteId}/edit")
    public String editarCliente(@ModelAttribute("cliente") Cliente cliente,
                                @PathVariable("clienteId") Long clienteId) {
        cliente.setId(clienteId);
        this.clienteService.cadastrarCliente(cliente);
        return "redirect:/clientes";
    }
}
