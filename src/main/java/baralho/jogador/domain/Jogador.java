package baralho.jogador.domain;

import baralho.jogador.application.JogadorRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", updatable = false, unique = true, nullable = false)
    private Long id;
    private String nome;

    public Jogador(JogadorRequest jogadorRequest) {
        this.nome = jogadorRequest.getNome();
    }

}
