package jp.memorylovers.amazon.paapi4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.response.Response;
import jp.memorylovers.amazon.paapi4j.response.ResponseHelper;
import jp.memorylovers.amazon.paapi4j.utils.Utils;

public class DebugResponseHelper extends ResponseHelper {
    private static final String OUTPUT_DIR = "out";

    protected DebugResponseHelper() {
    }

    @Override
    public Response getResponse(String operationName, String requestUrl)
            throws PAAPI4jException {
        try (InputStream is = new URL(requestUrl).openConnection().getInputStream()) {
            File outFile = dumpFile(operationName, is);
            return new Persister().read(Response.class, outFile, false);
        } catch (Exception e) {
            throw new PAAPI4jException(e
                .getLocalizedMessage() + "\nurl is " + requestUrl, e);
        }
    }

    private File dumpFile(String operationName, InputStream is)
            throws IOException {
        File outDir = new File(OUTPUT_DIR);

        if (!outDir.exists()) {
            outDir.mkdir();
        }

        String fileName = operationName + "_" + Utils.format(Calendar.getInstance());
        File outFile = new File(outDir, fileName + ".xml");

        System.out.println("output: " + outFile.getAbsolutePath());
        Files.copy(is, outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return outFile;
    }
}
