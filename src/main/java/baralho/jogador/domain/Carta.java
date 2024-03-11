package baralho.jogador.domain;

import baralho.carta.application.service.CartaResponse;
import baralho.jogo.domain.Mao;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    private String naipe;
    private Integer ponto;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
        this.ponto = buscaPonto(valor);
    }

    private Integer buscaPonto(String valor) {
        return switch (valor) {
            case "A" -> 1;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(valor);
        };
    }

    public static List<Carta> converte(List<CartaResponse.Card> cards) {
        List<Carta> cartas = new ArrayList<>();
        for (CartaResponse.Card cartasFeign : cards) {
            String valor = cartasFeign.getValue()
                    .replace("ACE", "A")
                    .replace("JACK", "J")
                    .replace("QUEEN", "Q")
                    .replace("KING", "K");
            cartas.add(new Carta(valor, cartasFeign.getSuit()));
        }
        return cartas;
    }
}
