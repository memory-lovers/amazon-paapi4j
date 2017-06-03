package jp.memorylovers.amazon.paapi4j.response;

import java.io.InputStreamReader;
import java.net.URL;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.request.Request;

public class ResponseHelper {

    protected Request request;

    protected Response readResponse() throws Exception {
        String requestUrl = request.getRequestUrl();
        try (InputStreamReader ir = new InputStreamReader(new URL(requestUrl)
            .openConnection()
            .getInputStream())) {
            return new Persister().read(Response.class, ir, false);
        } catch (Exception e) {
            throw e;
        }
    }

    public Response getResponse(Request request) throws PAAPI4jException {

        try {
            this.request = request;
            Response response = readResponse();
            if (response != null) {
                response.setRequest(request);
                response.setRequestUrl(request.getRequestUrl());
                return response;
            }
        } catch (Exception e) {
            String url = request.getRequestUrl();
            String msg = e.getLocalizedMessage() + "\nurl is " + url;
            throw new PAAPI4jException(msg, e);
        }
        return null;
    }
}
