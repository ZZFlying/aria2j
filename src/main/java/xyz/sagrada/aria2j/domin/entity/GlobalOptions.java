package xyz.sagrada.aria2j.domin.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.sagrada.aria2j.domin.enums.LogLevel;

@Getter
@Setter
@ToString
public class GlobalOptions extends Options {
    @JsonAlias("bt-max-open-files")
    private Integer btMaxOpenFiles;
    @JsonAlias("download-result")
    private String downloadResult;
    @JsonAlias("keep-unfinished-download-result")
    private Integer keepUnfinishedDownloadResult;
    @JsonAlias("log")
    private String log;
    @JsonAlias("log-level")
    private LogLevel logLevel = LogLevel.DEBUG;
    @JsonAlias("max-concurrent-downloads")
    private Integer maxConcurrentDownloads;
    @JsonAlias("max-download-result")
    private Integer maxDownloadResult;
    /**
     * Set max overall download speed in bytes/sec.
     * 0 means unrestricted. You can append K or M (1K = 1024, 1M = 1024K).
     * To limit the download speed per download, use --max-download-limit option.
     * Default: 0
     */
    @JsonAlias("max-overall-download-limit")
    private String maxOverallDownloadLimit;
    /**
     * Set max overall upload speed in bytes/sec.
     * 0 means unrestricted. You can append K or M (1K = 1024, 1M = 1024K).
     * To limit the upload speed per torrent, use --max-upload-limit option.
     * Default: 0
     */
    @JsonAlias("max-overall-upload-limit")
    private String maxOverallUploadLimit;
    @JsonAlias("optimize-concurrent-downloads")
    private String optimizeConcurrentDownloads;
    @JsonAlias("save-cookies")
    private String saveCookies;
    @JsonAlias("save-session")
    private String saveSession;
    @JsonAlias("server-stat-of")
    private String serverStatOf;
}
