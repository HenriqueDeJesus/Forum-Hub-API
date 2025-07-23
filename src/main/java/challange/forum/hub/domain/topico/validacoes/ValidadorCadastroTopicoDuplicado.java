package challange.forum.hub.domain.topico.validacoes;

import challange.forum.hub.domain.topico.DadosCadastroTopico;
import challange.forum.hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCadastroTopicoDuplicado implements ValidadorCadastroDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DadosCadastroTopico dadosCadastroTopico){
        boolean existeDuplicado = topicoRepository.existsByTituloAndMensagem(
                dadosCadastroTopico.titulo(), dadosCadastroTopico.mensagem()
        );

        if (existeDuplicado){
            throw new IllegalArgumentException("Já existe um tópico com o mesmo título e mensagem.");
        }
    }
}
