package baralho.mao.application.service;

import baralho.jogador.domain.Carta;
import baralho.jogador.domain.Jogador;
import baralho.jogo.domain.Mao;
import baralho.mao.application.repository.MaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Log4j2
public class MaoApplicationService implements MaoService {
    private final MaoRepository maoRepository;

    @Override
    public List<Mao> adicionaMaos(List<Jogador> jogadores, List<Carta> cartas) {
        log.info("[inicia] MaoApplicationService - adicionaMaos");
        List<Mao> maos = Mao.distribuiCartas(jogadores,cartas);
        maoRepository.salva(maos);
        log.info("[finaliza] MaoApplicationService - adicionaMaos");
        return maos;
    }
}
