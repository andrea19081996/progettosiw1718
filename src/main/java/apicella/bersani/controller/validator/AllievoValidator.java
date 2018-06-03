package apicella.bersani.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import apicella.bersani.model.Allievo;

@Component
public class AllievoValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
        return Allievo.class.equals(aClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "richiesto");
		
	}
	
	

}
