package com.example.poll.Dao;

import com.example.poll.model.Person;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID ID, Person person);
    default int insertPerson(Person person){
        UUID ID= UUID.randomUUID();
        return insertPerson(ID, person);
    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID ID);
    int deletePersonById(UUID ID);
    int updatePersonById(UUID ID, Person person);
}
