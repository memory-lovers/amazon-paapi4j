package jp.memorylovers.amazon.paapi4j.enums;

public enum ResponseGroup {
    ACCESSORIES,
    BROWSE_NODES,
    EDITORIAL_REVIEW,
    ITEM_ATTRIBUTES,
    ITEM_IDS,
    LARGE,
    LISTMANIA_LISTS,
    MEDIUM,
    MERCHANT_ITEM_ATTRIBUTES,
    OFFER_FULL,
    OFFERS,
    OFFER_SUMMARY,
    REVIEWS,
    RELATED_ITEMS,
    SEARCH_BINS,
    SIMILARITIES,
    SMALL,
    SUBJECTS,
    TAGS,
    TAGS_SUMMARY,
    TRACKS,
    VARIATION_MINIMUM,
    VARIATIONS,
    VARIATION_SUMMARY;


    @Override
    public String toString() {
        switch (this) {
            case ACCESSORIES:
                return "Accessories";
            case BROWSE_NODES:
                return "BrowseNodes";
            case EDITORIAL_REVIEW:
                return "EditorialReview";
            case ITEM_ATTRIBUTES:
                return "ItemAttributes";
            case ITEM_IDS:
                return "ItemIds";
            case LARGE:
                return "Large";
            case LISTMANIA_LISTS:
                return "ListmaniaLists";
            case MEDIUM:
                return "Medium";
            case MERCHANT_ITEM_ATTRIBUTES:
                return "MerchantItemAttributes";
            case OFFER_FULL:
                return "OfferFull";
            case OFFERS:
                return "Offers";
            case OFFER_SUMMARY:
                return "OfferSummary";
            case REVIEWS:
                return "Reviews";
            case RELATED_ITEMS:
                return "RelatedItems";
            case SEARCH_BINS:
                return "SearchBins";
            case SIMILARITIES:
                return "Similarities";
            case SMALL:
                return "Small";
            case SUBJECTS:
                return "Subjects";
            case TAGS:
                return "Tags";
            case TAGS_SUMMARY:
                return "TagsSummary";
            case TRACKS:
                return "Tracks";
            case VARIATION_MINIMUM:
                return "VariationMinimum";
            case VARIATIONS:
                return "Variations";
            case VARIATION_SUMMARY:
                return "VariationSummary";
            default:
                return SMALL.toString();
        }
    }
}
