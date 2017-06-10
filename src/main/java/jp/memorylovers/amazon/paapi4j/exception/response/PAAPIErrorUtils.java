package jp.memorylovers.amazon.paapi4j.exception.response;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.response.Response;

public class PAAPIErrorUtils {

    public static PAAPI4jException handle(String url, Response res) {
        String code = res.error.code;
        String msg = res.error.message + "\nurl is " + url;

        switch (code) {
        case "AWS.InvalidAccount":
            return new InvalidAccountException(msg);
        case "AWS.ECommerceService.NoExactMatches":
            return new NoExactMatchesException(msg);
        case "AWS.InvalidAssociate":
            return new InvalidAssociateException(msg);
        case "AWS.InvalidParameterValue":
            return new InvalidParameterValueExceptione(msg);
        case "AWS.MissingParameters":
            return new MissingParametersException(msg);
        case "RequestExpired":
            return new RequestExpiredException(msg);
        case "RequestThrottled":
            return new RequestThrottledException(msg);
        default:
            return new PAAPI4jException(msg);
        }
    }

    public static boolean hasFatalError(Response res) {
        if (res == null || res.error == null) {
            return false;
        }

        String code = res.error.code;
        switch (code) {
        case "AWS.InvalidParameterValue":
            return false;
        case "AWS.InvalidAccount":
        case "AWS.ECommerceService.NoExactMatches":
        case "AWS.InvalidAssociate":
        case "AWS.MissingParameters":
        case "RequestExpired":
        case "RequestThrottled":
        default:
            return true;
        }
    }
}
