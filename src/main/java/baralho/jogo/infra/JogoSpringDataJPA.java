package baralho.jogo.infra;


import baralho.jogo.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JogoSpringDataJPA extends JpaRepository<Jogo, Long> {
}
