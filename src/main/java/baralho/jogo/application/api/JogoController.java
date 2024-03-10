package baralho.jogo.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
}
