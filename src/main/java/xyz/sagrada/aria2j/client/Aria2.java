package xyz.sagrada.aria2j.client;

import xyz.sagrada.aria2j.domin.entity.FileInfo;
import xyz.sagrada.aria2j.domin.entity.GlobalOptions;
import xyz.sagrada.aria2j.domin.entity.GlobalStatInfo;
import xyz.sagrada.aria2j.domin.entity.MulticallMethod;
import xyz.sagrada.aria2j.domin.entity.Options;
import xyz.sagrada.aria2j.domin.entity.PeerInfo;
import xyz.sagrada.aria2j.domin.entity.ServerInfo;
import xyz.sagrada.aria2j.domin.entity.SessionInfo;
import xyz.sagrada.aria2j.domin.entity.StatusInfo;
import xyz.sagrada.aria2j.domin.entity.UriInfo;
import xyz.sagrada.aria2j.domin.entity.VersionInfo;
import xyz.sagrada.aria2j.domin.enums.How;

import java.util.List;

public interface Aria2 {
    String ADD_METALINK = "aria2.addMetalink";
    String ADD_TORRENT = "aria2.addTorrent";
    String ADD_URI = "aria2.addUri";
    String CHANGE_GLOBAL_OPTION = "aria2.changeGlobalOption";
    String CHANGE_OPTION = "aria2.changeOption";
    String CHANGE_POSITION = "aria2.changePosition";
    String CHANGE_URI = "aria2.changeUri";
    String FORCE_PAUSE = "aria2.forcePause";
    String FORCE_PAUSE_ALL = "aria2.forcePauseAll";
    String FORCE_REMOVE = "aria2.forceRemove";
    String FORCE_SHUTDOWN = "aria2.forceShutdown";
    String GET_FILES = "aria2.getFiles";
    String GET_GLOBAL_OPTION = "aria2.getGlobalOption";
    String GET_GLOBAL_STAT = "aria2.getGlobalStat";
    String GET_OPTION = "aria2.getOption";
    String GET_PEERS = "aria2.getPeers";
    String GET_SERVERS = "aria2.getServers";
    String GET_SESSION_INFO = "aria2.getSessionInfo";
    String GET_URIS = "aria2.getUris";
    String GET_VERSION = "aria2.getVersion";
    String PAUSE = "aria2.pause";
    String PAUSE_ALL = "aria2.pauseAll";
    String PURGE_DOWNLOAD_RESULT = "aria2.purgeDownloadResult";
    String REMOVE = "aria2.remove";
    String REMOVE_DOWNLOAD_RESULT = "aria2.removeDownloadResult";
    String SAVE_SESSION = "aria2.saveSession";
    String SHUTDOWN = "aria2.shutdown";
    String TELL_ACTIVE = "aria2.tellActive";
    String TELL_STATUS = "aria2.tellStatus";
    String TELL_STOPPED = "aria2.tellStopped";
    String TELL_WAITING = "aria2.tellWaiting";
    String UNPAUSE = "aria2.unpause";
    String UNPAUSE_ALL = "aria2.unpauseAll";
    String LIST_METHODS = "system.listMethods";
    String LIST_NOTIFICATIONS = "system.listNotifications";
    String MULTICALL = "system.multicall";

    List<String> addMetalink(byte[] metalink, Options options);

    String addTorrent(byte[] torrent, String[] uris, Options options);

    String addUri(String[] uris, Options options);

    String changeGlobalOption(GlobalOptions options);

    String changeOption(String gid, Options options);

    Integer changePosition(String gid, Integer pos, How how);

    List<Integer> changeURI(String gid, Integer fileIndex, String[] delUris, String[] addUris);

    String forcePause(String gid);

    String forcePauseAll();

    String forceRemove(String gid);

    String forceShutdown();

    List<FileInfo> getFiles(String gid);

    Options getGlobalOption();

    GlobalStatInfo getGlobalStat();

    Options getOption(String gid);

    List<PeerInfo> getPeers(String gid);

    List<ServerInfo> getServers(String gid);

    SessionInfo getSessionInfo();

    List<UriInfo> getUris(String gid);

    VersionInfo getVersion();

    List<String> listMethods();

    String pause(String gid);

    String pauseAll();

    String purgeDownloadResult();

    String remove(String gid);

    String removeDownloadResult(String gid);

    String saveSession();

    String shutdown();

    List<StatusInfo> tellActive(String[] key);

    StatusInfo tellStatus(String gid, String[] key);

    List<StatusInfo> tellStopped(int offset, int num, String... key);

    List<StatusInfo> tellWaiting(int offset, int num, String... key);

    String unpause(String gid);

    String unpauseAll();

    List<String> listNotifications();

    List<Object> multicall(List<MulticallMethod> methodList);
}
