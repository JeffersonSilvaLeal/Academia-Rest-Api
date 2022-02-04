package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
@Api(value = "Academia Rest")
@CrossOrigin(origins = "*")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl alunoServiceImpl;
  
  @GetMapping(value = "/")
  public String index() {
	  return "http://localhost:8080/swagger-ui/index.html,"
	  		+"https://academiarest.herokuapp.com/swagger-ui/index.html";
  }

  @PostMapping(value = "/salvar", produces = "application/json")
  @ApiOperation(value = "Salva um Aluno")
  public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoForm form) {
    
    Aluno  aluno = alunoServiceImpl.create(form);
	
    return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	
  }

  @GetMapping(value = "/avaliacoes/{id}", produces = "application/json")
  @ApiOperation(value = "Busca avaliação através do Id do aluno")

  public ResponseEntity<List<AvaliacaoFisica>> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    List<AvaliacaoFisica> listAvaliacao = alunoServiceImpl.getAllAvaliacaoFisicaId(id);
    
    return new ResponseEntity<List<AvaliacaoFisica>>(listAvaliacao, HttpStatus.OK);
  }

  
  
  @GetMapping(value = "/listartodos", produces = "application/json")
  @ApiOperation(value = "Lista todos os alunos")

  public ResponseEntity<List<Aluno>> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    
	  List<Aluno> list =  alunoServiceImpl.getAll(dataDeNacimento);
    
    return new ResponseEntity<List<Aluno>>(list, HttpStatus.OK);
  }
  
  
  @DeleteMapping(value = "/excluir/{id}", produces = "application/json")
  @ApiOperation(value = "Exclui um aluno através do Id dele")

  public String Excluir(@PathVariable("id") Long id) {
	  
	  alunoServiceImpl.delete(id);
	  
	  return "Ok";  
  }

  
  @PutMapping(value = "/atualizar/{id}", produces = "application/json")
  @ApiOperation(value = "Atualiza os dados de  um Aluno")

  public ResponseEntity<Aluno> update(@PathVariable ("id") Long id, @RequestBody  AlunoUpdateForm formUpdate){
	  
	  Aluno alunoAtualizado = alunoServiceImpl.update(id, formUpdate);
	  
	  return new ResponseEntity<Aluno>(alunoAtualizado, HttpStatus.OK);
  }
}
