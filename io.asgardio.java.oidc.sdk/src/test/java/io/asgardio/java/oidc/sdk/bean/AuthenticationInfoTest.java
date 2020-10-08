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

package io.asgardio.java.oidc.sdk.bean;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.nimbusds.oauth2.sdk.token.AccessTokenType;
import com.nimbusds.oauth2.sdk.token.RefreshToken;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Unit tests for AuthenticationInfo model.
 */
public class AuthenticationInfoTest {

    AuthenticationInfo authenticationInfo = new AuthenticationInfo();

    @Test
    public void testGetUser() {

        Map<String, Object> attributes = new HashMap<>();
        User user = new User("subject", attributes);
        authenticationInfo.setUser(user);
        assertEquals(authenticationInfo.getUser(), user);
    }

    @Test
    public void testGetAccessToken() {

        AccessToken accessToken = new AccessToken(AccessTokenType.BEARER) {
            @Override
            public String toAuthorizationHeader() {

                return null;
            }
        };
        authenticationInfo.setAccessToken(accessToken);
        assertEquals(authenticationInfo.getAccessToken(), accessToken);
    }

    @Test
    public void testGetRefreshToken() {

        RefreshToken refreshToken = new RefreshToken();
        authenticationInfo.setRefreshToken(refreshToken);
        assertEquals(authenticationInfo.getRefreshToken(), refreshToken);
    }

    @Test
    public void testGetIdToken() {

        try {
            JWT idToken = JWTParser.parse("sample");
            authenticationInfo.setIdToken(idToken);
            assertEquals(authenticationInfo.getIdToken(), idToken);
        } catch (ParseException e) {
            //Test behaviour. Hence ignored.
        }
    }
}
