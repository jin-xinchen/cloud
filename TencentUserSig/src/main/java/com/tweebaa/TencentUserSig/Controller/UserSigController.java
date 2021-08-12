package com.tweebaa.TencentUserSig.Controller;

import com.tweebaa.TencentUserSig.Service.UserSigService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tencent")
public class UserSigController {
    Logger logger = LogManager.getLogger(UserSigController.class);
  @Resource
    UserSigService userSigService;

  @GetMapping("/usig")
    public ResponseEntity<Object> getUserSig(String id){
      try{
          String sig = userSigService.generateUserSig(id);
          return new ResponseEntity<>(sig, HttpStatus.OK);
      }catch (HttpClientErrorException e){
          logger.error(id,e);
          return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
      }
      catch (Exception e) {
          logger.error(id,e);
          return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
}
