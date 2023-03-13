package xyz.sagrada.aria2j.domin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LogLevel {
    DEBUG("debug"), INFO("info"), NOTICE("notice"), WARN("warn"), ERROR("error");

    @JsonValue
    final String name;

    LogLevel(String level) {
        this.name = level;
    }
}
