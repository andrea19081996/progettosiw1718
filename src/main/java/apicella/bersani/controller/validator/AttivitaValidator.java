package apicella.bersani.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import apicella.bersani.model.Attivita;

@Component
public class AttivitaValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
        return Attivita.class.equals(aClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orario", "richiesto");
        
        if(errors.hasFieldErrors("data"))
        {
        	errors.rejectValue("data", "dataNonValida");
        }
        
      
	}

}
