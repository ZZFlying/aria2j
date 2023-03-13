package xyz.sagrada.aria2j.domin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GlobalStatInfo {
    private Integer numActive;
    private Integer numWaiting;
    private Integer downloadSpeed;
    private Integer uploadSpeed;
    private Integer numStopped;
    private Integer numStoppedTotal;
}
