package challange.forum.hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @Email(message = "O login deve ser um e-mail válido")
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
