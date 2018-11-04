package com.wzh.uri;

import java.net.URI;
import java.net.URISyntaxException;

public class UriTest {
    public static void main(String[] args) throws URISyntaxException {
        URI uri=new URI("hdfs://ubuntu64_20181026:9000");
        System.out.println(uri.getHost());
    }
}
