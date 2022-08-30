package redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Redis {

	public static void main(String[] args)
	{
		try {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Connection Successful");
			System.out.println("The server is running"+jedis.ping());
			jedis.set("company-name","500Rockets.io");
			System.out.println("Stored strings in redis::"+jedis.get("company-name"));
			jedis.lpush("tutorial-list","Mongodb");		
			jedis.lpush("tutorial-list","Redis");		
			jedis.lpush("tutorial-list","Mysql");
			List<String>list=jedis.lrange("tutorial-list",0,5);
			for(int i = 0;i<list.size();i++)
			{
				System.out.println("Stored string in redis::"+list.get(i));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
