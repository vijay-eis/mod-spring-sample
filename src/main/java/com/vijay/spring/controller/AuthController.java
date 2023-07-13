/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.vijay.spring.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class AuthController {
    @GetMapping("/auth/signin")
    @ResponseBody
    public ResponseEntity<?> signIn(@RequestParam String credentials, HttpServletResponse response) {
        log.info("Signing in..");
        Cookie cookie = new Cookie("token", "A1B2C3D4E5F6G7H8");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return new ResponseEntity<>("LOGINOK",HttpStatus.OK);
    }

    @GetMapping("/auth/logout")
    @ResponseBody
    public ResponseEntity<?> logout(HttpServletResponse response) {
        log.info("logging out..");
        Cookie cookie = new Cookie("token", "");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/auth/profile")
    @ResponseBody
    public ResponseEntity<?> getProfile(@CookieValue(name = "token") String token) {
        log.info("Get token..");
        return new ResponseEntity<>(token,HttpStatus.OK);
    }
}
