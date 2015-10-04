package jp.memorylovers.amazon.paapi4j.response;

import lombok.ToString;
import org.simpleframework.xml.Element;

@ToString
public class Error {
    @Element(name = "Code")
    public String code;
    @Element(name = "Message")
    public String message;
}
