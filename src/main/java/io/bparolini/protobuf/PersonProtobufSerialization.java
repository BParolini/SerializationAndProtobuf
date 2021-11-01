package io.bparolini.protobuf;

import io.bparolini.protobuf.model.PersonOuterClass;

import java.io.FileOutputStream;
import java.io.IOException;

public final class PersonProtobufSerialization {
    public static void serializePerson(PersonOuterClass.People people) {
        try (FileOutputStream fos = new FileOutputStream("binaryOutput/protobuf_serialization.binary")) {
            people.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
