package br.com.erudio.services;
import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.ObjectMapper;

import static br.com.erudio.mapper.ObjectMapper.parseObject;

import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

   @Autowired
   PersonMapper converter;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding all people!");
                return ObjectMapper.parseListObject(repository.findAll(), PersonDTO.class);
    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");

      var entity =  repository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
              return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one person");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }
    public PersonDTOV2 createV2(PersonDTOV2 person) {

        logger.info("Creating one person V2!");
        var entity = converter.convertDTOToEntity(person);

        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one person");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

}
