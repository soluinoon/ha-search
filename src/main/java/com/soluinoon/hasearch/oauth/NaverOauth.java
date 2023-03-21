package com.soluinoon.hasearch.oauth;

import org.springframework.beans.factory.annotation.Value;

public class NaverOauth implements LoginOauth{
    @Value("&{external.oauth.naver.request_url}") String url;
    @Override
    public String getOauthRedirectURL() {
        return "";
    }
}
