package challange.forum.hub.controller;

import challange.forum.hub.domain.resposta.*;
import challange.forum.hub.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private RespostaRepository respostaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroResposta dadosCadastroResposta, UriComponentsBuilder uriComponentsBuilder){
        var usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var dto = respostaService.cadastrarResposta(dadosCadastroResposta, usuario);
        var uri = uriComponentsBuilder.path("/respostas/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity listarTodasRespostasPorTopico() {
        var dto = respostaService.listarTodasRespostasPorTopico();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var resposta = respostaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoResposta dadosAtualizacaoResposta){
        var resposta =respostaRepository.getReferenceById(dadosAtualizacaoResposta.id());
        resposta.atualizarInformacoes(dadosAtualizacaoResposta);

        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        respostaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
