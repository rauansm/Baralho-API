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
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "carta_id")
    private List<Carta> mao = new ArrayList<>();

    public Jogador(JogadorRequest jogadorRequest) {
        this.nome = jogadorRequest.getNome();
    }
    public void atribuirCartas(List<Carta> cartasDoJogador) {
        this.mao = cartasDoJogador;
    }
}
