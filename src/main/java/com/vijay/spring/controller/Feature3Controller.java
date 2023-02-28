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

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@Log4j2
public class Feature3Controller {
    @GetMapping("/feature3a")
    public ResponseEntity<Map<String, String>> methodF3a() {
        log.info("Inside methodF3...");
        Map<String, String> jsonResponse = new java.util.HashMap<String, String>(Collections.EMPTY_MAP);
        jsonResponse.put("1", "100");
        jsonResponse.put("B", "value for B");
        log.debug(jsonResponse);
        log.info("Exiting methodF3...");
        return ResponseEntity.ok(jsonResponse);
    }
}
