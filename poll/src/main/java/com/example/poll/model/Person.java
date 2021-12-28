package com.example.poll.model;

import com.fasterxml.jackson.annotation.JsonProperty;
//import java.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID ID;
//    @NotBlank
    private final String Name;

    public Person(@JsonProperty ("ID") UUID id,@JsonProperty ("name") String name) {
        ID = id;
        Name = name;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
}
