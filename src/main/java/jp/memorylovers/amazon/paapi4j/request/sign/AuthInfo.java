package jp.memorylovers.amazon.paapi4j.request.sign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * AuthInfo class. this class holds the information necessary for authentication.
 *
 */
@Getter
@Setter
@ToString
public class AuthInfo {
    private String associateTag;
    private String accessKey;
    private String secretKey;
}
