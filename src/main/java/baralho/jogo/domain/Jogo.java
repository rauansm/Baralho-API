package baralho.jogo.domain;

import baralho.jogador.domain.Jogador;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", updatable = false, unique = true, nullable = false)
    private Long idJogo;
    @OneToMany
    @JoinColumn(name = "jogador_id")
    private List<Mao> maos = new ArrayList<>();

    public Jogo(List<Mao> maos) {
        this.maos = maos;
    }

    public static void validaQuantidadeJogadores(List<Jogador> jogadores) {
        if (jogadores.size() != 4) {
            throw new RuntimeException("O jogo requer exatamente 4 jogadores.");
        }
    }
}
