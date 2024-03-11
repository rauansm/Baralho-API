package baralho.jogo.infra;

import baralho.handler.APIException;
import baralho.jogo.application.repository.JogoRepository;
import baralho.jogo.domain.Jogo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class JogoInfraRepository implements JogoRepository {
    private final JogoSpringDataJPA jogoSpringDataJPA;
    @Override
    public Jogo salva(Jogo jogo) {
        log.info("[inicia] JogoInfraRepository - salva");
        jogoSpringDataJPA.save(jogo);
        log.info("[finaliza] JogoInfraRepository - salva");
        return jogo;
    }

    @Override
    public Jogo buscaJogoPorId(Long idJogo) {
        log.info("[inicia] JogoInfraRepository - buscaJogoPorId");
        Optional<Jogo> jogo = jogoSpringDataJPA.findById(idJogo);
        log.info("[finaliza] JogoInfraRepository - buscaJogoPorId");
        return jogo.orElseThrow(() -> APIException.entidadeNaoEncontrada(
                String.format("Jogo com id %s não encontrado", idJogo)));
    }
}
