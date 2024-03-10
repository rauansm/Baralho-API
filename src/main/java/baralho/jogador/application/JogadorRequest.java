package baralho.jogador.application;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
public class JogadorRequest {
    @NotBlank
    private String nome;

}
