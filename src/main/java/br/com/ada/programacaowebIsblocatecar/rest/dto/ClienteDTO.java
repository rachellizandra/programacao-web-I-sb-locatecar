package br.com.ada.programacaowebIsblocatecar.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String nome;
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String email;
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String tipoDocumento;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String telefone;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String endereco;

}