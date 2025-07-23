package challange.forum.hub.domain.topico;

import challange.forum.hub.domain.topico.validacoes.ValidadorAtualizacaoDeTopico;
import challange.forum.hub.domain.topico.validacoes.ValidadorCadastroDeTopico;
import challange.forum.hub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorCadastroDeTopico> validadores;

    @Autowired
    private List<ValidadorAtualizacaoDeTopico> validadorAtualizacaoDeTopicos;

    public DadosDetalhamentoTopico cadastrarTopico(DadosCadastroTopico dadosCadastroTopico, Usuario autor){

        validadores.forEach(v -> v.validar(dadosCadastroTopico));

        var topico = new Topico(dadosCadastroTopico, autor);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizarTopico(DadosAtualizacaoTopico dadosAtualizacaoTopico){

        var topico = topicoRepository.findById(dadosAtualizacaoTopico.id())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        validadorAtualizacaoDeTopicos.forEach(v -> v.validar(dadosAtualizacaoTopico));

        topico.atualizarInformacoes(dadosAtualizacaoTopico);

        return new DadosDetalhamentoTopico(topico);
    }
}
