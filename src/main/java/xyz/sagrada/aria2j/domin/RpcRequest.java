package xyz.sagrada.aria2j.domin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
public class RpcRequest implements Serializable {
    private String jsonrpc;
    private String method;
    private String id;
    private Object params;

    public RpcRequest() {
    }

    public RpcRequest(String method, Object... params) {
        this.jsonrpc = "2.0";
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.method = method;
        this.params = Arrays.stream(params).filter(Objects::nonNull).toArray();
    }

}
