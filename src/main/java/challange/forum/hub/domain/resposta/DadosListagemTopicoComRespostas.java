package challange.forum.hub.domain.resposta;

import java.util.List;

public record DadosListagemTopicoComRespostas(
        String tituloTopico,
        List<DadosListagemResposta> respostas
) {
}
