package xyz.sagrada.aria2j.domin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UriStatus {
    USED("used"), WAITING("waiting");

    @JsonValue
    final String name;

    UriStatus(String name) {
        this.name = name;
    }
}
