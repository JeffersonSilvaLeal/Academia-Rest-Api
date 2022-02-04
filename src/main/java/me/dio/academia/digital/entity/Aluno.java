package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jefferson da Silva leal
 *
 * Um atalho para @ToString, @EqualsAndHashCode,@Getter em todos os campos, e @Setter
 */
@Data

/** 
 *Essa anotação é responsável por gerar um construtor sem parâmetros
 */
@NoArgsConstructor
/**
 *Gere um construtor com 1 parâmetro para cada campo da classe.
 */
@AllArgsConstructor
/**
 *È utilizada para informar que uma classe também é uma entidade.
 */
@Entity
/**
 *mapear colunas através das anotações
 */
@Table(name = "tb_alunos")
/**
 *essa anotação serve para ignorar campos que contém em nossa resposta porém não existe em nosso modelo
 *Hibernate téra um carregamento lento
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
  /**
   *Gera id automatico	
   */
  @Id
  /**
   *@GeneratedValue Serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados
   *IDENTITY quando usamos Identity falamos que deve pegar o último registro daquela tabela e seguir com base naquele
   */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "Nome não pode ser vazio")
  @NotNull(message = "Nome não pode ser nulo")
  private String nome;
  
  /**
   *É utilizada para especificar os detalhes da coluna que um campo ou propriedade será mapeado.
   */
  @Column(unique = true) // Garante que terá apenas um Cpf
  @NotEmpty(message = "CPF não pode ser vazio")
  @NotNull(message = "CPF não pode ser nulo")
  private String cpf;

  @NotEmpty(message = "Bairro não pode ser vazio")
  @NotNull(message = "Bairro não pode ser nulo")
  private String bairro;

  @NotEmpty(message = "Data de nascimento não pode ser vazio")
  @NotNull(message = "Data de nascimento não pode ser nulo")
  private LocalDate dataDeNascimento;

  /**
   *@OneToMany1 Aluno pode ter muitas Avaliações
   *Lazy carregamento preguiçõso, carrega os dados somente quando solicitado
   *JsonIgnore evita a looping de dados 
   */
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore 
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
