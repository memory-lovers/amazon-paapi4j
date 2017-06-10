package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.exception.NoResponseException;
import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.exception.response.PAAPIErrorUtils;
import jp.memorylovers.amazon.paapi4j.request.Request;
import okhttp3.OkHttpClient;

public class ResponseHelper {

    protected Request request;

    protected Response readResponse() throws Exception {
        String requestUrl = request.getRequestUrl();

        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url(requestUrl)
            .build();

        try (okhttp3.Response response = client.newCall(request)
            .execute()) {
            return deserialize(response.body()
                .string());
        } catch (Exception e) {
            throw e;
        }
    }

    protected Response deserialize(String responseBodsy) throws Exception {
        return new Persister().read(Response.class, responseBodsy, false);
    }

    public Response getResponse(Request request) throws PAAPI4jException {

        try {
            this.request = request;
            Response response = readResponse();
            if (response == null) {
                throw noResponseException(request, null);
            }

            response.setRequest(request);
            response.setRequestUrl(request.getRequestUrl());

            // Check Error
            if (PAAPIErrorUtils.hasFatalError(response)) {
                throw PAAPIErrorUtils.handle(request.getRequestUrl(), response);
            }

            return response;
        } catch (PAAPI4jException e) {
            throw e;
        } catch (Exception e) {
            throw noResponseException(request, e);
        }
    }

    private NoResponseException noResponseException(Request r, Exception e)
            throws PAAPI4jException {
        String url = request.getRequestUrl();
        String msg = e.getLocalizedMessage() + "\nurl is " + url;
        return new NoResponseException(msg, e);
    }
}
