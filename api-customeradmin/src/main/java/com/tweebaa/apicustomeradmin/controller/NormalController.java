package com.tweebaa.apicustomeradmin.controller;

import com.tweebaa.apicustomeradmin.entity.UserA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v3")
public class NormalController {
    /**
     *GET：  http://api_url/api/v3/users/tmp_list?Pg=0&Nu=100
     * * 新增Pg和Nu两个参数： Pg表示当前页号，页号从0开始； Nu表示显示行数；
     * 返回数据：
     * 当Status=200时，返回：
     * {  "Code": 0,
     * "Data":{"totalCount":22,"pageSize":10,"totalPage":3,"currPage":2,"list":
     *    [   {
     *        "userId": 1920024,     "customerGuid": "2c99bb0a-b0ce-4057-9ef7-bbe415e1e1bc",
     *        "UserName": "tw1626604807000",   "StoreName": "tw1626604807000",
     *        "TweebaaId": "v2vdl1",
     *        "avatarUrl": null
     *       }
     *    ]
     * }
     * @return
     */
    @RequestMapping(value = "/users/tmp_list", method = RequestMethod.GET)
    public ResponseEntity<Object> validUsers(Model model, @RequestParam(value = "Pg",defaultValue = "0") int page, @RequestParam(value="Nu") int number)
    {
        try{
            PageCustomers pageCustomers = new PageCustomers();
            List<UserA> users = new ArrayList<UserA>();
            UserA user1 = new UserA(1920024L,"2c99bb0a-b0ce-4057-9ef7-bbe415e1e1bc",
     "tw1626604807000", "tw1626604807000",
      "v2vdl1",
     "avatarUrl");
            users.add(user1);
            pageCustomers.setList(users);
            return new ResponseEntity<>(new ResponseEnvelope<PageCustomers>(200,pageCustomers), HttpStatus.OK);
//            return new ResponseEntity<>(new ResponseEnvelope<String >(200, "test"), HttpStatus.OK);

        }catch (HttpClientErrorException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/users/test_list", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> save(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","success");
//        ObjectMapper mapper = new ObjectMapper();
//        String str = null;
//        try {
//            str = mapper.writeValueAsString(map);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
