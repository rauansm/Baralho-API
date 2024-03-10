package baralho.jogador.application.service;

import baralho.jogador.application.JogadorRequest;
import baralho.jogador.application.api.JogadorResponse;
import baralho.jogador.application.repository.JogadorRepository;
import baralho.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class JogadorApplicationService implements JogadorService {
    private final JogadorRepository jogadorRepository;
    @Override
    public JogadorResponse criaJogador(JogadorRequest jogadorRequest) {
        log.info("[inicia] JogadorApplicationService - criaJogador");
        Jogador jogador = jogadorRepository.salva(new Jogador(jogadorRequest));
        log.info("[finaliza] JogadorApplicationService - criaJogador");
        return new JogadorResponse(jogador);
    }
}
