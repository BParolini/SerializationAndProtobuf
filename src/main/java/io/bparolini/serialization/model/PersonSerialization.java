package io.bparolini.serialization.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public final class PersonSerialization {
    public static void serializePerson(List<Person> personList) {
        try (FileOutputStream fos = new FileOutputStream("binaryOutput/java_serialization.binary");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Person person : personList) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
