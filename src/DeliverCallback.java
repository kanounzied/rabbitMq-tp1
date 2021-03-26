import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

public interface DeliverCallback {
    void handle(String consumerTag, Delivery message) throws IOException;
    String basicConsume(String queue, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException;

}
