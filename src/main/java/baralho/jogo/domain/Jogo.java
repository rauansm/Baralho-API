package baralho.jogo.domain;

import baralho.handler.APIException;
import baralho.jogador.domain.Carta;
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "jogo_id", referencedColumnName = "idJogo")
    private List<Mao> maos = new ArrayList<>();

    public Jogo(List<Mao> maos) {
        this.maos = maos;
    }

    public static Jogo iniciaJogo(List<Jogador> jogadores, List<Carta> cartas) {
        validaQuantidadeJogadores(jogadores);
        List<Mao> maos = distribuiCartas(jogadores,cartas);
        return new Jogo(maos);
    }

    private static List<Mao> distribuiCartas(List<Jogador> jogadores, List<Carta> cartas) {
        List<Mao> maos = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            List<Carta> cartasDoJogador = cartas.stream()
                    .skip(jogadores.indexOf(jogador) * 5L)
                    .limit(5)
                    .collect(Collectors.toList());
            Mao mao = new Mao(jogador, cartasDoJogador);
            maos.add(mao);
        }
        return maos;
    }

    public static void validaQuantidadeJogadores(List<Jogador> jogadores) {
        if (jogadores.size() != 4) {
            throw APIException.negocio("O jogo requer exatamente 4 jogadores.");
        }
    }


    public List<Mao> obtemGanhadorJogo() {
       int maiorPontuacao = calculaMaiorPontuacao();
       List<Mao> vencedores = obtemVencedores(maiorPontuacao);
        return vencedores;


    }

    private List<Mao> obtemVencedores(int maiorPontuacao) {
        return maos.stream()
                .filter(mao -> mao.calcularPontuacao() == maiorPontuacao)
                .collect(Collectors.toList());
    }

    private int calculaMaiorPontuacao() {
    return maos.stream()
                .mapToInt(Mao::calcularPontuacao)
                .max()
                .orElse(0);

    }
}
