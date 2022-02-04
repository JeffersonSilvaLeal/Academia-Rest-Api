package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AvaliacaoFisicaUpdateForm {

	@NotEmpty(message = "Peso não pode ser vazio")
	@NotNull(message = "Peso não pode ser nulo")
	private double peso;

	@NotEmpty(message = "Altura não pode ser vazio")
	@NotNull(message = "Altura não pode ser nulo")
	private double altura;
}
