package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

  @NotEmpty(message = "Nota não pode ser vazia")
  @NotNull(message = "Nota não pode ser nula")
  @Positive(message = "${validatedValue}' precisa ser positivo.")
  private double peso;

  @NotEmpty(message = "Altura não pode ser vazio")
  @NotNull(message = "Altura não pode ser nulo")
  @Positive(message = "${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;
}
