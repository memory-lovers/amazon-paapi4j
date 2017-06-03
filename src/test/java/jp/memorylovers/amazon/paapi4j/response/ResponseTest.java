package jp.memorylovers.amazon.paapi4j.response;

import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ResponseTest {
    private static final String ROOT_DIR = "src/test/resources/xml_medium/";

    @Test
    public void testItemSearchMedium() {
        assertFile("ItemSearch_2015-10-04_13-17-12.xml", true);
    }

    @Test
    public void testItemSearchMedium2() {
        assertFile("ItemSearch_2015-10-04_13-36-35.xml", false);
    }

    @Test
    public void testItemSearchMediumDoubleAuthor() {
        assertFile("ItemSearch_2015-10-04_13-46-53.xml", true);
    }

    private void assertFile(String fileName, boolean isPrint) {
        try (InputStreamReader ir = new InputStreamReader(new FileInputStream(new File(ROOT_DIR + fileName)))) {
            Response response = new Persister().read(Response.class, ir, false);
            assertNotNull(response);
            if (isPrint) System.out.println(response);
        } catch (Exception e) {
            e.getCause()
                .printStackTrace();
            fail(e.getLocalizedMessage());
        }
    }
}
