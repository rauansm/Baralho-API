package baralho.jogador.application.api;

import baralho.jogador.application.JogadorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jogador")
public interface JogadorAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    JogadorResponse criaNovoJogador(@RequestBody @Valid JogadorRequest jogadorRequest);
}
