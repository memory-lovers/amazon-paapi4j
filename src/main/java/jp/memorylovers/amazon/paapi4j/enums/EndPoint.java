package jp.memorylovers.amazon.paapi4j.enums;

public enum EndPoint {
    ENDPOINT_JP;

    @Override
    public String toString() {
        switch (this) {
            case ENDPOINT_JP:
                return "ecs.amazonaws.jp";
            default:
                return null;
        }
    }
}
