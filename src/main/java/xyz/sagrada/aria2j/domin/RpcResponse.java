package xyz.sagrada.aria2j.domin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class RpcResponse<T> implements Serializable {
    private String jsonrpc;
    private String id;
    private T result;
    private Error error;
}
