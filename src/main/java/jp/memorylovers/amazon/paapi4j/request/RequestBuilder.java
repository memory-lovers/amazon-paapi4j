package jp.memorylovers.amazon.paapi4j.request;

import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import lombok.Setter;

import static jp.memorylovers.amazon.paapi4j.enums.ResponseGroup.MEDIUM;

@Setter
public class RequestBuilder {
    public static RequestItemSearch builderItemSearch(EndPoint endPoint, String secretKey, String awsAccessKeyId) {
        RequestItemSearch param = new RequestItemSearch(endPoint, secretKey, awsAccessKeyId);
        param.setBrowseNode(2278488051L);
        param.setResponseGroup(MEDIUM);
        return param;
    }
}