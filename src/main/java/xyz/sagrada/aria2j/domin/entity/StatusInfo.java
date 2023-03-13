package xyz.sagrada.aria2j.domin.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.sagrada.aria2j.domin.enums.DownloadStatus;
import xyz.sagrada.aria2j.domin.enums.FileMode;

@Getter
@Setter
@ToString
public class StatusInfo {
    private String gid;
    private DownloadStatus status;
    private Long totalLength;
    private Long completedLength;
    private Long uploadLength;
    private String bitfield;
    private Integer downloadSpeed;
    private Integer uploadSpeed;
    private String infoHash;
    private Integer numSeeders;
    private Boolean seeder;
    private Long pieceLength;
    private Long numPieces;
    private Integer connections;
    private Integer errorCode;
    private String errorMessage;
    private String[] followedBy;
    private String following;
    private String belongsTo;
    private String dir;
    private FileInfo[] files;
    private Bittorrent bittorrent;
    private Long verifiedLength;
    private Boolean verifyIntegrityPending;

    @Getter
    @Setter
    @ToString
    static class Bittorrent {
        private String[][] announceList;
        private String comment;
        private Long creationDate;
        private FileMode mode;
        private Info info;
    }

    @Getter
    @Setter
    @ToString
    static class Info {
        private String name;
    }
}
