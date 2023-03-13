package xyz.sagrada.aria2j.domin.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Options {
    @JsonAlias("all-proxy")
    private String allProxy;
    @JsonAlias("all-proxy-passwd")
    private String allProxyPasswd;
    @JsonAlias("all-proxy-user")
    private String allProxyUser;
    @JsonAlias("allow-overwrite")
    private Boolean allowOverwrite;
    @JsonAlias("allow-piece-length-change")
    private Boolean allowPieceLengthChange;
    @JsonAlias("always-resume")
    private Boolean alwaysResume;
    @JsonAlias("async-dns")
    private Boolean asyncDns;
    @JsonAlias("auto-file-renaming")
    private Boolean autoFileRenaming;
    @JsonAlias("bt-enable-hook-after-hash-check")
    private Boolean btEnableHookAfterHashCheck;
    @JsonAlias("bt-enable-lpd")
    private Boolean btEnableLpd;
    @JsonAlias("bt-exclude-tracker")
    private String[] btExcludeTracker;
    @JsonAlias("bt-external-ip")
    private String btExternalIp;
    @JsonAlias("bt-force-encryption")
    private Boolean btForceEncryption;
    @JsonAlias("bt-hash-check-seed")
    private Boolean btHashCheckSeed;
    @JsonAlias("bt-load-saved-metadata")
    private Boolean btLoadSavedMetadata;
    @JsonAlias("bt-max-peers")
    private Integer btMaxPeers;
    @JsonAlias("bt-metadata-only")
    private Boolean btMetadataOnly;
    @JsonAlias("bt-min-crypto-level")
    private String btMinCryptoLevel;
    @JsonAlias("bt-prioritize-piece")
    private String btPrioritizePiece;
    @JsonAlias("bt-remove-unselected-file")
    private Boolean btRemoveUnselectedFile;
    @JsonAlias("bt-request-peer-speed-limit")
    private String btRequestPeerSpeedLimit;
    @JsonAlias("bt-require-crypto")
    private Boolean btRequireCrypto;
    @JsonAlias("bt-save-metadata")
    private Boolean btSaveMetadata;
    @JsonAlias("bt-seed-unverified")
    private Boolean btSeedUnverified;
    @JsonAlias("bt-stop-timeout")
    private Integer btStopTimeout;
    @JsonAlias("bt-tracker")
    private String[] btTracker;
    @JsonAlias("bt-tracker-connect-timeout")
    private Integer btTrackerConnectTimeout;
    @JsonAlias("bt-tracker-interval")
    private Integer btTrackerInterval;
    @JsonAlias("bt-tracker-timeout")
    private Integer btTrackerTimeout;
    @JsonAlias("check-integrity")
    private Boolean checkIntegrity;
    @JsonAlias("checksum")
    private String checksum;
    @JsonAlias("conditional-get")
    private Boolean conditionalGet;
    @JsonAlias("connect-timeout")
    private Integer connectTimeout;
    @JsonAlias("content-disposition-default-utf8")
    private Boolean contentDispositionDefaultUtf8;
    @JsonAlias("continue")
    private Boolean continueT;
    @JsonAlias("dir")
    private String dir;
    @JsonAlias("dry-run")
    private Boolean dryRun;
    @JsonAlias("enable-http-keep-alive")
    private Boolean enableHttpKeepAlive;
    @JsonAlias("enable-http-pipelining")
    private Boolean enableHttpPipelining;
    @JsonAlias("enable-mmap")
    private Boolean enableMmap;
    @JsonAlias("enable-peer-exchange")
    private Boolean enablePeerExchange;
    @JsonAlias("file-allocation")
    private String fileAllocation;
    @JsonAlias("follow-metalink")
    private String followMetalink;
    @JsonAlias("follow-torrent")
    private String followTorrent;
    @JsonAlias("force-save")
    private Boolean forceSave;
    @JsonAlias("ftp-passwd")
    private String ftpPasswd;
    @JsonAlias("ftp-pasv")
    private Boolean ftpPasv;
    @JsonAlias("ftp-proxy")
    private String ftpProxy;
    @JsonAlias("ftp-proxy-passwd")
    private String ftpProxyPasswd;
    @JsonAlias("ftp-proxy-user")
    private String ftpProxyUser;
    @JsonAlias("ftp-reuse-connection")
    private Boolean ftpReuseConnection;
    @JsonAlias("ftp-type")
    private String ftpType;
    @JsonAlias("ftp-user")
    private String ftpUser;
    @JsonAlias("gid")
    private String gid;
    @JsonAlias("hash-check-only")
    private Boolean hashCheckOnly;
    @JsonAlias("header")
    private String header;
    @JsonAlias("http-accept-gzip")
    private Boolean httpAcceptGzip;
    @JsonAlias("http-auth-challenge")
    private Boolean httpAuthChallenge;
    @JsonAlias("http-no-cache")
    private Boolean httpNoCache;
    @JsonAlias("http-passwd")
    private String httpPasswd;
    @JsonAlias("http-proxy")
    private String httpProxy;
    @JsonAlias("http-proxy-passwd")
    private String httpProxyPasswd;
    @JsonAlias("http-proxy-user")
    private String httpProxyUser;
    @JsonAlias("http-user")
    private String httpUser;
    @JsonAlias("https-proxy")
    private String httpsProxy;
    @JsonAlias("https-proxy-passwd")
    private String httpsProxyPasswd;
    @JsonAlias("https-proxy-user")
    private String httpsProxyUser;
    @JsonAlias("index-out")
    private String indexOut;
    @JsonAlias("lowest-speed-limit")
    private String lowestSpeedLimit;
    @JsonAlias("max-connection-per-server")
    private Integer maxConnectionPerServer;
    @JsonAlias("max-download-limit")
    private String maxDownloadLimit;
    @JsonAlias("max-file-not-found")
    private Integer maxFileNotFound;
    @JsonAlias("max-mmap-limit")
    private Long maxMmapLimit;
    @JsonAlias("max-resume-failure-tries")
    private Integer maxResumeFailureTries;
    @JsonAlias("max-tries")
    private Integer maxTries;
    @JsonAlias("max-upload-limit")
    private String maxUploadLimit;
    @JsonAlias("metalink-base-uri")
    private String metalinkBaseUri;
    @JsonAlias("metalink-enable-unique-protocol")
    private Boolean metalinkEnableUniqueProtocol;
    @JsonAlias("metalink-language")
    private String metalinkLanguage;
    @JsonAlias("metalink-location")
    private String[] metalinkLocation;
    @JsonAlias("metalink-os")
    private String metalinkOs;
    @JsonAlias("metalink-preferred-protocol")
    private String metalinkPreferredProtocol;
    @JsonAlias("metalink-version")
    private String metalinkVersion;
    @JsonAlias("min-split-size")
    private String minSplitSize;
    @JsonAlias("no-file-allocation-limit")
    private String noFileAllocationLimit;
    @JsonAlias("no-netrc")
    private Boolean noNetrc;
    @JsonAlias("no-proxy")
    private String noProxy;
    @JsonAlias("out")
    private String out;
    @JsonAlias("parameterized-uri")
    private Boolean parameterizedUri;
    @JsonAlias("pause")
    private Boolean pause;
    @JsonAlias("pause-metadata")
    private Boolean pauseMetadata;
    @JsonAlias("piece-length")
    private String pieceLength;
    @JsonAlias("proxy-method")
    private String proxyMethod;
    @JsonAlias("realtime-chunk-checksum")
    private Boolean realtimeChunkChecksum;
    @JsonAlias("referer")
    private String referer;
    @JsonAlias("remote-time")
    private Boolean remoteTime;
    @JsonAlias("remove-control-file")
    private Boolean removeControlFile;
    @JsonAlias("retry-wait")
    private Integer retryWait;
    @JsonAlias("reuse-uri")
    private Boolean reuseUri;
    @JsonAlias("rpc-save-upload-metadata")
    private Boolean rpcSaveUploadMetadata;
    @JsonAlias("seed-ratio")
    private Double seedRatio;
    @JsonAlias("seed-time")
    private Integer seedTime;
    @JsonAlias("select-file")
    private String selectFile;
    @JsonAlias("split")
    private Integer split;
    @JsonAlias("ssh-host-key-md")
    private String sshHostKeyMd;
    @JsonAlias("stream-piece-selector")
    private String streamPieceSelector;
    @JsonAlias("timeout")
    private Integer timeout;
    @JsonAlias("uri-selector")
    private String uriSelector;
    @JsonAlias("use-head")
    private Boolean useHead;
    @JsonAlias("user-agent")
    private String userAgent;
}
