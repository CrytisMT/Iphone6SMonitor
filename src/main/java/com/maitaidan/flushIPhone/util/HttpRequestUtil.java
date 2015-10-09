package com.maitaidan.flushIPhone.util;

import com.google.common.io.CharStreams;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil {
    private static final int DEFAULT_TIMEOUT = 10000;
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * 根据params参数 不需要传request发送Get请求
     *
     * @param url 带http://url地址
     * @param params 参数map
     * @param encoding 编码
     */
    public static String doGet(String url, Map<String, String> params, String encoding) {
        return doGet(url, params, null, encoding, -1, -1);
    }

    public static String doGet(String url, Map<String, String> params, String encoding, int timeout, int conTimeout) {
        return doGet(url, params, null, encoding, timeout, conTimeout);
    }

    /**
     * 根据cookie和参数 需要request 发送Get请求
     *
     * @param url 带http://url地址
     * @param params 参数
     * @param request 请求用户传递cookie
     * @param encoding 编码
     */
    public static String doGet(String url, Map<String, String> params, HttpServletRequest request, String encoding,
            int timeout, int conTimeout) {

        long start = System.currentTimeMillis();
        if (url == null || "".equals(url.trim())) {
            logger.info("url为空");
            return "";
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        if (conTimeout > 0) {
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, conTimeout); // 连接超时
        } else {
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000); // 连接超时
        }
        if (timeout > 0) {
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout); // 响应超时
        } else {
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000); // 响应超时
        }
        // 加入请求参数
        if (params != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(url);
            if (url.indexOf("?") != -1) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            for (String key : params.keySet()) {
                if (params.get(key) == null || "".equals(params.get(key).trim())) {
                    continue;
                }
                String value = params.get(key).trim().replaceAll(" ", "%20").replaceAll("\t", "");
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.toString();
        }
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
            if (request != null && request.getCookies() != null) {
                Cookie[] cookies = request.getCookies();
                StringBuilder stringBuilder = new StringBuilder();
                for (Cookie cookie : cookies) {
                    stringBuilder.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
                httpGet.setHeader("Cookie", stringBuilder.toString());
            }
        } catch (Exception e) {
            logger.info("new HttpGet异常");
            logger.info("url:{}", url);
            logger.error(e.getMessage(), e);
            return "";
        }
        String result = "";
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            result = CharStreams.toString(new InputStreamReader(httpResponse.getEntity().getContent(), encoding));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        long time = System.currentTimeMillis() - start;
        logger.info("模拟request get请求url:{}  请求花费时间:{} ms", url, time);
        return result;
    }

    /**
     * 根据参数 不带request 发送Post请求
     *
     * @param url 带http://url地址
     * @param params 参数map
     * @param encoding 编码
     */
    public static String doPost(String url, Map<String, String> params, String encoding) {
        return doPost(url, params, null, encoding, DEFAULT_TIMEOUT);
    }

    /**
     * 根据参数 不带request 发送Post请求
     *
     * @param url 带http://url地址
     * @param params 参数map
     * @param encoding 编码
     */
    public static String doPost(String url, Map<String, String> params, String encoding, int timeout) {
        return doPost(url, params, null, encoding, timeout);
    }

    /**
     * 根据cookie和参数 需要request 发送Post请求
     * 
     * @param url 带http://url地址
     * @param params 参数
     * @param request 请求用户传递cookie
     * @param encoding 编码
     */
    public static String doPost(String url, Map<String, String> params, HttpServletRequest request, String encoding,
            int timeout) {

        long start = System.currentTimeMillis();
        if (url == null || "".equals(url.trim())) {
            logger.info("url为空");
            return "";
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout); // 连接超时
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout); // 响应超时
        HttpPost httpPost = new HttpPost(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = "";
        // 加入请求参数
        try {
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String key = entry.getKey();
                    if (params.get(key) == null || "".equals(params.get(key).trim())) {
                        continue;
                    }
                    // String value = params.get(key).trim().replaceAll(" ", "%20").replaceAll("\t", "");
                    String value = params.get(key);
                    paramList.add(new BasicNameValuePair(entry.getKey(), value));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, encoding);
                httpPost.setEntity(entity);
            }
            if (request != null && request.getCookies() != null) {
                Cookie[] cookies = request.getCookies();
                StringBuilder stringBuilder = new StringBuilder();
                for (Cookie cookie : cookies) {
                    stringBuilder.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
                httpPost.setHeader("Cookie", stringBuilder.toString());
            }
            result = httpClient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        long time = System.currentTimeMillis() - start;
        logger.info("模拟request post请求url:{}  请求花费时间:{} ms", url, time);
        return result;
    }

    /**
     * 根据参数 不带request 发送Put请求
     *
     * @param url 带http://url地址
     * @param params 参数map
     * @param encoding 编码
     */
    public static String doPut(String url, Map<String, String> params, String encoding) {
        return doPut(url, params, null, encoding, DEFAULT_TIMEOUT);
    }

    public static String doPut(String url, Map<String, String> params, HttpServletRequest request, String encoding,
            int timeout) {
        long start = System.currentTimeMillis();
        if (url == null || "".equals(url.trim())) {
            logger.info("url为空");
            return "";
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout); // 连接超时
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout); // 响应超时
        HttpPut httpPut = new HttpPut(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = "";
        // 加入请求参数
        try {
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String key = entry.getKey();
                    if (params.get(key) == null || "".equals(params.get(key).trim())) {
                        continue;
                    }
                    // String value = params.get(key).trim().replaceAll(" ", "%20").replaceAll("\t", "");
                    String value = params.get(key);
                    paramList.add(new BasicNameValuePair(entry.getKey(), value));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, encoding);
                httpPut.setEntity(entity);
            }
            if (request != null && request.getCookies() != null) {
                Cookie[] cookies = request.getCookies();
                StringBuilder stringBuilder = new StringBuilder();
                for (Cookie cookie : cookies) {
                    stringBuilder.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
                httpPut.setHeader("Cookie", stringBuilder.toString());
            }
            result = httpClient.execute(httpPut, responseHandler);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        long time = System.currentTimeMillis() - start;
        logger.info("模拟request put请求url:{}  请求花费时间:{} ms", url, time);
        return result;
    }

    public static String doPutt(String url, Map<String, String> params, String encoding) {
        return doPutt(url, params, null, encoding, DEFAULT_TIMEOUT);
    }

    public static String doPutt(String url, Map<String, String> params, HttpServletRequest request, String encoding,
            int timeout) {
        long start = System.currentTimeMillis();
        if (url == null || "".equals(url.trim())) {
            logger.info("url为空");
            return "";
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout); // 连接超时
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout); // 响应超时
        HttpPut httpPut = new HttpPut(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = "";
        // 加入请求参数
        try {
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String key = entry.getKey();
                    if (params.get(key) == null || "".equals(params.get(key).trim())) {
                        continue;
                    }
                    String value = params.get(key).trim().replaceAll(" ", "%20").replaceAll("\t", "");
                    // String value = params.get(key);
                    paramList.add(new BasicNameValuePair(entry.getKey(), value));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, encoding);
                httpPut.setEntity(entity);
            }
            if (request != null && request.getCookies() != null) {
                Cookie[] cookies = request.getCookies();
                StringBuilder stringBuilder = new StringBuilder();
                for (Cookie cookie : cookies) {
                    stringBuilder.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
                httpPut.setHeader("Cookie", stringBuilder.toString());
            }
            result = httpClient.execute(httpPut, responseHandler);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        long time = System.currentTimeMillis() - start;
        logger.info("模拟request put请求url:{}  请求花费时间:{} ms", url, time);
        return result;
    }

}
