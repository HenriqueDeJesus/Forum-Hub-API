package challange.forum.hub.domain.usuario.validacoes;

import challange.forum.hub.domain.usuario.DadosAtualizacaoUsuario;
import challange.forum.hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoUsuarioDuplicado implements ValidadorAtualizacaoDeUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DadosAtualizacaoUsuario dadosAtualizacaoUsuario){
        var usuarioComMesmoEmail = usuarioRepository.findByLogin(dadosAtualizacaoUsuario.login());
        if (usuarioComMesmoEmail.isPresent() && !usuarioComMesmoEmail.get().getId().equals(dadosAtualizacaoUsuario.id())) {
            throw new IllegalArgumentException("Já existe um usuário com esse email.");
        }
    }
}
