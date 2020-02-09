package demo.code.problems;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.URL;

public class SSLCheck {

    /**
     * -Djavax.net.ssl.keyStoreType=pkcs12
     * -Djavax.net.ssl.trustStoreType=jks
     * -Djavax.net.ssl.keyStore=clientcertificate.p12
     * -Djavax.net.ssl.trustStore=gridserver.keystore
     * -Djavax.net.debug=ssl # very verbose debug
     * -Djavax.net.ssl.keyStorePassword=$PASS
     * -Djavax.net.ssl.trustStorePassword=$PASS
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
        System.setProperty("javax.net.ssl.keyStore", "/Users/jitendrabisht/Study/security/open-ssl-certificates/ssl/client/client_pavel.p12");

        System.setProperty("javax.net.ssl.trustStoreType", "jks");
        System.setProperty("javax.net.ssl.trustStore", "/Users/jitendrabisht/.sdkman/candidates/java/11.0.2-open/lib/security/mykeystore");
//        System.setProperty("javax.net.ssl.keyStore", "/Users/jitendrabisht/.sdkman/candidates/java/11.0.2-open/lib/security/mykeystore");
//        System.setProperty("javax.net.ssl.trustStore", "keyStore.p12");
        System.setProperty("javax.net.debug", "all");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        URL url = new URL("https://localhost:8443/hello");
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setSSLSocketFactory(sslsocketfactory);
        conn.getInputStream();
    }
}
