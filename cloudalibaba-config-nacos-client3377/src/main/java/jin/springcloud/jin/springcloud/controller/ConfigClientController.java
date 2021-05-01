package jin.springcloud.jin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    //Data Id=nacos-config-client-dev.yaml
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value="/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
