package com.dataart.retman.rest.client;

import com.dataart.retman.domain.Spittle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        get();
    }

    public static void postForLocation() throws MalformedURLException {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle("Tree is green");
        URL uri = template.postForLocation("http://localhost:1717/spittles/spittle", spittle).toURL();
        System.out.println(uri);
    }

    public static void post() {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle("Mouse is big");
        ResponseEntity<Spittle> entity = template.postForEntity("http://localhost:1717/spittles/spittle", spittle, Spittle.class);
        System.out.println(entity.getBody());
        System.out.println(entity.getHeaders().getAccept());
        System.out.println(entity.getHeaders().getLocation());
    }

    public static void get() {
        RestTemplate template = new RestTemplate();

        ResponseEntity<Spittle> responseEntity;

        MultiValueMap<String, String> reqHeaders = new LinkedMultiValueMap<String, String>();
        reqHeaders.add("Accept", "application/json");
        reqHeaders.add("Content-Type", "application/json");
        HttpEntity<Object> reqEntity = new HttpEntity<Object>(reqHeaders);
//        responseEntity = template.getForEntity("http://localhost:1717/spittles/{spittle}", Spittle.class, 9);
        responseEntity = template.exchange("http://localhost:1717/spittles/{spittle}", HttpMethod.GET, reqEntity, Spittle.class, 9);

        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(responseEntity.getStatusCode());
        System.out.println(headers.getAccept());
        System.out.println(headers.getLastModified());
        System.out.println(responseEntity.getBody());


    }
}
