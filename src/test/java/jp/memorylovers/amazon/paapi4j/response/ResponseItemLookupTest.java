package jp.memorylovers.amazon.paapi4j.response;

import org.junit.Test;

public class ResponseItemLookupTest extends AbstractResponseTest {

    @Test
    public void test() {
        readFile("ItemLookup_BrowseNodes_20170604_003200.xml", true);
    }

    @Override
    protected String rootName() {
        return "src/test/resources/xml_ItemLookup_BrowseNodes/";
    }

}
