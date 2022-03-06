package com.lth.demoApp.dao;

import com.lth.demoApp.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao  {
        private static List<Person> db = new ArrayList<Person>();

        @Override
        public int insertPerson(UUID id, Person person){
            db.add(new Person(id, person.getName()));

            return 1;
        }
}
