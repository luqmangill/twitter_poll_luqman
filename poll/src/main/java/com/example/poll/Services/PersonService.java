package com.example.poll.Services;

import com.example.poll.Dao.PersonDao;
import com.example.poll.model.Person;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao persondao;
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao persondao) {
        this.persondao = persondao;
    }
    @PostMapping
    public int addPerson(Person person){
        return persondao.insertPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return persondao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID ID){
        return persondao.selectPersonById(ID);

    }
    public int deletePerson(UUID ID){
        return persondao.deletePersonById(ID);
    }
     public int updatePerson(UUID ID, Person newPerson){
        return persondao.updatePersonById(ID ,newPerson);
     }
}
