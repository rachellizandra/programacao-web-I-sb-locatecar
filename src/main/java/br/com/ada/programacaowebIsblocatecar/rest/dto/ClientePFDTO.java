package br.com.ada.programacaowebIsblocatecar.rest.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientePFDTO extends ClienteDTO{
    @NotBlank(message = "Esse campo não pode estar vazio")
    private Integer dataDeNascimento;
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String cpf;

}
