package baralho.jogador.infra;

import baralho.jogador.application.repository.JogadorRepository;
import baralho.jogador.domain.Jogador;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class JogadorInfraRepository implements JogadorRepository {
    private final JogadorSpringDataJPA jogadorSpringDataJPA;
    @Override
    public Jogador salva(Jogador jogador) {
        log.info("[inicia] JogadorInfraRepository - salva");
        jogadorSpringDataJPA.save(jogador);
        log.info("[finaliza] JogadorInfraRepository - salva");
        return jogador;
    }
    @Override
    public List<Jogador> buscaJogadores(List<Long> idJogadores) {
        log.info("[inicia] JogadorInfraRepository - listaJogadores");
        List<Jogador> jogadores = jogadorSpringDataJPA.findAllById(idJogadores);
        log.info("[finaliza] JogadorInfraRepository - listaJogadores");
        return jogadores;
    }
}
