package baralho.jogo.domain;

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
public class Mao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", updatable = false, unique = true, nullable = false)
    private Long idMao;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mao")
    private List<Carta> cartas = new ArrayList<>();

    public Mao(Jogador jogador, List<Carta> cartasDoJogador) {
        this.cartas = cartasDoJogador;
        this.jogador = jogador;
    }

    public static List<Mao> distribuiCartas(List<Jogador> jogadores, List<Carta> cartas) {
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
}
