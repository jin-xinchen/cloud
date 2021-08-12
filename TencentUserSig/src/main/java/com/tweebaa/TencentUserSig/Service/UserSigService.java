package com.tweebaa.TencentUserSig.Service;

import com.bweebaa.util.StringUtil;
import com.tencentyun.TLSSigAPIv2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserSigService {
    @Value("${tbConfig.sdkAppId}")
    private long sdkAppId;
    @Value("${tbConfig.secretKey}")
    private String secretKey;
    @Value("${tbConfig.expire}")
    private long expire = 60*60*24*7;

    public String generateUserSig(String userid){
        if(StringUtil.IsNullOrWhiteSpace(userid)){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"userid");
        }
        TLSSigAPIv2 api = new TLSSigAPIv2(sdkAppId,secretKey);
        return api.genUserSig(userid,expire);
    }

}
