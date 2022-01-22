package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

  private String nome;
  
  /**
   *É utilizada para especificar os detalhes da coluna que um campo ou propriedade será mapeado.
   */
  @Column(unique = true) // Garante que terá apenas um Cpf
  private String cpf;

  private String bairro;


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
