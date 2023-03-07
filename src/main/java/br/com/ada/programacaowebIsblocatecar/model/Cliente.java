package br.com.ada.programacaowebIsblocatecar.model;

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
    private String nome;
    private String email;
    private String tipoDocumento;
    @Column(unique = true)
    private String numeroDocumento;
    private String telefone;
    private String endereco;

}
