package baralho.jogo.application.api;

import baralho.jogo.domain.Mao;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class MaoResponse {

    private String jogador;
    private List<CartaMaoResponse> cartas;

    public MaoResponse(Mao mao) {
        this.jogador = mao.getJogador().getNome();
        this.cartas = CartaMaoResponse.converte(mao.getCartas());
    }


    public static List<MaoResponse> converte(List<Mao> maos) {
     return maos.stream()
                .map(MaoResponse::new)
                .collect(Collectors.toList());
    }
}
