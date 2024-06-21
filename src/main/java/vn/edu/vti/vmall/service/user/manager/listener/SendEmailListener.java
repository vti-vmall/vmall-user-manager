package vn.edu.vti.vmall.service.user.manager.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vn.edu.vti.vmall.service.user.manager.payload.request.SendEmailRequest;

@Component
@Slf4j
public class SendEmailListener {
//  @RabbitListener(queues = "local.send.email.queue")
  public void testListener(SendEmailRequest sendEmailRequest){
    log.info("Msg: [{}]", sendEmailRequest);
  }

}
