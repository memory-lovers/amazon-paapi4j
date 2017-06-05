package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;

public class Error {
    @Element(name = "Code")
    public String code;
    @Element(name = "Message")
    public String message;
}
