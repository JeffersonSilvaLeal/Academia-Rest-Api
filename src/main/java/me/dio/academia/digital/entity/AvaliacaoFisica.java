package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @NotEmpty(message = "Data de Avaliação não pode ser vazio")
  @NotNull(message = "Data de Avaliação não pode ser nulo")
  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name="peso_atual")
  private double peso;

  @Column(name="altura_atual")
  private double altura;

}
