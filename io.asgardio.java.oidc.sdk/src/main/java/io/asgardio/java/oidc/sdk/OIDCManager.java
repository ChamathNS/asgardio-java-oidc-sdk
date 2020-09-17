/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.asgardio.java.oidc.sdk;

import com.nimbusds.jwt.JWT;
import com.nimbusds.oauth2.sdk.AuthorizationRequest;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.nimbusds.oauth2.sdk.token.RefreshToken;
import com.nimbusds.openid.connect.sdk.LogoutRequest;
import io.asgardio.java.oidc.sdk.bean.AuthenticationContext;
import io.asgardio.java.oidc.sdk.bean.OIDCAgentConfig;
import io.asgardio.java.oidc.sdk.bean.User;
import io.asgardio.java.oidc.sdk.exception.SSOAgentException;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface OIDCManager {

    // rename (sendForLogin)
    void login(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void handleOIDCCallback(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void logout(HttpServletRequest request, HttpServletResponse response) throws SSOAgentException, IOException;

    boolean isActiveSessionPresent(HttpServletRequest request);




    void init();

    AuthenticationContext authenticate();

    Map<String, Object> getUserInfo();

    void validateAuthentication();

    AccessToken getAccessToken();

    JWT getIDToken();

    RefreshToken getRefreshToken();
}
