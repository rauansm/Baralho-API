package baralho.jogo.application.api;

import baralho.jogo.domain.Jogo;
import baralho.jogo.domain.Mao;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class JogoResponse {

    private Long idJogo;
    private List<MaoResponse> maos;

    public JogoResponse(Jogo jogo) {
        this.idJogo = jogo.getIdJogo();
        this.maos = MaoResponse.converte(jogo.getMaos());
    }

}
