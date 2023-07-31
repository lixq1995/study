package com.test.local;

/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pab.kycrapp.constant.IntelligenceSearchConstant;
import com.pab.kycrapp.mq.factory.DefaultBankRQConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.impl.MQClientAPIImpl;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.spring.starter.RocketMQProperties;
import org.apache.rocketmq.spring.starter.RocketMQProperties.Producer;
import org.apache.rocketmq.spring.starter.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableConfigurationProperties({RocketMQProperties.class})
@ConditionalOnClass({MQClientAPIImpl.class})
@Order
public class RocketConfiguration {
    private static final Logger log = LoggerFactory.getLogger(RocketConfiguration.class);

    public RocketConfiguration() {
        //sonar:donothing
    }

    @Bean
    @ConditionalOnClass({DefaultMQProducer.class})
    @ConditionalOnMissingBean({DefaultMQProducer.class})
    @ConditionalOnProperty(
        prefix = "spring.rocketmq",
        value = {"nameServer", "producer.group"}
    )
    @Order(1)
    public DefaultMQProducer mqProducer1(RocketMQProperties rocketMQProperties) {
        Producer producerConfig = rocketMQProperties.getProducer();
        String groupName = producerConfig.getGroup();
        Assert.hasText(groupName, "[spring.rocketmq.producer.group] must not be null");
        DefaultMQProducer producer = new DefaultMQProducer(producerConfig.getGroup());
        String subIndex = "_Ins" + UtilAll.getPid();
        if (!StringUtils.isEmpty(rocketMQProperties.getInstanceName())) {
            subIndex = "_" + rocketMQProperties.getInstanceName();
        }

        producer.setInstanceName(producerConfig.getGroup() + subIndex);
        producer.setNamesrvAddr(rocketMQProperties.getNameServer());
        producer.setSendMsgTimeout(producerConfig.getSendMsgTimeout());
        producer.setRetryTimesWhenSendFailed(producerConfig.getRetryTimesWhenSendFailed());
        producer.setRetryTimesWhenSendAsyncFailed(producerConfig.getRetryTimesWhenSendAsyncFailed());
        producer.setMaxMessageSize(producerConfig.getMaxMessageSize());
        producer.setCompressMsgBodyOverHowmuch(producerConfig.getCompressMsgBodyOverHowmuch());
        producer.setRetryAnotherBrokerWhenNotStoreOK(producerConfig.isRetryAnotherBrokerWhenNotStoreOk());
        producer.setVipChannelEnabled(false);
        return producer;
    }

    @Bean
    @ConditionalOnClass({ObjectMapper.class})
    @ConditionalOnMissingBean(
        name = {"rocketMQMessageObjectMapper"}
    )
    public ObjectMapper rocketMQMessageObjectMapper() {
        return new ObjectMapper();
    }

    @Bean(
        destroyMethod = "destroy"
    )
    @ConditionalOnBean({DefaultMQProducer.class})
    @ConditionalOnMissingBean(
        name = {"rocketMQTemplate"}
    )
    @Order(3)
    public RocketMQTemplate rocketMQTemplate(DefaultMQProducer mqProducer, @Autowired(required = false) @Qualifier("rocketMQMessageObjectMapper") ObjectMapper objectMapper, @Autowired(required = false) @Qualifier("mqProducerMap") Map<String, DefaultMQProducer> rocketMQProducerMap) {
        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
        rocketMQTemplate.setProducer(mqProducer);
        if (Objects.nonNull(rocketMQProducerMap)) {
            log.info("init RocketMQTemplate set setProducerMap");
            rocketMQTemplate.setProducerMap(rocketMQProducerMap);
            log.info("init setSingleProducer false");
            rocketMQTemplate.setSingleProducer(false);
        } else {
            log.info("init RocketMQTemplate set setProducerMap null");
            log.info("init setSingleProducer true");
            rocketMQTemplate.setSingleProducer(true);
        }

        if (Objects.nonNull(objectMapper)) {
            rocketMQTemplate.setObjectMapper(objectMapper);
        }

        return rocketMQTemplate;
    }

    */
/**
     * 消费者配置
     *//*


    @Value("${spring.rocketmq.producer.group:}")
    private String group;

    @Value("${spring.rocketmq.nameServer:}")
    private String nameServer;

    @Autowired
    private DefaultBankRQConsumer defaultBankRQConsumer;

    @Bean
    public DefaultMQPushConsumer getRocketmqConsumer() throws Exception {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(group);
        defaultMQPushConsumer.setNamesrvAddr(nameServer);
        defaultMQPushConsumer.setPullThresholdForQueue(100);
        defaultMQPushConsumer.setConsumeThreadMin(10);
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(1);
        // 定义多个topci
        HashMap<String, String> map = new HashMap<>();
        map.put(IntelligenceSearchConstant.TOPIC,"tag || 1");
        map.put("cicp-ncore-rl_case_info","case_info_producerTag");
        defaultMQPushConsumer.setSubscription(map);
        defaultMQPushConsumer.registerMessageListener(defaultBankRQConsumer);
        defaultMQPushConsumer.start();
        return defaultMQPushConsumer;
    }
}
*/
