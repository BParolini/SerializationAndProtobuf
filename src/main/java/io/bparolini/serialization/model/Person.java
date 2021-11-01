package io.bparolini.serialization.model;

import java.io.Serializable;
import java.util.UUID;

public record Person(UUID id,
                     String firstName,
                     String lastName,
                     String document) implements Serializable {
}
