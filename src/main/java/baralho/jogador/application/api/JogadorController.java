package baralho.jogador.application.api;

import baralho.jogador.application.JogadorRequest;
import baralho.jogador.application.service.JogadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class JogadorController implements JogadorAPI{
    private final JogadorService jogadorService;
    @Override
    public JogadorResponse criaNovoJogador(JogadorRequest jogadorRequest) {
        log.info("[inicia] JogadorController - criaNovoJogador");
        JogadorResponse novoJogador = jogadorService.criaJogador(jogadorRequest);
        log.info("[finaliza] JogadorController - criaNovoJogador");
        return novoJogador;
    }
}
