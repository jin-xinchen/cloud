package jin.springcloud.config;

//import com.google.common.collect.Sets;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class KafkaTopicConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
//        String topics = Sets.newHashSet(KafkaTopicEnum.values()).stream()
//                .map(KafkaTopicEnum::getTopic).collect(Collectors.joining(","));
//        System.setProperty("topics", topics);
    }
    // @DependsOn(value = "kafkaTopicConfig")
}
