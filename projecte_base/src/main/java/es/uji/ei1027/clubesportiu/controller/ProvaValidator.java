package es.uji.ei1027.clubesportiu.controller;

import es.uji.ei1027.clubesportiu.model.Prova;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class ProvaValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return Prova.class.equals(cls);
        // o, si volguérem tractar també les subclasses:
        // return Nadador.class.isAssignableFrom(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Prova prova = (Prova)obj;
        if (prova.getNom().trim().equals(""))
            errors.rejectValue("nom", "obligatori",
                    "Cal introduir un valor");

        List<String> valors = Arrays.asList("Individual", "Grupal");
        if (!valors.contains(prova.getTipus()))
            errors.rejectValue("tipus", "valor incorrecte",
                    "Deu ser: Individual o Grupal");
    }
}
