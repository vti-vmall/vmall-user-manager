package vn.edu.vti.vmall.service.user.manager.config.rabbit.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import vn.edu.vti.vmall.common.queue.config.properties.SingleQueueConfigProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "queue")
public class QueueConfigProperties {
  private SingleQueueConfigProperties sendEmail;
}
