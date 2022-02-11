package com.cy.redisdemo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class redisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduck")
    public String deductStock(){
        String lockKey = "key101";
//        String clientId = UUID.randomUUID().toString();
//        Boolean result1 = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);//jedis.setnx(key,vlaue)
//        if(!result1){
//            return  "error code";
//        }

        RLock redissonLock = redisson.getLock(lockKey);
        try {
            //加锁
            redissonLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0){
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("库存扣减成功，剩余库存："+realStock);


            }else {
                System.out.println("库存扣减失败，库存不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redissonLock.unlock();
            //            if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey)))
//            stringRedisTemplate.delete(lockKey);
//        }
        }

        return "end";
    }
}
