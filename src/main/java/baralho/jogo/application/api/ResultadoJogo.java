package baralho.jogo.application.api;

import baralho.jogo.domain.Jogo;
import baralho.jogo.domain.Mao;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class ResultadoJogo {
    private List<String> vencedores;

    public ResultadoJogo(Jogo jogo) {
        this.vencedores = jogo.obtemGanhadorJogo().stream()
                .map(mao -> mao.getJogador().getNome() + " com " + mao.calcularPontuacao() + " pontos")
                .collect(Collectors.toList());
    }

}
