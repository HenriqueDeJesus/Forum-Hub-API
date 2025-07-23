package challange.forum.hub.domain.topico;

import challange.forum.hub.domain.resposta.Resposta;
import challange.forum.hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;

    public Topico(DadosCadastroTopico dadosCadastroTopico, Usuario autor){
        this.titulo = dadosCadastroTopico.titulo();
        this.mensagem = dadosCadastroTopico.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.estadoTopico = EstadoTopico.DUVIDA;
        this.autor = autor;
        this.curso = dadosCadastroTopico.curso();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dadosAtualizacaoTopico){
        if (dadosAtualizacaoTopico.titulo() != null){
            this.titulo = dadosAtualizacaoTopico.titulo();
        }
        if (dadosAtualizacaoTopico.mensagem() != null){
            this.mensagem = dadosAtualizacaoTopico.mensagem();
        }
        if (dadosAtualizacaoTopico.curso() != null){
            this.curso = dadosAtualizacaoTopico.curso();
        }
    }
}
