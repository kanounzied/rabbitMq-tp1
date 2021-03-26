package same_shit_with_interfaces;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Message {

    private String queue;
    private String message;

    Message(String message, String queue){
        this.message = message;
        this.queue = queue;
    }

    public void send() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.56.101");
        factory.setUsername("test");
        factory.setPassword("test");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel())
        {
            channel.queueDeclare(this.queue,false,false,false,null);
            channel.basicPublish("",this.queue,null,this.message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
