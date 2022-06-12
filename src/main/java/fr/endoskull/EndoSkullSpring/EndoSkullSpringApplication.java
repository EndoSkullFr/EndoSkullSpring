package fr.endoskull.EndoSkullSpring;

import fr.endoskull.EndoSkullSpring.data.JedisAccess;
import fr.endoskull.EndoSkullSpring.data.MySQL;
import fr.endoskull.EndoSkullSpring.utils.TokenClearTask;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class EndoSkullSpringApplication {

	private static BasicDataSource connectionPool;
	private static JedisAccess jedisAccess;
	private static HashMap<String, Integer> tokens = new HashMap<>();
	private static int maxRequest = 60;

	public static void main(String[] args) {
		initConnection();
		jedisAccess = new JedisAccess("127.0.0.1", 6379, "FimfvtAKApReX1kBgukpVn6CFyZLXa6X5MYXB4ZBFSnUqOfAd6pzqTi4GCrWcX7qwl8TSNUIMHR5MyIw");
		jedisAccess.initConnection();
		SpringApplication.run(EndoSkullSpringApplication.class, args);
		new TokenClearTask(1);
	}

	private static void initConnection(){
		connectionPool = new BasicDataSource();
		connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
		connectionPool.setUsername("endoskull"); //w_512203
		connectionPool.setPassword("9zRQ2Cb03DxdPTmG"); //45geFJ445geFJ445geFJ445geFJ4
		connectionPool.setUrl("jdbc:mysql://" + "localhost" + ":" + 3306 + "/" + "endoskull" + "?autoReconnect=true");
		connectionPool.setInitialSize(1);
		connectionPool.setMaxTotal(10);
		new MySQL(connectionPool);
	}

	public static HashMap<String, Integer> getTokens() {
		return tokens;
	}

	public static int getMaxRequest() {
		return maxRequest;
	}
}
