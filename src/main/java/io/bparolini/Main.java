package io.bparolini;

import io.bparolini.protobuf.PersonProtobufSerialization;
import io.bparolini.protobuf.model.PersonOuterClass;
import io.bparolini.serialization.model.Person;
import io.bparolini.serialization.service.PersonSerialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var peopleSerialization = IntStream.range(0, 20)
            .mapToObj(value -> new Person())
            .collect(Collectors.toList());

        String javaSerializationFileName = PersonSerialization.serializePerson(peopleSerialization);

        PersonOuterClass.People peopleProto = fromPeopleToProto(peopleSerialization);
        String protobufSerializationFileName = PersonProtobufSerialization.serializePerson(peopleProto);

        printBinarySize(javaSerializationFileName, protobufSerializationFileName);
    }

    private static void printBinarySize(String javaSerializationFileName, String protobufSerializationFileName) {
        System.out.printf("Java serialization file size in bytes: %s%n", getSizeInBytes(javaSerializationFileName));
        System.out.printf("Protobuf serialization file size in bytes: %s%n", getSizeInBytes(protobufSerializationFileName));
    }

    private static String getSizeInBytes(String fileName) {
        Path filePath = Paths.get(fileName);
        try {
            long size = Files.size(filePath);
            return String.format("%d bytes", size);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("(Could not find extract size information from %s)", fileName);
    }

    private static PersonOuterClass.People fromPeopleToProto(List<Person> peopleSerialization) {
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
