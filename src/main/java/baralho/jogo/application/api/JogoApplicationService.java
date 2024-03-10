package baralho.jogo.application.api;

import baralho.carta.application.service.CartaService;
import baralho.jogador.application.repository.JogadorRepository;
import baralho.jogador.domain.Carta;
import baralho.jogador.domain.Jogador;
import baralho.jogo.application.repository.JogoRepository;
import baralho.jogo.domain.Jogo;
import baralho.jogo.domain.Mao;
import baralho.mao.application.service.MaoService;
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
    private final MaoService maoService;

    @Transactional
    @Override
    public JogoResponse iniciaJogo(JogoRequest novoJogo) {
        log.info("[inicia] JogoApplicationService - iniciaJogo");
        List<Jogador> jogadores = jogadorRepository.buscaJogadores(novoJogo.getIdsJogadores());
        List<Carta> cartas = cartaService.buscaCartas(novoJogo.getIdDeck(), 20);
        Jogo.validaQuantidadeJogadores(jogadores);
        List<Mao> maos = maoService.adicionaMaos(jogadores, cartas);
        Jogo jogo = jogoRepository.salva(new Jogo(maos));
        log.info("[finaliza] JogoApplicationService - iniciaJogo");
        return new JogoResponse(jogo);
    }
}
