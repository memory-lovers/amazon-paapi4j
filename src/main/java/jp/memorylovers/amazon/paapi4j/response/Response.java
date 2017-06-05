package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import jp.memorylovers.amazon.paapi4j.request.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * Model of PAAPI Response
 *
 * @see <a href=
 *      "https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/UnderstandingResponses.html">
 *      レスポンス</a>
 */
@Root
public class Response {
    @Getter
    @Setter
    public Request request;
    @Getter
    @Setter
    public String requestUrl;

    @Element(name = "Items", required = false)
    public Items items;

    @Element(name = "Error", required = false)
    public Error error;

}
