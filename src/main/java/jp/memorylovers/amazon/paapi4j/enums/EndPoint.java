package jp.memorylovers.amazon.paapi4j.enums;

/**
 * Enum of Endpoint
 * @see <a href="https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/index.html?rw_useCurrentProtocol=1">REST リクエストの構造</a>
 */
public enum EndPoint {
    ENDPOINT_CA("ecs.amazonaws.ca"),
    ENDPOINT_DE("ecs.amazonaws.de"),
    ENDPOINT_FR("ecs.amazonaws.fr"),
    ENDPOINT_JP("ecs.amazonaws.jp"),
    ENDPOINT_UK("ecs.amazonaws.co.uk"),
    ENDPOINT_US("ecs.amazonaws.com");

    private String url;

    EndPoint(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }
}
