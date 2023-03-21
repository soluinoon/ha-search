package com.soluinoon.hasearch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Value("${external.oauth.naver.callback_url}") String callBackUrl;
    @GetMapping("/naver")
    public String redirectNaverLogin() {
//        String redirectUrl = loginService.getOauthRedirectUrl(SocialType.NAVER);
        String url = "http://nid.naver.com/oauth2.0/authorize"
                + "?response_type=code"
                + "&client_id=9fUB7ht0QaurijN2PXRo"
                + "&state=abc"
                + "&redirect_uri=http://localhost:8080/accounts/auth/naver/callback";

        System.out.println("url = " + url);
        return "redirect:" + url;
    }
}
