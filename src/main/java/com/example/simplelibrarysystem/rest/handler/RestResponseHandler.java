package com.example.simplelibrarysystem.rest.handler;

import com.example.simplelibrarysystem.rest.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseHandler {

    public ResponseEntity<?> successResponseDataSaving(Object object) {
        return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK, object, "Successfully data saved."));
    }

    public ResponseEntity<?> successResponseDataRetrieve(Object object) {
        return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK, object, "Success"));
    }
}
