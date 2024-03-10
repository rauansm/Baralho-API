package baralho.jogo.domain;

import baralho.handler.APIException;
import baralho.jogador.domain.Jogador;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            throw APIException.negocio("O jogo requer exatamente 4 jogadores.");
        }
    }

    public List<Mao> obtemGanhadorJogo() {
       int maiorPontuacao = maos.stream()
               .mapToInt(Mao::calcularPontuacao)
               .max()
               .orElse(0);

        return maos.stream()
                .filter(mao -> mao.calcularPontuacao() == maiorPontuacao)
                .collect(Collectors.toList());


    }
}
