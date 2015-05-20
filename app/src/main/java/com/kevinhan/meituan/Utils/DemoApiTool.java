/*package com.kevinhan.meituan.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.util.URIUtil;


*//**
 * Android�汾API����
 * <p>
 *
 * @author : xiaopeng.li
 *         <p>
 * @version 1.0 2013-1-23
 * @since dianping-java-samples 1.0
 *//*
public class DemoApiTool
{

    *//**
     * ��ȡ�����ַ�
     *
     * @param appKey
     * @param secret
     * @param paramMap
     * @return
     *//*
    public static String getQueryString(String appKey, String secret, Map<String, String> paramMap)
    {
        String sign = sign(appKey, secret, paramMap);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appkey=").append(appKey).append("&sign=").append(sign);
        for (Entry<String, String> entry : paramMap.entrySet())
        {
            stringBuilder.append('&').append(entry.getKey()).append('=').append(entry.getValue());
        }
        String queryString = stringBuilder.toString();
        return queryString;
    }

    *//**
     * ��ȡ�����ַ�����ֵ����UTF-8����
     *
     * @param appKey
     * @param secret
     * @param paramMap
     * @return
     *//*
    public static String getUrlEncodedQueryString(String appKey, String secret, Map<String, String> paramMap)
    {
        String sign = sign(appKey, secret, paramMap);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appkey=").append(appKey).append("&sign=").append(sign);
        for (Entry<String, String> entry : paramMap.entrySet())
        {
            try
            {
                stringBuilder.append('&').append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(),
                        "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
            }
        }
        String queryString = stringBuilder.toString();
        return queryString;
    }

    *//**
     * ����API
     *
     * @param apiUrl
     * @param appKey
     * @param secret
     * @param paramMap
     * @return
     *//*
    public static String requestApi(String apiUrl, String appKey, String secret, Map<String, String> paramMap)
    {
        String queryString = getQueryString(appKey, secret, paramMap);

        StringBuffer response = new StringBuffer();
        HttpClientParams httpConnectionParams = new HttpClientParams();
        httpConnectionParams.setConnectionManagerTimeout(1000);
        HttpClient client = new HttpClient(httpConnectionParams);
        HttpMethod method = new GetMethod(apiUrl);

        try
        {
            if (queryString != null && !queryString.isEmpty())
            {
                // Encode query string with UTF-8
                String encodeQuery = URIUtil.encodeQuery(queryString, "UTF-8");
                method.setQueryString(encodeQuery);
            }

            client.executeMethod(method);
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                response.append(line).append(System.getProperty("line.separator"));
            }
            reader.close();
        }
        catch (URIException e)
        {
        }
        catch (IOException e)
        {
        }
        finally
        {
            method.releaseConnection();
        }
        return response.toString();

    }

    *//**
     * ǩ��
     *
     * @param appKey
     * @param secret
     * @param paramMap
     * @return
     *//*
    public static String sign(String appKey, String secret, Map<String, String> paramMap)
    {
        // ����������
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        // ƴ�Ӳ���
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appKey);
        for (String key : keyArray)
        {
            stringBuilder.append(key).append(paramMap.get(key));
        }

        stringBuilder.append(secret);
        String codes = stringBuilder.toString();

        // SHA-1ǩ��
        // For Android
        String sign = new String(Hex.encodeHex(DigestUtils.sha(codes))).toUpperCase();

        return sign;
    }
}*/
