package io.bparolini.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bparolini.serialization.model.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class JsonSerialization {
    public static String serializePerson(List<Person> people) {
        String binaryFileName = "binaryOutput/json_serialization.json";

        var mapper = new ObjectMapper();
        try {
            var json = mapper.writeValueAsString(people);

            try (var fos = new FileOutputStream(binaryFileName);
                 var osw = new OutputStreamWriter(fos)) {
                osw.write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return binaryFileName;
    }
}
