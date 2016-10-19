package net.apispark;

import net.apispark.cell30.version1.TestApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class TestHost {

    public static void main(String[] args) throws Exception {
        new TestHost().start();
    }

    Component c = new Component();

    public void start() {
        c.getServers().add(Protocol.HTTP, 8183);
        c.getDefaultHost().attach("/api", new TestApplication());
        try {
            c.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            c.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
