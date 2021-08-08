package com.tweebaa.apicustomeradmin.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseEnvelope<T> {
    @JsonProperty("Code")
    private Integer Code;
    //@Getter
    //private String message;
    private T Data;

//    public ResponseEnvelope(Integer code, String message, T data) {
        public ResponseEnvelope(Integer code, T data) {
        this.Code = code;
        //this.message = message;
        this.Data = data;
    }
}
