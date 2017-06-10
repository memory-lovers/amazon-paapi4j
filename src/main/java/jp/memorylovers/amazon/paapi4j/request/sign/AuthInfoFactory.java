package jp.memorylovers.amazon.paapi4j.request.sign;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.exception.properties.IllegalPropertiesException;
import jp.memorylovers.amazon.paapi4j.exception.properties.MissingPropertiesException;

/**
 * this is Factory class for AuthInfo.
 *
 */
public class AuthInfoFactory {
    private static final String DEFAULT_RESOURCE_NAME = "paapi4j";
    private static final String KEY_ASSOCIATE_TAG = "associate_tag";
    private static final String KEY_ACCESS_KEY = "access_key";
    private static final String KEY_SECRET_KEY = "secret_key";
    private static final String DUMMY_ASSOCIATE_TAG = "dummy";

    /**
     * create AuthInfo class from ${RESOURCE_NAME}.properties file.
     *
     * @return AuthInfo
     * @throws PAAPI4jException
     */
    public static AuthInfo createByResoruce() throws PAAPI4jException {
        return createByResoruce(DEFAULT_RESOURCE_NAME);
    }

    public static AuthInfo createByResoruce(String resourceName)
            throws PAAPI4jException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle(resourceName);

            // check
            if (!rb.containsKey(KEY_ACCESS_KEY) || !rb.containsKey(
                KEY_SECRET_KEY)) {
                String msg = "There is no " + KEY_ACCESS_KEY + " and/or " + KEY_SECRET_KEY + " property values " + "in " + resourceName + ".properties";
                throw new IllegalPropertiesException(msg);
            }

            String accessKey = rb.getString(KEY_ACCESS_KEY);
            String secretKey = rb.getString(KEY_SECRET_KEY);

            // check
            if (accessKey.isEmpty() || secretKey.isEmpty()) {
                String msg = "There is no " + KEY_ACCESS_KEY + " and/or " + KEY_SECRET_KEY + " property values " + "in " + resourceName + ".properties";
                throw new IllegalPropertiesException(msg);
            }

            AuthInfo info = new AuthInfo();

            if (rb.containsKey(KEY_ASSOCIATE_TAG) && !rb.getString(
                KEY_ASSOCIATE_TAG)
                .isEmpty()) {
                info.setAssociateTag(rb.getString(KEY_ASSOCIATE_TAG));
            } else {
                info.setAssociateTag(DUMMY_ASSOCIATE_TAG);
            }
            info.setAccessKey(accessKey);
            info.setSecretKey(secretKey);
            return info;
        } catch (MissingResourceException e) {
            throw new MissingPropertiesException(e);
        }
    }
}
