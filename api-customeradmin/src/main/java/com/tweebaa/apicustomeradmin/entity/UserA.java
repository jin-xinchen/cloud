package com.tweebaa.apicustomeradmin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * //    "userId": 1920024,     "customerGuid": "2c99bb0a-b0ce-4057-9ef7-bbe415e1e1bc",
 * //    "UserName": "tw1626604807000",   "StoreName": "tw1626604807000",
 * //    "TweebaaId": "v2vdl1",
 * //    "avatarUrl": null
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserA {

    private Long userId;
    private String customerGuid;
    private String UserName;
    private String StoreName;
    @JsonProperty("TweebaaId")
    private String TweebaaId;
    private String avatarUrl;

}
