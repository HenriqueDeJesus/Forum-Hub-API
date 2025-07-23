package challange.forum.hub.domain.resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(Long id,
                                        String mensagem,
                                        LocalDateTime dataCriacao,
                                        String tituloTopico,
                                        String nomeAutor) {

    public DadosDetalhamentoResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getTopico().getTitulo(),
                resposta.getAutor().getLogin()
        );
    }
}
