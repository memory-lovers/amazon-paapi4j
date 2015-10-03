package jp.memorylovers.amazon.paapi4j;

import org.junit.BeforeClass;

import java.util.ResourceBundle;

import static org.junit.Assert.fail;

public class AbstractTest {
    private static final String KEY_ACCESS_KEY = "access_key";
    private static final String KEY_SECRET_KEY = "secret_key";
    private static final String RESOURCE_FILENAME = "amazon-token";

    protected static String accessKey;
    protected static String secretKey;

    @BeforeClass
    public static void readProperties() {
        ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_FILENAME);
        if (rb.containsKey(KEY_SECRET_KEY) && rb.containsKey(KEY_ACCESS_KEY)) {
            accessKey = rb.getString(KEY_ACCESS_KEY);
            secretKey = rb.getString(KEY_SECRET_KEY);
        } else {
            fail("There is no " + KEY_ACCESS_KEY + " and/or " + KEY_SECRET_KEY + " property values " +
                    "in " + RESOURCE_FILENAME + ".properties");
        }
    }
}
