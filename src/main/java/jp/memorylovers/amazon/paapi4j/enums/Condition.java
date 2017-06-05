package jp.memorylovers.amazon.paapi4j.enums;

public enum Condition {
    NEW,
    USED,
    COLLECTIBLE,
    REFURBISHED,
    ALL;

    @Override
    public String toString() {
        switch (this) {
            case USED:
                return "Used";
            case COLLECTIBLE:
                return "Collectible";
            case REFURBISHED:
                return "Refurbished";
            case ALL:
                return "All";
            case NEW:
            default:
                return "New";
        }
    }
}
