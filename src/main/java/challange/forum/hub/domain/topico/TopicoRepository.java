package challange.forum.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
    SELECT t FROM Topico t
    WHERE (:curso IS NULL OR t.curso = :curso)
      AND (:ano IS NULL OR YEAR(t.dataCriacao) = :ano)
""")
    Page<Topico> buscarTopicosFiltrando(@Param("curso") Curso curso,
                                        @Param("ano") Integer ano,
                                        Pageable pageable);

    boolean existsByTituloAndMensagem(@NotBlank String titulo, @NotBlank String mensagem);

    Optional<Topico> findByTitulo(String titulo);
    Optional<Topico> findByMensagem(String mensagem);

}
