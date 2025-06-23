package crud_persona_backend.service;

import crud_persona_backend.dto.PersonaDTO;
import crud_persona_backend.model.Persona;

import java.util.List;

public interface PersonaService {
    Persona crear(PersonaDTO dto);
    List<Persona> listar();
    Persona buscarPorId(Long id);
    Persona actualizar(Long id, PersonaDTO dto);
    void eliminar(Long id);
}
