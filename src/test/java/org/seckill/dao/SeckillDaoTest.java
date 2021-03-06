package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   配置spring和junit整合，这样junit在启动时就会加载spring容器
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() throws Exception {
        long seckillId=1001;
        Seckill seckill=seckillDao.queryById(seckillId);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    // java娌℃湁淇濆瓨褰㈠弬鐨勮褰晀ueryAll(int offet, int limit) -> queryAll(arg0, arg1)
    public void queryAll() throws Exception {

        List<Seckill> seckills=seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills)
        {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {

        long seckillId=1001;
        Date date=new Date();
        int updateCount=seckillDao.reduceNumber(seckillId,date);
        System.out.println(updateCount);

    }


}