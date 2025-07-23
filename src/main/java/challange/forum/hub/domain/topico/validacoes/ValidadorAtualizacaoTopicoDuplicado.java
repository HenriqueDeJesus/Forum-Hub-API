package challange.forum.hub.domain.topico.validacoes;

import challange.forum.hub.domain.topico.DadosAtualizacaoTopico;
import challange.forum.hub.domain.topico.DadosCadastroTopico;
import challange.forum.hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoTopicoDuplicado implements ValidadorAtualizacaoDeTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosAtualizacaoTopico dadosAtualizacaoTopico){
        var topicoComMesmoTitulo = topicoRepository.findByTitulo(dadosAtualizacaoTopico.titulo());
        if (topicoComMesmoTitulo.isPresent() && !topicoComMesmoTitulo.get().getId().equals(dadosAtualizacaoTopico.id())) {
            throw new IllegalArgumentException("Já existe um tópico com esse título.");
        }

        var topicoComMesmaMensagem = topicoRepository.findByMensagem(dadosAtualizacaoTopico.mensagem());
        if (topicoComMesmaMensagem.isPresent() && !topicoComMesmaMensagem.get().getId().equals(dadosAtualizacaoTopico.id())) {
            throw new IllegalArgumentException("Já existe um tópico com essa mensagem.");
        }
    }
}
