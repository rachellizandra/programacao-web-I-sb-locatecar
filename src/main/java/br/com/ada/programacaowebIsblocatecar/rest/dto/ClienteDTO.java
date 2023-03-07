package br.com.ada.programacaowebIsblocatecar.rest.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String nome;
    @NotBlank(message = "Esse campo não pode estar vazio")
    @Email
    private String email;
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String tipoDocumento;

    @Column(unique = true)
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String numeroDocumento;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String telefone;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String endereco;

}
