package io.bparolini;

import io.bparolini.protobuf.PersonProtobufSerialization;
import io.bparolini.protobuf.model.PersonOuterClass;
import io.bparolini.serialization.model.Person;
import io.bparolini.serialization.model.PersonSerialization;

import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var peopleSerialization = new ArrayList<Person>();
        peopleSerialization.add(new Person(UUID.randomUUID(), "Bruno", "Parolini", "123456789-00"));
        peopleSerialization.add(new Person(UUID.randomUUID(), "John", "Wick", "123456789-00"));
        peopleSerialization.add(new Person(UUID.randomUUID(), "Aelin", "Galathynius", "123456789-00"));

        PersonSerialization.serializePerson(peopleSerialization);

        PersonOuterClass.People peopleProto = fromPeopleToProto(peopleSerialization);
        PersonProtobufSerialization.serializePerson(peopleProto);
    }

    private static PersonOuterClass.People fromPeopleToProto(ArrayList<Person> peopleSerialization) {
        var peopleBuilder = PersonOuterClass.People.newBuilder();

        var personBuilder = PersonOuterClass.Person.newBuilder();
        peopleSerialization.forEach(person -> {
            personBuilder.setId(PersonOuterClass.UUID.newBuilder().setValue(person.id().toString()))
                .setFirstName(person.firstName()).setLastName(person.lastName())
                .setDocument(person.document());

            peopleBuilder.addPeople(personBuilder.build());
            personBuilder.clear();
        });

        return peopleBuilder.build();
    }
}
