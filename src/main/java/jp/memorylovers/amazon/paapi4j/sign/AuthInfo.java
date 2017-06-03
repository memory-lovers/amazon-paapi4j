package jp.memorylovers.amazon.paapi4j.sign;

import lombok.Getter;
import lombok.Setter;

/**
 * AuthInfo class. this class holds the information necessary for authentication.
 *
 */
@Getter
@Setter
public class AuthInfo {
    private String associateTag;
    private String accessKey;
    private String secretKey;
}
