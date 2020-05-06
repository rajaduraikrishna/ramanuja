package com.sriranga;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Exams", description = "Resource for Exams", tags = { "Exams" })
@RestController
@RequestMapping("/api/kvstore")
class StoreController {

    private final Map<String, String> keyValueStore = new HashMap<>();

    @ApiOperation(value = "Add neww key", notes = "Only allowed to add new key and value.")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Valued added against the key successfully"),
            @ApiResponse(code = 400, message = "Key Value pair is invalid") })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> addKV(@RequestParam String key, @RequestParam String value) {
        keyValueStore.put(key, value);
        return ResponseEntity.of(Optional.of(key));
    }


    @ApiOperation(value = "Get value for a given key", notes = "Value for the given key")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid key") })
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{key}")
    public ResponseEntity<String> read(@PathVariable String key) {
        return ResponseEntity.of(Optional.of(keyValueStore.get(key)));
    }
}
