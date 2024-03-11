package baralho.jogo.application.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
public class JogoRequest {
    @NotNull
    private List<Long> idsJogadores;
    @NotBlank
    private String idDeck;

}
