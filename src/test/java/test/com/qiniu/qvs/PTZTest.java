package test.com.qiniu.qvs;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.qvs.PTZManager;
import com.qiniu.util.Auth;
import test.com.qiniu.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PTZTest {
    Auth auth = TestConfig.testAuth;
    private PTZManager ptzManager;
    private Response res = null;
    private final String namespaceId = "2xenzw5o81ods";
    private final String gbId = "31011500991320000382";
    private final String chId = "";

    @BeforeEach
    public void setUp() throws Exception {
        this.ptzManager = new PTZManager(auth);
    }

    @Test
    public void testPTZControl() {
        try {
            res = ptzManager.ptzControl(namespaceId, gbId, "up", 5, chId);
            assertNotNull(res);
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }

    @Test
    public void testFocusControl() {
        try {
            res = ptzManager.focusControl(namespaceId, gbId, "focusfar", 5, chId);
            assertNotNull(res);
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }

    @Test
    public void testIrisControl() {
        try {
            res = ptzManager.irisControl(namespaceId, gbId, "irisin", 5, chId);
            assertNotNull(res);
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }

    @Test
    public void testPresetsControl() {
        try {
            res = ptzManager.presetsControl(namespaceId, gbId, "set", "test", 0, chId);
            assertNotNull(res);
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }

    @Test
    public void testListPresets() {
        try {
            res = ptzManager.listPresets(namespaceId, gbId, chId);
            assertNotNull(res);
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }
}
