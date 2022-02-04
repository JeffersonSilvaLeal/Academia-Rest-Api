package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

	@NotEmpty(message = "Nome não pode ser vazio")
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;

	@NotEmpty(message = "Bairro não pode ser vazio")
	@NotNull(message = "Bairro não pode ser nulo")
	private String bairro;

	@NotEmpty(message = "Data de nascimento não pode ser vazio")
	@NotNull(message = "Data de nascimento não pode ser nulo")
	private LocalDate dataDeNascimento;
}
