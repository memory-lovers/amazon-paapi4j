package jp.memorylovers.amazon.paapi4j.response;

import org.junit.Test;

public class ResponseItemSearchTest extends AbstractResponseTest {

    @Test
    public void testItemSearchMedium() {
        readFile("ItemSearch_2015-10-04_13-17-12.xml", true);
    }

    @Test
    public void testItemSearchMedium2() {
        readFile("ItemSearch_2015-10-04_13-36-35.xml", false);
    }

    @Test
    public void testItemSearchMediumDoubleAuthor() {
        readFile("ItemSearch_2015-10-04_13-46-53.xml", true);
    }

    @Override
    protected String rootName() {
        return "src/test/resources/xml_medium/";
    }
}
