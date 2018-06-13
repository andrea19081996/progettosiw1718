package apicella.bersani.controller.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import apicella.bersani.model.Allievo;
import apicella.bersani.model.Attivita;

@Component
public class AttivitaValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
        return Attivita.class.equals(aClass);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		System.out.println("Controllo attivita");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "richiesto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orario", "richiesto");

        Attivita a = (Attivita) arg0;
        if(errors.hasFieldErrors("data"))
        {
        	errors.rejectValue("data", "dataNonValida");
        }
        
      
	}
	
	
	

}
