package challange.forum.hub.domain.resposta;

import java.time.LocalDateTime;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        String nomeAutor,
        LocalDateTime dataCriacao
) {
    public DadosListagemResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getAutor().getLogin(),
                resposta.getDataCriacao()
        );
    }
}
