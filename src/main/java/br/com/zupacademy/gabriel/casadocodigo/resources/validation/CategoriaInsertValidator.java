package br.com.zupacademy.gabriel.casadocodigo.resources.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.gabriel.casadocodigo.dtos.CategoriaDTO;
import br.com.zupacademy.gabriel.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.gabriel.casadocodigo.resources.exception.FieldMessage;

public class CategoriaInsertValidator implements ConstraintValidator<CategoriaInsert, CategoriaDTO> {

	@Autowired
	private CategoriaRepository repository;
	
	public void initialize(CategoriaInsert ci) {}

	@Override
	public boolean isValid(CategoriaDTO catDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<FieldMessage>();

		var obj = repository.findByNome(catDto.getNome());
		if (obj != null) {
			list.add(new FieldMessage("nome", "Categoria com nome " + catDto.getNome() + " já existe!"));
		}
		for (FieldMessage f : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
