package challange.forum.hub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, EstadoTopico estadoTopico, String autor, Curso curso) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoTopico(), topico.getAutor().getLogin(), topico.getCurso());
    }
}
