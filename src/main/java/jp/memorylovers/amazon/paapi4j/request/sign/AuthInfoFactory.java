package jp.memorylovers.amazon.paapi4j.request.sign;

import java.util.ResourceBundle;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;

/**
 * this is Factory class for AuthInfo.
 *
 */
public class AuthInfoFactory {
    private static final String RESOURCE_NAME = "paapi4j";
    private static final String KEY_ASSOCIATE_TAG = "associate_tag";
    private static final String KEY_ACCESS_KEY = "access_key";
    private static final String KEY_SECRET_KEY = "secret_key";

    /**
     * create AuthInfo class from ${RESOURCE_NAME}.properties file.
     *
     * @return AuthInfo
     * @throws PAAPI4jException
     */
    public static AuthInfo createByResoruce() throws PAAPI4jException {
        ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_NAME);

        // check
        if (!(rb.containsKey(KEY_ASSOCIATE_TAG) && rb.containsKey(KEY_ACCESS_KEY) && rb.containsKey(KEY_ACCESS_KEY))) {
            String msg = "There is no " + KEY_ASSOCIATE_TAG + " and/or " + KEY_ACCESS_KEY + " and/or " + KEY_SECRET_KEY + " property values " + "in " + RESOURCE_NAME + ".properties";
            throw new PAAPI4jException(msg);
        }

        AuthInfo info = new AuthInfo();
        info.setAssociateTag(rb.getString(KEY_ASSOCIATE_TAG));
        info.setAccessKey(rb.getString(KEY_ACCESS_KEY));
        info.setSecretKey(rb.getString(KEY_SECRET_KEY));
        return info;
    }
}
