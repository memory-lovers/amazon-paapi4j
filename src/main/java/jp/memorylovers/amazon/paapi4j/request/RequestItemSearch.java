package jp.memorylovers.amazon.paapi4j.request;

import jp.memorylovers.amazon.paapi4j.enums.Condition;
import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;
import lombok.Setter;

import java.util.Map;

@Setter
public class RequestItemSearch extends Request {
    private String author = null;
    //    private String availability; //有効な値: Available
    private Long browseNode = null;
    private Condition condition = Condition.NEW;
    private ResponseGroup responseGroup = ResponseGroup.SMALL;
    private Integer itemPage = null;
    private String power = null;
    private String publisher = null;

    private String keywords;
    private Integer maximumPrice = null;
    private Integer minimumPrice = null;

    private String searchIndex = "Books";
    private Integer variationPage = null;

    protected RequestItemSearch(String secretKey, String awsAccessKeyId) {
        super(secretKey, awsAccessKeyId);
    }

    protected RequestItemSearch(EndPoint endPoint, String secretKey, String awsAccessKeyId) {
        super(endPoint, secretKey, awsAccessKeyId);
    }

    @Override
    protected Map<String, String> buildParams(Map<String, String> params) {
        if (author != null) params.put("Author", author);
        if (browseNode != null) params.put("BrowseNode", browseNode.toString());
        params.put("Condition", condition.toString());
        params.put("ResponseGroup", responseGroup.toString());
        if (itemPage != null) params.put("ItemPage", itemPage.toString());
        if (power != null) params.put("Power", power);
        if (publisher != null) params.put("Publisher", publisher);

        if (keywords != null) params.put("Keywords", enc(keywords));
        if (maximumPrice != null) params.put("MaximumPrice", maximumPrice.toString());
        if (minimumPrice != null) params.put("MinimumPrice", minimumPrice.toString());

        if (searchIndex != null) params.put("SearchIndex", searchIndex);
        if (variationPage != null) params.put("VariationPage", variationPage.toString());

        return params;
    }

    @Override
    protected String operation() {
        return "ItemSearch";
    }
}
