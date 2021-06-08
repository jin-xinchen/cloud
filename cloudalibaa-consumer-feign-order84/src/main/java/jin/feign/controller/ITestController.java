package jin.feign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("HelloServer") //========= Does not work, Error is here.
public interface ITestController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String hello(@PathVariable("name") String name);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

}
