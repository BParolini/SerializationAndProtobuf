package io.bparolini.serialization.service;

import io.bparolini.serialization.model.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public final class PersonSerialization {
    public static String serializePerson(List<Person> personList) {
        String binaryFileName = "binaryOutput/java_serialization.binary";

        try (FileOutputStream fos = new FileOutputStream(binaryFileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Person person : personList) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return binaryFileName;
    }
}
