package jp.memorylovers.amazon.paapi4j.request;

import java.util.Map;

import jp.memorylovers.amazon.paapi4j.enums.Condition;
import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;
import jp.memorylovers.amazon.paapi4j.request.sign.AuthInfo;
import lombok.Getter;

/**
 * PAAPI Request parameters for ItemSearch operation<br>
 * Unsupported for 'Actor', 'Artist', 'AudienceRating', 'Brand', 'City', 'Composer', 'Conductor', 'Director', 'MusicLabel', 'Neighborhood', 'Orchestra', 'TextStream'
 *
 * @see <a href="https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/ItemSearch.html">ItemSearch</a>
 */
@Getter
public class RequestItemSearch extends Request {
    private String author = null;
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

    protected RequestItemSearch(AuthInfo authInfo) {
        super(authInfo);
    }

    protected RequestItemSearch(EndPoint endPoint, AuthInfo authInfo) {
        super(endPoint, authInfo);
    }

    public static RequestItemSearch.Builder builder(AuthInfo authInfo) {
        return new Builder(authInfo);
    }

    public static RequestItemSearch.Builder builder(EndPoint endPoint, AuthInfo authInfo) {
        return new Builder(endPoint, authInfo);
    }

    @Override
    protected Map<String, String> setParams(Map<String, String> params) {
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
    public String operation() {
        return "ItemSearch";
    }

    public static class Builder {
        private RequestItemSearch request;

        protected Builder(AuthInfo authInfo) {
            request = new RequestItemSearch(authInfo);
        }

        protected Builder(EndPoint endPoint, AuthInfo authInfo) {
            request = new RequestItemSearch(endPoint, authInfo);
        }

        public RequestItemSearch build() {
            return request;
        }

        public Builder author(String author) {
            this.request.author = author;
            return this;
        }

        public Builder browseNode(Long browseNode) {
            this.request.browseNode = browseNode;
            return this;
        }

        public Builder condition(Condition condition) {
            this.request.condition = condition;
            return this;
        }

        public Builder responseGroup(ResponseGroup responseGroup) {
            this.request.responseGroup = responseGroup;
            return this;
        }

        public Builder itemPage(Integer itemPage) {
            this.request.itemPage = itemPage;
            return this;
        }

        public Builder power(String power) {
            this.request.power = power;
            return this;
        }

        public Builder power(PowerBuilder.IPowerCond power) {
            this.request.power = power.toString();
            return this;
        }

        public Builder publisher(String publisher) {
            this.request.publisher = publisher;
            return this;
        }

        public Builder keywords(String keywords) {
            this.request.keywords = keywords;
            return this;
        }

        public Builder maximumPrice(Integer maximumPrice) {
            this.request.maximumPrice = maximumPrice;
            return this;
        }

        public Builder minimumPrice(Integer minimumPrice) {
            this.request.minimumPrice = minimumPrice;
            return this;
        }

        public Builder searchIndex(String searchIndex) {
            this.request.searchIndex = searchIndex;
            return this;
        }

        public Builder variationPage(Integer variationPage) {
            this.request.variationPage = variationPage;
            return this;
        }


        //for Request
        public Builder merchantId(String merchantId) {
            this.request.merchantId = merchantId;
            return this;
        }

        public Builder validate(boolean validate) {
            this.request.validate = validate;
            return this;
        }
    }
}
