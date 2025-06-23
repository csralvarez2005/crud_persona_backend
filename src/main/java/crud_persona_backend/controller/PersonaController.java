package crud_persona_backend.controller;

import crud_persona_backend.dto.PersonaDTO;
import crud_persona_backend.model.Persona;
import crud_persona_backend.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*") // si vas a consumir desde frontend
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public Persona crear(@RequestBody PersonaDTO dto) {
        return personaService.crear(dto);
    }

    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    @GetMapping("/{id}")
    public Persona obtenerPorId(@PathVariable Long id) {
        return personaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody PersonaDTO dto) {
        return personaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
    }
    @GetMapping("/")
    public String checkApi() {
        return "API activa";
    }
}
