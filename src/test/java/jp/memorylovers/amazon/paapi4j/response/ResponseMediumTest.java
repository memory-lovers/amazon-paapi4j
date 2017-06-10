package jp.memorylovers.amazon.paapi4j.response;

import org.junit.Test;

public class ResponseMediumTest  extends AbstractResponseTest {

    @Test
    public void test() {
        readFile("ItemLookup_Medium_20170610_115810.xml", true);
    }

    @Test
    public void test2() {
        readFile("ItemLookup_Medium_20170610_003931.xml", true);
    }

    @Override
    protected String rootName() {
        return "src/test/resources/xml_medium/";
    }
}
