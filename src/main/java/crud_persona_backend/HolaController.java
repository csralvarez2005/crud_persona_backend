package crud_persona_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {


    @GetMapping("/")
    public String home() {
        return "¡Bienvenido al backend del CRUD de Persona!";
    }
}