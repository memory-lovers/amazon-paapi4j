package jp.memorylovers.amazon.paapi4j.request;

import java.util.Arrays;
import java.util.Map;

import jp.memorylovers.amazon.paapi4j.enums.Condition;
import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import jp.memorylovers.amazon.paapi4j.enums.IdType;
import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;
import jp.memorylovers.amazon.paapi4j.request.sign.AuthInfo;
import lombok.Getter;

/**
 * PAAPI Request parameters for ItemLookup operation<br>
 * Unsupported below request params.<br>
 * <ul>
 * <li>RelatedItemsPage
 * <li>RelationshipType
 * <li>ReviewPage
 * <li>ReviewSort
 * <li>SearchIndex
 * <li>TagPage
 * <li>TagsPerPage
 * <li>TagSort
 * <li>VariationPage
 * </ul>
 *
 * @see <a href=
 *      "https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/ItemLookup.html">
 *      ItemSearch</a>
 */
@Getter
public class RequestItemLookup extends Request {

    private Condition condition = Condition.NEW;
    private IdType idType = IdType.ASIN;
    private String[] itemId = {};
    private Integer offerPage = null;
    private String searchIndex = null;
    private ResponseGroup[] responseGroups = new ResponseGroup[] {
        ResponseGroup.MEDIUM
    };

    protected RequestItemLookup(AuthInfo authInfo) {
        super(authInfo);
    }

    protected RequestItemLookup(EndPoint endPoint, AuthInfo authInfo) {
        super(endPoint, authInfo);
    }

    public static RequestItemLookup.Builder builder(AuthInfo authInfo) {
        return new Builder(authInfo);
    }

    public static RequestItemLookup.Builder builder(EndPoint endPoint,
                                                    AuthInfo authInfo) {
        return new Builder(endPoint, authInfo);
    }

    @Override
    protected Map<String, String> setParams(Map<String, String> params) {
        params.put("Condition", condition.toString());
        params.put("IdType", idType.toString());
        params.put("ItemId", String.join(",", itemId));
        if (offerPage != null) params.put("OfferPage", offerPage.toString());
        if (searchIndex != null) params.put("SearchIndex", searchIndex);
        String[] rgs = Arrays.stream(responseGroups)
            .map(Object::toString)
            .toArray(String[]::new);
        params.put("ResponseGroup", String.join(",", rgs));
        return params;
    }

    @Override
    public String operation() {
        return "ItemLookup";
    }

    public static class Builder {
        private RequestItemLookup request;

        protected Builder(AuthInfo authInfo) {
            request = new RequestItemLookup(authInfo);
        }

        protected Builder(EndPoint endPoint, AuthInfo authInfo) {
            request = new RequestItemLookup(endPoint, authInfo);
        }

        public RequestItemLookup build() {
            return request;
        }

        public Builder condition(Condition condition) {
            this.request.condition = condition;
            return this;
        }

        public Builder idType(IdType idType) {
            this.request.idType = idType;
            return this;
        }

        public Builder itemId(String... itemId) {
            this.request.itemId = itemId;
            return this;
        }

        public Builder offerPage(Integer offerPage) {
            this.request.offerPage = offerPage;
            return this;
        }

        public Builder searchIndex(String searchIndex) {
            this.request.searchIndex = searchIndex;
            return this;
        }

        public Builder responseGroup(ResponseGroup... responseGroups) {
            this.request.responseGroups = responseGroups;
            return this;
        }

        // for Request
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
