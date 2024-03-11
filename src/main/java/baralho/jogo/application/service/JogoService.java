package baralho.jogo.application.service;

import baralho.jogo.application.api.JogoRequest;
import baralho.jogo.application.api.JogoResponse;
import baralho.jogo.application.api.ResultadoJogo;

public interface JogoService {
    JogoResponse iniciaJogo(JogoRequest novoJogo);

    ResultadoJogo obtemResultado(Long idJogo);
}
