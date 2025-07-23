package challange.forum.hub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String login) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getLogin());
    }
}
