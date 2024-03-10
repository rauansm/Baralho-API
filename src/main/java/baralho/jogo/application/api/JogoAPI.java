package baralho.jogo.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jogo")
public interface JogoAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    JogoResponse iniciaJogo(@RequestBody @Valid JogoRequest novoJogo);

    @GetMapping("/{idJogo}/resultado")
    @ResponseStatus(HttpStatus.OK)
    ResultadoJogo obtemResultado (@PathVariable Long idJogo);
}
