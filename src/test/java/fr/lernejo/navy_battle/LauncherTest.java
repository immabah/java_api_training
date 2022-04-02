package fr.lernejo.navy_battle;

import org.testng.annotations.Test;

import java.io.IOException;

class LauncherTest {
    @Test

    void Launcher1() {
        Launcher launch2 = new Launcher();
        String[] argmt = new String[1];
        argmt[0] = "9876";

        try {
            Launcher.main(argmt);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void Launcher2() throws IOException, InterruptedException {
        Launcher launch = new Launcher();
        launch.main(new String[]{"8080"});
    }

    void Launcher3() throws IOException, InterruptedException {
        String[] args = new String[2];
        args[0] = "8080";
        args[1] = "http://localhost:9876";
    }

}
