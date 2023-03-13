package xyz.sagrada.aria2j.client.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.sagrada.aria2j.client.Aria2;
import xyz.sagrada.aria2j.domin.entity.VersionInfo;

class Aria2HttpTest {

    private static Aria2 aria2;

    @BeforeAll
    static void init() {
        aria2 = new Aria2Http("http://localhost:6800/jsonrpc", "32#4grw#e6jh2#13f");
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
        System.out.println(aria2.getGlobalOption());
    }

    @Test
    void getGlobalStat() {
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
        VersionInfo versionInfo = aria2.getVersion();
    }

    @Test
    void listMethods() {
    }

    @Test
    void multicall() {
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
        System.out.println(aria2.tellActive(new String[]{}));
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
    }

    @Test
    void testMulticall() {

    }
}