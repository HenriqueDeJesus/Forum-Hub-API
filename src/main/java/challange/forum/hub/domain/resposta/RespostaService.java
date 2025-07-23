package challange.forum.hub.domain.resposta;

import challange.forum.hub.domain.resposta.*;
import challange.forum.hub.domain.topico.TopicoRepository;
import challange.forum.hub.domain.topico.EstadoTopico;
import challange.forum.hub.domain.usuario.Usuario;
import challange.forum.hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosDetalhamentoResposta cadastrarResposta(DadosCadastroResposta dadosCadastroResposta, Usuario autor) {
        var topico = topicoRepository.findById(dadosCadastroResposta.topicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        var resposta = new Resposta(dadosCadastroResposta, topico, autor);
        respostaRepository.save(resposta);

        if (topico.getEstadoTopico() == EstadoTopico.DUVIDA) {
            topico.setEstadoTopico(EstadoTopico.RESPONDIDO);
        }

        return new DadosDetalhamentoResposta(resposta);
    }

    public List<DadosListagemTopicoComRespostas> listarTodasRespostasPorTopico() {
        var topicos = topicoRepository.findAll();

        return topicos.stream()
                .map(topico -> {
                    var respostasOrdenadas = topico.getRespostas().stream()
                            .sorted(Comparator.comparing(Resposta::getDataCriacao))
                            .map(DadosListagemResposta::new)
                            .toList();

                    return new DadosListagemTopicoComRespostas(topico.getTitulo(), respostasOrdenadas);
                })
                .toList();
    }
}
