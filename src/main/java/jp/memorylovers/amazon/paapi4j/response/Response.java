package jp.memorylovers.amazon.paapi4j.response;

import jp.memorylovers.amazon.paapi4j.request.Request;
import lombok.Getter;
import lombok.Setter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Response {
    @Getter
    @Setter
    public Request request;

    @Element(name = "Items")
    public Items items;

    @Override
    public String toString() {
        return "Response{\n" +
                items + "\n" +
                '}';
    }
}
