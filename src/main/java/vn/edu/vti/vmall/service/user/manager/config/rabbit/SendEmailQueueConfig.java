package vn.edu.vti.vmall.service.user.manager.config.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendEmailQueueConfig {
  private String routingKey = "local.send.email.routing-key";
  private String queueName = "local.send.email.queue";

  private String exchangeName = "local.send.email.exchange";

  @Bean
  DirectExchange sendEmailExchange() {
    return new DirectExchange(exchangeName);
  }

  @Bean
  public Queue sendEmailQueue() {
    return QueueBuilder.durable(queueName).build();
  }

  @Bean
  Binding bpEventDetailCmpBinding(Queue sendEmailQueue,
      DirectExchange sendEmailExchange) {
    return BindingBuilder
        .bind(sendEmailQueue)
        .to(sendEmailExchange)
        .with(routingKey);
  }
}
