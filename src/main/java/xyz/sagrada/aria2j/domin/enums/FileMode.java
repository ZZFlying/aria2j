package xyz.sagrada.aria2j.domin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FileMode {
    SINGLE("single"), MULTI("multi");

    @JsonValue
    final String name;

    FileMode(String name) {
        this.name = name;
    }
}
