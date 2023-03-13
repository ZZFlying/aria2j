package xyz.sagrada.aria2j.domin.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DownloadStatus {
    ACTIVE("active"), WAITING("waiting"), PAUSED("paused"), ERROR("error"), COMPLETE("complete"), REMOVED("removed");

    @JsonValue
    final String name;

    DownloadStatus(String name) {
        this.name = name;
    }
}
