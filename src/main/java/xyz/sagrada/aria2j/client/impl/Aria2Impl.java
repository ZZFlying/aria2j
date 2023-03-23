package xyz.sagrada.aria2j.client.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import xyz.sagrada.aria2j.client.Aria2;
import xyz.sagrada.aria2j.domin.RpcRequest;
import xyz.sagrada.aria2j.domin.RpcResponse;
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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * if rpc protocol is ws or wss, method return null
 */
@Slf4j
public class Aria2Impl implements Aria2 {

    private final String uri;
    private final String token;
    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private boolean isWs = false;
    private WebSocket webSocket = null;

    public Aria2Impl(String jsonrpc, String token) {
        this(jsonrpc, token, null);
    }

    public Aria2Impl(String jsonrpc, String token, WebSocket.Listener listener) {
        this.uri = jsonrpc;
        this.token = Optional.ofNullable(token).map(e -> "token:" + e).orElse(null);
        client = HttpClient.newHttpClient();
        if (jsonrpc.startsWith("ws")) {
            if (listener == null) {
                throw new RuntimeException("listener not allow null if rpc protocol is ws or wss");
            }
            isWs = true;
            webSocket = client.newWebSocketBuilder().buildAsync(URI.create(uri), listener).join();
        }
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> RpcResponse<T> post(RpcRequest requestEntity, TypeReference<RpcResponse<T>> typeReference) {
        try {
            var body = objectMapper.writeValueAsString(requestEntity);
            if (isWs) {
                webSocket.sendText(body, true);
                return new RpcResponse<>();
            }
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                    .build();
            var resultEntity = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            log.debug("Body:{}", resultEntity.body());
            return objectMapper.readValue(resultEntity.body(), typeReference);
        }
        catch (JsonProcessingException e) {
            log.error("Serializable failed:{}", e.getMessage());
        }
        catch (IOException | InterruptedException e) {
            log.error("Request {} failed:{}", requestEntity.getMethod(), e.getMessage());
        }
        return new RpcResponse<>();
    }

    @Override
    public List<String> addMetalink(byte[] metalink, Options options) {
        String base64Str = Base64.getEncoder().encodeToString(metalink);
        RpcRequest request = new RpcRequest(ADD_METALINK, token, base64Str, options);
        return post(request, new TypeReference<RpcResponse<List<String>>>() {
        }).getResult();
    }

    @Override
    public String addTorrent(byte[] torrent, String[] uris, Options options) {
        String base64str = Base64.getEncoder().encodeToString(torrent);
        if (uris == null && options != null) {
            uris = new String[0];
        }
        RpcRequest request = new RpcRequest(ADD_TORRENT, token, base64str, uris, options);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String addUri(String[] uris, Options options) {
        if (uris == null || uris.length == 0) {
            return null;
        }
        if (Arrays.stream(uris).anyMatch(e -> e.startsWith("magnet:?xt=urn:btih:")) && uris.length > 1) {
            throw new RuntimeException("When adding BitTorrent Magnet URIs, " +
                    "uris must have only one element and it should be BitTorrent Magnet URI");
        }
        RpcRequest request = new RpcRequest(ADD_URI, token, uris, options);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String changeGlobalOption(GlobalOptions options) {
        RpcRequest request = new RpcRequest(CHANGE_GLOBAL_OPTION, token, options);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String changeOption(String gid, Options options) {
        RpcRequest request = new RpcRequest(CHANGE_OPTION, token, gid, options);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public Integer changePosition(String gid, Integer pos, How how) {
        RpcRequest request = new RpcRequest(CHANGE_POSITION, token, gid, pos, how);
        return post(request, new TypeReference<RpcResponse<Integer>>() {
        }).getResult();
    }

    @Override
    public List<Integer> changeURI(String gid, Integer fileIndex, String[] delUris, String[] addUris) {
        RpcRequest request = new RpcRequest(CHANGE_URI, token, gid, fileIndex, delUris, addUris);
        return post(request, new TypeReference<RpcResponse<List<Integer>>>() {
        }).getResult();
    }

    @Override
    public String forcePause(String gid) {
        RpcRequest request = new RpcRequest(FORCE_PAUSE, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String forcePauseAll() {
        RpcRequest request = new RpcRequest(FORCE_PAUSE_ALL, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String forceRemove(String gid) {
        RpcRequest request = new RpcRequest(FORCE_REMOVE, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String forceShutdown() {
        RpcRequest request = new RpcRequest(FORCE_SHUTDOWN, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public List<FileInfo> getFiles(String gid) {
        RpcRequest request = new RpcRequest(GET_FILES, token, gid);
        return post(request, new TypeReference<RpcResponse<List<FileInfo>>>() {
        }).getResult();
    }

    @Override
    public Options getGlobalOption() {
        RpcRequest request = new RpcRequest(GET_GLOBAL_OPTION, token);
        return post(request, new TypeReference<RpcResponse<Options>>() {
        }).getResult();
    }

    @Override
    public GlobalStatInfo getGlobalStat() {
        RpcRequest request = new RpcRequest(GET_GLOBAL_STAT, token);
        return post(request, new TypeReference<RpcResponse<GlobalStatInfo>>() {
        }).getResult();
    }

    @Override
    public Options getOption(String gid) {
        RpcRequest request = new RpcRequest(GET_OPTION, token, gid);
        return post(request, new TypeReference<RpcResponse<Options>>() {
        }).getResult();
    }

    @Override
    public List<PeerInfo> getPeers(String gid) {
        RpcRequest request = new RpcRequest(GET_PEERS, token, gid);
        return post(request, new TypeReference<RpcResponse<List<PeerInfo>>>() {
        }).getResult();
    }

    @Override
    public List<ServerInfo> getServers(String gid) {
        RpcRequest request = new RpcRequest(GET_SERVERS, token, gid);
        return post(request, new TypeReference<RpcResponse<List<ServerInfo>>>() {
        }).getResult();
    }

    @Override
    public SessionInfo getSessionInfo() {
        RpcRequest request = new RpcRequest(GET_SESSION_INFO, token);
        return post(request, new TypeReference<RpcResponse<SessionInfo>>() {
        }).getResult();
    }

    @Override
    public List<UriInfo> getUris(String gid) {
        RpcRequest request = new RpcRequest(GET_URIS, token, gid);
        return post(request, new TypeReference<RpcResponse<List<UriInfo>>>() {
        }).getResult();
    }

    @Override
    public VersionInfo getVersion() {
        RpcRequest request = new RpcRequest(GET_VERSION, token);
        return post(request, new TypeReference<RpcResponse<VersionInfo>>() {
        }).getResult();
    }

    @Override
    public List<String> listMethods() {
        RpcRequest request = new RpcRequest(LIST_METHODS, token);
        return post(request, new TypeReference<RpcResponse<List<String>>>() {
        }).getResult();
    }

    @Override
    public String pause(String gid) {
        RpcRequest request = new RpcRequest(PAUSE, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String pauseAll() {
        RpcRequest request = new RpcRequest(PAUSE_ALL, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String purgeDownloadResult() {
        RpcRequest request = new RpcRequest(PURGE_DOWNLOAD_RESULT, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String remove(String gid) {
        RpcRequest request = new RpcRequest(REMOVE, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String removeDownloadResult(String gid) {
        RpcRequest request = new RpcRequest(REMOVE_DOWNLOAD_RESULT, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String saveSession() {
        RpcRequest request = new RpcRequest(SAVE_SESSION, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String shutdown() {
        RpcRequest request = new RpcRequest(SHUTDOWN, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public List<StatusInfo> tellActive(String[] key) {
        RpcRequest request = new RpcRequest(TELL_ACTIVE, token, key);
        return post(request, new TypeReference<RpcResponse<List<StatusInfo>>>() {
        }).getResult();
    }

    @Override
    public StatusInfo tellStatus(String gid, String[] key) {
        RpcRequest request = new RpcRequest(TELL_STATUS, token, gid, key);
        return post(request, new TypeReference<RpcResponse<StatusInfo>>() {
        }).getResult();
    }

    @Override
    public List<StatusInfo> tellStopped(int offset, int num, String... key) {
        RpcRequest request = new RpcRequest(TELL_STOPPED, token, offset, num, key);
        return post(request, new TypeReference<RpcResponse<List<StatusInfo>>>() {
        }).getResult();
    }

    @Override
    public List<StatusInfo> tellWaiting(int offset, int num, String... key) {
        RpcRequest request = new RpcRequest(TELL_WAITING, token, offset, num, key);
        return post(request, new TypeReference<RpcResponse<List<StatusInfo>>>() {
        }).getResult();
    }

    @Override
    public String unpause(String gid) {
        RpcRequest request = new RpcRequest(UNPAUSE, token, gid);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public String unpauseAll() {
        RpcRequest request = new RpcRequest(UNPAUSE_ALL, token);
        return post(request, new TypeReference<RpcResponse<String>>() {
        }).getResult();
    }

    @Override
    public List<String> listNotifications() {
        RpcRequest request = new RpcRequest(LIST_NOTIFICATIONS);
        return post(request, new TypeReference<RpcResponse<List<String>>>() {
        }).getResult();
    }

    @Override
    public List<Object> multicall(List<MulticallMethod> methodList) {
        if (token != null) {
            methodList.forEach(method -> {
                if (method.getTempParams() == null) {
                    method.setParams(new Object[] {token});
                }
                else {
                    Object[] tempParams = method.getTempParams();
                    Object[] o = new Object[tempParams.length + 1];
                    o[0] = token;
                    System.arraycopy(tempParams, 0, o, 1, tempParams.length);
                    method.setParams(o);
                }
            });
        }
        else {
            methodList.forEach(method -> method.setParams(method.getTempParams()));
        }
        RpcRequest request = new RpcRequest(MULTICALL, null, methodList);
        return post(request, new TypeReference<RpcResponse<List<Object>>>() {
        }).getResult();
    }
}
