package challange.forum.hub.domain.usuario.validacoes;

import challange.forum.hub.domain.usuario.DadosCadastroUsuario;
import challange.forum.hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacoesCadastroUsuarioDuplicado implements ValidadorCadastroDeUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DadosCadastroUsuario dadosCadastroUsuario){
        boolean existeDuplicado = usuarioRepository.existsByLogin(
                dadosCadastroUsuario.login()
        );

        if (existeDuplicado){
            throw new IllegalArgumentException("Já existe um usuário com email cadastrado.");
        }
    }
}
