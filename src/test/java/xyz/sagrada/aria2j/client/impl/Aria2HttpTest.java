package xyz.sagrada.aria2j.client.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.sagrada.aria2j.client.Aria2;
import xyz.sagrada.aria2j.domin.entity.MulticallMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Aria2HttpTest {

    private static Aria2 aria2;

    private static final String uri = "http://debian.vm:6800/jsonrpc";
    private static final String token = "32#4grw#e6jh2#13f";

    @BeforeAll
    static void init() {
        aria2 = new Aria2Impl(uri, token, new Aria2ListenerDemo());
    }


    @Test
    void addMetalink() {
    }

    @Test
    void addTorrent() {
    }

    @Test
    void addUri() {
    }

    @Test
    void changeGlobalOption() {
    }

    @Test
    void changeOption() {
    }

    @Test
    void changePosition() {
    }

    @Test
    void changeURI() {
    }

    @Test
    void forcePause() {
    }

    @Test
    void forcePauseAll() {
    }

    @Test
    void forceRemove() {
    }

    @Test
    void forceShutdown() {
    }

    @Test
    void getFiles() {
    }

    @Test
    void getGlobalOption() {
        Optional.ofNullable(aria2.getGlobalOption()).ifPresent(System.out::println);
    }

    @Test
    void getGlobalStat() {
        Optional.ofNullable(aria2.getGlobalStat()).ifPresent(System.out::println);
    }

    @Test
    void getOption() {
    }

    @Test
    void getPeers() {
    }

    @Test
    void getServers() {
    }

    @Test
    void getSessionInfo() {
    }

    @Test
    void getUris() {
    }

    @Test
    void getVersion() {
        Optional.ofNullable(aria2.getVersion()).ifPresent(System.out::println);
    }

    @Test
    void listMethods() {
        Optional.ofNullable(aria2.listMethods()).ifPresent(e -> e.forEach(System.out::println));
    }

    @Test
    void multicall() {
        List<MulticallMethod> methodList = new ArrayList<>();
        methodList.add(new MulticallMethod(Aria2.LIST_METHODS, null));
        methodList.add(new MulticallMethod(Aria2.LIST_NOTIFICATIONS, null));
        methodList.add(new MulticallMethod(Aria2.TELL_ACTIVE, new String[0]));
        Optional.ofNullable(aria2.multicall(methodList)).ifPresent(e -> e.forEach(System.out::println));
    }

    @Test
    void pause() {
    }

    @Test
    void pauseAll() {
    }

    @Test
    void purgeDownloadResult() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeDownloadResult() {
    }

    @Test
    void saveSession() {
    }

    @Test
    void shutdown() {
    }

    @Test
    void tellActive() {
    }

    @Test
    void tellStatus() {
        Optional.ofNullable(aria2.tellActive(new String[0])).ifPresent(System.out::println);
    }

    @Test
    void tellStopped() {
    }

    @Test
    void tellWaiting() {
    }

    @Test
    void unpause() {
    }

    @Test
    void unpauseAll() {
    }

    @Test
    void listNotifications() {
        Optional.ofNullable(aria2.listNotifications()).ifPresent(e -> e.forEach(System.out::println));
    }

    @Test
    void testMulticall() {

    }
}