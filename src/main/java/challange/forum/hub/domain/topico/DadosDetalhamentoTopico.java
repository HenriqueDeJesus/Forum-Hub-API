package challange.forum.hub.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Curso curso, String autor, EstadoTopico estadoTopico) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getCurso(), topico.getAutor().getLogin(), topico.getEstadoTopico());
    }
}
