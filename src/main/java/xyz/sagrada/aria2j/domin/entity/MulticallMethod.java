package xyz.sagrada.aria2j.domin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MulticallMethod {
    private String methodName;
    @JsonIgnore
    private Object[] tempParams;
    private Object params;

    public MulticallMethod(String methodName, Object[] params) {
        this.methodName = methodName;
        this.tempParams = params;
    }
}
