package baralho.jogo.application.service;

import baralho.carta.application.service.CartaService;
import baralho.jogador.application.repository.JogadorRepository;
import baralho.jogador.domain.Carta;
import baralho.jogador.domain.Jogador;
import baralho.jogo.application.api.JogoRequest;
import baralho.jogo.application.api.JogoResponse;
import baralho.jogo.application.api.ResultadoJogo;
import baralho.jogo.application.repository.JogoRepository;
import baralho.jogo.domain.Jogo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class JogoApplicationService implements JogoService {
    private final JogadorRepository jogadorRepository;
    private final CartaService cartaService;
    private final JogoRepository jogoRepository;
    private static final int NUMERO_CARTAS = 20;

    @Transactional
    @Override
    public JogoResponse iniciaJogo(JogoRequest novoJogo) {
        log.info("[inicia] JogoApplicationService - iniciaJogo");
        List<Jogador> jogadores = jogadorRepository.buscaJogadores(novoJogo.getIdsJogadores());
        List<Carta> cartas = cartaService.buscaCartas(novoJogo.getIdDeck(), NUMERO_CARTAS);
        Jogo jogo = Jogo.iniciaJogo(jogadores,cartas);
        jogoRepository.salva(jogo);
        log.info("[finaliza] JogoApplicationService - iniciaJogo");
        return new JogoResponse(jogo);
    }

    @Override
    public ResultadoJogo obtemResultado(Long idJogo) {
        log.info("[inicia] JogoApplicationService - obtemResultado");
        Jogo jogo = jogoRepository.buscaJogoPorId(idJogo);
        jogo.obtemGanhadorJogo();
        jogoRepository.salva(jogo);
        log.info("[finaliza] JogoApplicationService - obtemResultado");
        return new ResultadoJogo(jogo);
    }
}
