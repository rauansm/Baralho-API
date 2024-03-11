package baralho.jogo.application.api;

import baralho.carta.application.service.CartaResponse;
import baralho.jogador.domain.Carta;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class CartaMaoResponse {
    private String valor;
    private String naipe;

    public CartaMaoResponse(Carta carta) {
        this.valor = carta.getValor();
        this.naipe = carta.getNaipe();
    }

    public static List<CartaMaoResponse> converte(List<Carta> cartas) {
      return  cartas.stream()
                .map(CartaMaoResponse::new)
              .collect(Collectors.toList());
    }
}
