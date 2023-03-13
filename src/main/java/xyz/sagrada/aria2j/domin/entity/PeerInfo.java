package xyz.sagrada.aria2j.domin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PeerInfo {
    private String peerId;
    private String ip;
    private Integer port;
    private String bitfield;
    private Boolean amChoking;
    private Boolean peerChoking;
    private Integer downloadSpeed;
    private Integer uploadSpeed;
    private Boolean seeder;
}
