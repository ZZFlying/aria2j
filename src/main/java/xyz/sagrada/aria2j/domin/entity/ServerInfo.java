package xyz.sagrada.aria2j.domin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServerInfo {
    private String index;
    private Server servers;

    @Getter
    @Setter
    @ToString
    static class Server {
        private String uri;
        private String currentUri;
        private Integer downloadSpeed;
    }

}
