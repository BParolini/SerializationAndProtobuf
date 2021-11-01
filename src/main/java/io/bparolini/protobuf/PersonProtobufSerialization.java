package io.bparolini.protobuf;

import io.bparolini.protobuf.model.PersonOuterClass;

import java.io.FileOutputStream;
import java.io.IOException;

public final class PersonProtobufSerialization {
    public static String serializePerson(PersonOuterClass.People people) {
        String binaryFileName = "binaryOutput/protobuf_serialization.binary";

        try (FileOutputStream fos = new FileOutputStream(binaryFileName)) {
            people.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return binaryFileName;
    }
}
