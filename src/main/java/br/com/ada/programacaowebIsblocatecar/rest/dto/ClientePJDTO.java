package br.com.ada.programacaowebIsblocatecar.rest.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientePJDTO extends ClienteDTO{

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String razaoSocial;
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String cnpj;
}
