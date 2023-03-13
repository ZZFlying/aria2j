package xyz.sagrada.aria2j.domin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileInfo {
    private Integer index;
    private Long length;
    private String path;
    private String completedLength;
    private Boolean selected;
    private UriInfo[] uris;
}
