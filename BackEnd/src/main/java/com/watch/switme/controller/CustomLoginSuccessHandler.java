package com.watch.switme.controller;

import com.watch.switme.domain.MyUserDetails;
import com.watch.switme.domain.User;
import com.watch.switme.domain.AuthConstants;
import com.watch.switme.service.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) {
        final User user = ((MyUserDetails) authentication.getPrincipal()).getUser();
        final String token = TokenUtils.generateJwtToken(user);
        int score = Integer.parseInt(String.valueOf(user.getUser_idx()));
        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
        response.addIntHeader(AuthConstants.USER_HEADER, score);
    }
}
