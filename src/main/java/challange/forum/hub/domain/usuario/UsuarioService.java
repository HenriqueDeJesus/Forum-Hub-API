package challange.forum.hub.domain.usuario;

import challange.forum.hub.domain.usuario.validacoes.ValidadorAtualizacaoDeUsuario;
import challange.forum.hub.domain.usuario.validacoes.ValidadorCadastroDeUsuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private List<ValidadorCadastroDeUsuario> validadores;

    @Autowired
    private List<ValidadorAtualizacaoDeUsuario> validadorAtualizacaoDeUsuarios;

    @Autowired
    private PasswordEncoder encoder;

    public DadosDetalhamentoUsuario cadastrarUsuario(DadosCadastroUsuario dadosCadastroUsuario) {

        validadores.forEach(v -> v.validar(dadosCadastroUsuario));

        String senhaCriptografada = encoder.encode(dadosCadastroUsuario.senha());
        Usuario usuario = new Usuario(dadosCadastroUsuario.login(), senhaCriptografada);
        repository.save(usuario);
        return new DadosDetalhamentoUsuario(usuario);
    }

    public DadosDetalhamentoUsuario atualizarUsuario(DadosAtualizacaoUsuario dados) {
        var usuario = repository.findById(dados.id())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        validadorAtualizacaoDeUsuarios.forEach(v -> v.validar(dados));
        String senhaCriptografada = null;
        if (dados.senha() != null && !dados.senha().isBlank()) {
            senhaCriptografada = encoder.encode(dados.senha());
        }
        var dadosAtualizados = new DadosAtualizacaoUsuario(dados.id(), dados.login(), senhaCriptografada);

        usuario.atualizarInformacoes(dadosAtualizados);

        return new DadosDetalhamentoUsuario(usuario);
    }
}
