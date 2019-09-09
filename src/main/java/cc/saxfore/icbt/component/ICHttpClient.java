package cc.saxfore.icbt.component;

import cc.saxfore.icbt.common.util.ICJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICHttpClient
 * 类 描 述：TODO
 * 创建时间：2019/8/4 5:06 PM
 * 创 建 人：wangjiang
 */
@Component
public class ICHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(ICHttpClient.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 发送get请求
     *
     * @param reqUrl
     * @param params
     * @return
     */
    public String httpGet(String reqUrl, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(reqUrl).append("?");
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        logger.info("--------- httpGet reqUrl:{}", reqUrl.toString());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(sb.toString(), String.class);
        logger.info("--------- httpGet response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    /**
     * 发送post请求
     *
     * @param reqUrl
     * @param params
     * @return
     */
    public String httpPost(String reqUrl, Map<String, Object> params) {
        String requestBody = ICJsonUtil.toJsonString(params);
        logger.info("--------- httpPost reqUrl:{}", reqUrl);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, (Object) requestBody, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    /**
     * 特定媒体格式的post请求
     *
     * @param reqUrl
     * @param params
     * @param mediaType
     * @return
     */
    public String httpPost(String reqUrl, Map<String, Object> params, MediaType mediaType) {

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                map.add(entry.getKey(), entry.getValue());
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

        logger.info("--------- httpPost url:{}, request:{}", reqUrl, request);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, request, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    /**
     * json类型的post请求
     *
     * @param reqUrl
     * @param params
     * @return
     */
    public String httpPostJson(String reqUrl, String params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity<String>(params, headers);

        logger.info("--------- httpPost url:{}, request:{}", reqUrl, request);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, request, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

}
