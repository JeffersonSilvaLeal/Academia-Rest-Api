package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   *@OneToOne Usada para especificar um relacionamento de banco de dados um-para-um
   */
  @OneToOne(cascade = CascadeType.ALL)
  /**
   * @JoinColumnUsada para especificar a coluna FOREIGN KEY. Indica que a entidade é a responsável pelo relacionamento
   */
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @NotEmpty(message = "Data da matricula não pode ser vazio")
  @NotNull(message = "data da matricula não pode ser nulo")
  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
