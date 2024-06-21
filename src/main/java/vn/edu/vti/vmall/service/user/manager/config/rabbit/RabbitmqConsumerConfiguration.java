package vn.edu.vti.vmall.service.user.manager.config.rabbit;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConsumerConfiguration {
  @Value("${application.common-queue.rabbitmq.concurrent.consumers:5}")
  private int concurrentConsumers;
  @Value("${application.common-queue.rabbitmq.max.concurrent.consumers:30}")
  private int maxConcurrentConsumers;
  @Value("${application.common-queue.rabbitmq.prefetch:1}")
  private int prefetch;

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
      ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConcurrentConsumers(this.concurrentConsumers);
    factory.setMaxConcurrentConsumers(this.maxConcurrentConsumers);
    factory.setPrefetchCount(this.prefetch);
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(new Jackson2JsonMessageConverter());
    return factory;
  }

}
