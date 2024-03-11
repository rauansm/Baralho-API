package baralho.jogo.application.api;

import baralho.jogo.application.service.JogoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class JogoController implements JogoAPI {
    private final JogoService jogoService;
    @Override
    public JogoResponse iniciaJogo(JogoRequest novoJogo) {
        log.info("[inicia] JogoController - iniciaJogo");
        JogoResponse partidaIniciada = jogoService.iniciaJogo(novoJogo);
        log.info("[finaliza] JogoController - iniciaJogo");
        return partidaIniciada;
    }

    @Override
    public ResultadoJogo obtemResultado(Long idJogo) {
        log.info("[inicia] JogoController - obtemResultado");
        ResultadoJogo resultadoJogo = jogoService.obtemResultado(idJogo);
        log.info("[finaliza] JogoController - obtemResultado");
        return resultadoJogo;
    }
}
