package jp.memorylovers.amazon.paapi4j.response;


import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

public class ResponseTest {
    private static final String ROOT_DIR = "src/test/resources/xml_medium/";

    @Test
    public void testItemSearchMedium() {
        assertFile("ItemSearch_2015-10-04_13-17-12.xml");
    }

    private void assertFile(String fileName) {
        try (InputStreamReader ir = new InputStreamReader(new FileInputStream(new File(ROOT_DIR + fileName)))
        ) {
            Response response = new Persister().read(Response.class, ir, false);
            assertNotNull(response);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
