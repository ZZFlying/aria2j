package xyz.sagrada.aria2j.domin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.sagrada.aria2j.domin.enums.UriStatus;

@Getter
@Setter
@ToString
public class UriInfo {
    private String uri;
    private UriStatus status;
}
