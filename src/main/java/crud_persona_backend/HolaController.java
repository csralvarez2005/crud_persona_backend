package crud_persona_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public String holaMundo() {
        return "¡Hola Mundo desde Spring Boot!";
    }
}