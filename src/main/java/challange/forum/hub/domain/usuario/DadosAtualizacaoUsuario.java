package challange.forum.hub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario (
        @NotNull
        Long id,
        String login,
        String senha
){
}
