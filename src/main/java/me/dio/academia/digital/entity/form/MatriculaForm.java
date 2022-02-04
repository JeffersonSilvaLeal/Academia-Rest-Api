package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

	@NotEmpty(message = "Aluno Id não pode ser vazio")
	@NotNull(message = "Aluno Id não pode ser nulo")
	@Positive(message = "O Id do aluno precisa ser positivo.")
	private Long alunoId;
}
