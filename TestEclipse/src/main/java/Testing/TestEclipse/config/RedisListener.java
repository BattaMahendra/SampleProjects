package Testing.TestEclipse.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisListener implements MessageListener {

	private static List<String> messageList=new ArrayList<>();
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		messageList.add(message.toString());
		log.info("consumed message is {}",message);
		
		
	}

}
