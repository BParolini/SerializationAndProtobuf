package io.bparolini.serialization.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.util.UUID;

public record Person(UUID id,
                     String firstName,
                     String lastName,
                     String document) implements Serializable {

    /**
     * Special constructor to create dummy instances
     */
    public Person() {
        this(UUID.randomUUID(),
            RandomStringUtils.random(RandomUtils.nextInt(5, 20), true, false),
            RandomStringUtils.random(RandomUtils.nextInt(5, 20), true, false),
            generateRandomCPF());
    }

    private static String generateRandomCPF() {
        return String.format(("%03d.%03d.%03d-%02d"),
            RandomUtils.nextInt(1, 999), RandomUtils.nextInt(1, 999),
            RandomUtils.nextInt(1, 999), RandomUtils.nextInt(1, 99));
    }
}
