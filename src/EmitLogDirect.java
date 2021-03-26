import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {
    private static final String EXCHAGE_NAME = "direct_logs";
    
    public static void main(String[] argv) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.56.101");
        factory.setUsername("test");
        factory.setPassword("test");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel())
        {
            channel.exchangeDeclare(EXCHAGE_NAME, BuiltinExchangeType.DIRECT);

            String severity = getSeverity(argv);
            String message = getMessage(argv);

            channel.basicPublish(EXCHAGE_NAME, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + severity + "': '" + message + "'");
        }
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 2)
            return "Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0) return "";
        if (length <= startIndex) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

    private static String getSeverity(String[] strings) {
        if (strings.length < 1){
            return "info";
        }
        return strings[0];
    }
}
