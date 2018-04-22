/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: yeyuhao[ye_yh@suixingpay.com] 
 * @date: 2018年4月22日 下午5:41:35   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.yyh.btc.web;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
 * TODO
 * @author: yeyuhao[ye_yh@suixingpay.com]
 * @date: 2018年4月22日 下午5:41:35
 * @version: V1.0
 * @review: yeyuhao[ye_yh@suixingpay.com]/2018年4月22日 下午5:41:35
 */
@Controller
public class WebIndex {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
    
    @RequestMapping("/fxhnotice")
    @ResponseBody
    public String fxhNotice() throws KeyStoreException {
        CloseableHttpClient httpClient = null;

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, null, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            if (httpClient != null) {
                HttpGet httpGet = new HttpGet("https://www.feixiaohao.com/notice/");
                CloseableHttpResponse response = httpClient.execute(httpGet);

                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        return EntityUtils.toString(entity);
                    }
                } finally {
                    response.close();
                }
            }

        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
