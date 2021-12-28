package com.example.poll.Dao;

import com.example.poll.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{
    private static List<Person> DB= new ArrayList<>();
    @Override
    public int insertPerson(UUID ID, Person person) {
        DB.add(new Person(ID, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID ID) {
        return DB.stream()
                .filter(person -> person.getID().equals(ID))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID ID) {
       Optional<Person> findPerson= selectPersonById(ID);
        DB.remove(findPerson.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID ID, Person person) {
        return selectPersonById(ID)
                .map(p -> {
                    int indexOFPersonToDelete = DB.indexOf(person);
                    if(indexOFPersonToDelete >=0){
                        DB.set(indexOFPersonToDelete, person);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);..
    }
}
