package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

public class Offer {

    @Path("Merchant")
    @Element(name = "Name", required = false)
    public String merchantName;
}
