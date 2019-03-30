package com.example.a20190330.solution;

import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by tinyspace on 2018/3/6.
 */
public class Answer8 {

    public static String getCertExpired(String httpsUrl) {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new Answer8().new NullHostNameVerifier());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL url = new URL(httpsUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(5000);
            conn.connect();
            Certificate[] certificates = conn.getServerCertificates();
            X509Certificate x509Certificate = (X509Certificate) certificates[0];
            StringBuilder builder = new StringBuilder();

            System.out.println("证书版本:" + x509Certificate.getVersion());
            System.out.println("证书编号:" + x509Certificate.getSerialNumber());
            System.out.println("颁发机构:" + x509Certificate.getSubjectDN().getName());
            System.out.println("颁发者:" + x509Certificate.getIssuerDN().getName());
            String[] protocols = sslContext.getSupportedSSLParameters().getProtocols();
            StringBuilder sb = new StringBuilder();
            for (String pro : protocols) {
                sb.append(pro).append(" ");
            }
            System.out.println("支持的协议:" + sb.toString());
            System.out.println("证书开始时间:" + dateFormat(x509Certificate.getNotBefore()));
            System.out.println("有效期止:" + dateFormat(x509Certificate.getNotAfter()));
            System.out.println("是否有效期内:" + (new Date().getTime() > x509Certificate.getNotAfter().getTime() ? "否" : "是"));
            System.out.println("签名算法:" + x509Certificate.getSigAlgName());
            System.out.println("证书公钥:" + x509Certificate.getPublicKey());
            System.out.println("证书签名:" + x509Certificate.getSignature());
            builder.append("证书版本:").append(x509Certificate.getVersion()).append("\n\n")
                    .append("证书编号:").append(x509Certificate.getSerialNumber()).append("\n\n")
                    .append("颁发机构:").append(x509Certificate.getSubjectDN().getName()).append("\n\n")
                    .append("颁发者:").append(x509Certificate.getIssuerDN().getName()).append("\n\n")
                    .append("支持的协议:").append(sb.toString()).append("\n\n")
                    .append("证书开始时间:").append(dateFormat(x509Certificate.getNotBefore())).append("\n\n")
                    .append("有效期止:").append(dateFormat(x509Certificate.getNotAfter())).append("\n\n")
                    .append("是否有效期内:").append(new Date().getTime() > x509Certificate.getNotAfter().getTime() ? "否" : "是").append("\n\n")
                    .append("签名算法:").append(x509Certificate.getSigAlgName()).append("\n\n")
                    .append("证书公钥:").append(x509Certificate.getPublicKey()).append("\n\n")
                    .append("证书签名:").append(x509Certificate.getSignature()).append("\n\n");
            conn.disconnect();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String dateFormat(Date d) {
        return DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
    }

    static TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};

    public class NullHostNameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }

}
