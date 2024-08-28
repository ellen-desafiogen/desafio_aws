package com.aws.generation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Operation(summary = "Listar todos os alunos")
    @GetMapping
    public List<aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Operation(summary = "Criar um novo aluno")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public aluno createAluno(@RequestBody aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Operation(summary = "Obter um aluno pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<aluno> getAlunoById(@PathVariable Long id) {
    	aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno);
    }

    @Operation(summary = "Atualizar um aluno")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<aluno> updateAluno(@PathVariable Long id, @RequestBody aluno alunoDetails) {
    	aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        aluno.setNome(alunoDetails.getNome());
        aluno.setNome(alunoDetails.getNome());
        aluno.setNotaPrimeiroSemestre(alunoDetails.getNotaPrimeiroSemestre());
        aluno.setNotaPrimeiroSemestre(alunoDetails.getNotaPrimeiroSemestre());
        aluno.setNomeProfessor(alunoDetails.getNomeProfessor());
        aluno.setNumeroSala(alunoDetails.getNumeroSala());
        aluno updatedAluno = alunoRepository.save(aluno);
        return ResponseEntity.ok(updatedAluno);
    }

    @Operation(summary = "Deletar um aluno")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Aluno deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.delete(aluno);
        return ResponseEntity.noContent().build();
    }
}
