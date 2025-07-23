package challange.forum.hub.domain.resposta;

import challange.forum.hub.domain.topico.Topico;
import challange.forum.hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    public Resposta(DadosCadastroResposta dadosCadastroResposta, Topico topico, Usuario autor){
        this.mensagem = dadosCadastroResposta.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.topico = topico;
        this.autor = autor;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoResposta dadosAtualizacaoResposta) {
        if (dadosAtualizacaoResposta.mensagem() != null) {
            this.mensagem = dadosAtualizacaoResposta.mensagem();
        }
    }
}
