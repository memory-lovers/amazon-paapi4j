package jp.memorylovers.amazon.paapi4j.enums;

/**
 * Enum for ResponseGroup
 *
 * @see <a href="https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/index.html?rw_useCurrentProtocol=1">レスポンスグループ</a>
 */
public enum ResponseGroup {
    //    ACCESSORIES("Accessories"),
    BROWSE_NODES("BrowseNodes"),
//    EDITORIAL_REVIEW("EditorialReview"),
//    ITEM_ATTRIBUTES("ItemAttributes"),
//    ITEM_IDS("ItemIds"),
//    /**
//     * Large レスポンスグループは、商品に関する詳細な情報をレスポンスで返します。Large は、以下のレスポンスグループの結果を返す親レスポンスグループです。<br/>
//     * Accessories, BrowseNodes, ListmaniaLists, Medium, Offers, Reviews, Similarities, Tracks
//     */
//    LARGE("Large"),
    //    LISTMANIA_LISTS("ListmaniaLists"),
    /**
     * Medium レスポンスグループは、商品に関する詳細な情報を返します。このレスポンスグループは、商品の少量の詳細ページを作成するのに最適です。<br>
     * Medium は、以下のレスポンスグループの結果を返す親レスポンスグループです。<br>
     * EditorialReview, Images, ItemAttributes, OfferSummary, Request, SalesRank, Small
     */
    MEDIUM("Medium"),
    //    MERCHANT_ITEM_ATTRIBUTES("MerchantItemAttributes"),
//    OFFER_FULL("OfferFull"),
//    OFFERS("OfferSummary"),
//    OFFER_SUMMARY("Reviews"),
//    REVIEWS("Reviews"),
//    RELATED_ITEMS("RelatedItems"),
//    SEARCH_BINS("SearchBins"),
//    SIMILARITIES("Similarities"),
    /**
     * Small レスポンスグループは、商品に関する基本的な情報を返します。商品の ASIN、DetailPageURL、タイトル、商品グループ、著者などの情報です。
     */
    SMALL("Small")
//    SUBJECTS("Subjects"),
//    TAGS("Tags"),
//    TAGS_SUMMARY("TagsSummary"),
//    TRACKS("Tracks"),
//    VARIATION_MINIMUM("VariationMinimum"),
//    VARIATIONS("Variations"),
//    VARIATION_SUMMARY("VariationSummary")
    ;

    private String name;

    ResponseGroup(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
