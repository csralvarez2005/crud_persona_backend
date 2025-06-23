package crud_persona_backend.service;

import crud_persona_backend.dto.PersonaDTO;
import crud_persona_backend.exception.RecursoNoEncontradoException;
import crud_persona_backend.model.Persona;
import crud_persona_backend.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona crear(PersonaDTO dto) {
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setDocumento(dto.getDocumento());
        persona.setCelular(dto.getCelular());
        persona.setEmail(dto.getEmail());
        persona.setSexo(dto.getSexo());
        persona.setDireccion(dto.getDireccion());
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public Persona buscarPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Persona no encontrada con ID: " + id));
    }

    @Override
    public Persona actualizar(Long id, PersonaDTO dto) {
        Persona persona = buscarPorId(id);
        persona.setNombre(dto.getNombre());
        persona.setDocumento(dto.getDocumento());
        persona.setCelular(dto.getCelular());
        persona.setEmail(dto.getEmail());
        persona.setSexo(dto.getSexo());
        persona.setDireccion(dto.getDireccion());
        return personaRepository.save(persona);
    }

    @Override
    public void eliminar(Long id) {
        Persona persona = buscarPorId(id);
        personaRepository.delete(persona);
    }
}
