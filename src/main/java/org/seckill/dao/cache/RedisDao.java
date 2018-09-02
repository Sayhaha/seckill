package org.seckill.dao.cache;

import org.seckill.entity.Seckill;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
	
	/**
	 * get from cache
	 * if null
	 *     get db
	 * else
	 *     put cache
	 * locgoin 
	 */
	private JedisPool jedisPool;

	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
	
	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}
	
	public Seckill getSeckill(long seckillId) {
		// redis�Ĳ����߼�
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;
				// ��û��ʵ�����л�����
				// get->byte[] -> �����л� -> Object(Seckill)
				// �����Զ������л�
				// protostuff : pojo
				byte[] bytes = jedis.get(key.getBytes());
				// �ӻ����л�ȡ
				if(bytes != null) {
					Seckill seckill = schema.newMessage(); // ���ɿն���
					ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
					// seckill �������л�
					return seckill;
				}
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String putSeckill(Seckill seckill) {
		// set Object(Seckill) -> ���л� -> byte[]
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckill.getSeckillId();
				byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, 
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				// ��ʱ����
				int timeout = 60 * 60; // 1Сʱ
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				return result;
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
