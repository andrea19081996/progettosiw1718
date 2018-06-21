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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "richiesto","Obbligatorio campo nome");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "richiesto","Obbligatorio campo cognome");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "richiesto","Obbligatorio campo email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "richiesto","Obbligatorio campo telefono");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "richiesto","Obbligatorio campo data di nascita");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "richiesto","Obbligatorio campo luogo di nascita");
        
        
        Allievo a= (Allievo) arg0;
        if(!a.getEmail().contains("@") && !errors.hasFieldErrors("email")) {
        	errors.rejectValue("email", "errato",new Object[]{"'email'"}, "L'indirizzo email inserito non è corretto");
        }
        if(a.getTelefono().length()!=10 && !errors.hasFieldErrors("telefono")) {
        	errors.rejectValue("telefono", "errato",new Object[]{"'telefono'"}, "Il telefono inserito non è corretto");
        }
		
	}
}
