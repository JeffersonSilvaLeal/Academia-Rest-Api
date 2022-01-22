package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  
  /**
   * @author  Jefferson
   * Salva os alunos
   */
  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return alunoRepository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    Aluno aluno = alunoRepository.getById(id);
    return aluno;
  }
  
  /**
   * @author Jefferson
   * Retorna todos os alunos 
   */

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null) {
      return alunoRepository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return alunoRepository.findByDataDeNascimento(localDate);
    }

  }

  /**
   * @author Jefferson silva
   * Busca o id do aluno no banco e atualiza os dados
   */
  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
	  		
	  	
	     Aluno aluno = alunoRepository.findById(id).get();
	     aluno.setNome(formUpdate.getNome());
	     aluno.setBairro(formUpdate.getBairro());
	     aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

	    return alunoRepository.save(aluno);
	  
  }
  
  /**
   * @author Jefferson
   * 
   * Deleta o Aluno atrávez do id passado
   */

  @Override
  public void delete(Long id) {
	 
	  Optional<Aluno> aluno = alunoRepository.findById(id);
	  
	  if(aluno != null) {
		  alunoRepository.deleteById(id);
		}
		return;
	 
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = alunoRepository.findById(id).get();

    return aluno.getAvaliacoes();

  }

}
