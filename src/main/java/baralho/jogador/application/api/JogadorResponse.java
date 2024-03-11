package baralho.jogador.application.api;

import baralho.jogador.domain.Jogador;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class JogadorResponse {
    private Long id;

    public JogadorResponse(Jogador jogador) {
    this.id = jogador.getId();
    }
}
