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
 *   ����spring��junit���ϣ�����junit������ʱ�ͻ����spring����
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ����junit spring�������ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//ע��Daoʵ��������
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
    // java没有保存形参的记录queryAll(int offet, int limit) -> queryAll(arg0, arg1)
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