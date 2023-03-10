package br.com.ada.programacaowebIsblocatecar.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String nome;

    @NotBlank(message = "Esse campo não pode estar vazio")
    @Email
    private String email;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String tipoDocumento;

    @NotBlank(message = "Esse campo não pode estar vazio")
    @Column(unique = true)

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String numeroDocumento;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String telefone;

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String endereco;

}
