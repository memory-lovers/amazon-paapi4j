package jp.memorylovers.amazon.paapi4j.response;

import org.junit.Test;

public class ResponseErrorTest extends AbstractResponseTest {

    @Test
    public void test_InvalidParameterValue_Multiple() {
        readFile("Error_AWS_InvalidParameterValue_Multiple.xml", true);
    }

    @Override
    protected String rootName() {
        return "src/test/resources/xml_error/";
    }

}
