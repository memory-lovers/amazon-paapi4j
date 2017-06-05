package jp.memorylovers.amazon.paapi4j.response;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.utils.PrittyPrintUtils;

public abstract class AbstractResponseTest {
    protected abstract String rootName();

    protected Response readFile(String fileName, boolean isPrint) {
        try (InputStreamReader ir = new InputStreamReader(new FileInputStream(new File(rootName() + fileName)))) {
            Response response = new Persister().read(Response.class, ir, false);
            assertNotNull(response);
            if (isPrint) System.out.println(new PrittyPrintUtils().prittyPrint(response));
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getLocalizedMessage());
        }
        return null;
    }
}
