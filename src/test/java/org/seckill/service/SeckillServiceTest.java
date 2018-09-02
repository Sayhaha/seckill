package org.seckill.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit,spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})

public class SeckillServiceTest {

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills=seckillService.getSeckillList();
        System.out.println(seckills);

    }

    @Test
    public void getById() throws Exception {

        long seckillId=1001;
        Seckill seckill=seckillService.getById(seckillId);
        System.out.println(seckill);
    }

    @Test
    //完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() throws Exception {
        long seckillId=1001;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()) {
        	System.out.println(exposer);
        	long phone = 12345678910L;
        	String md5 = exposer.getMd5();
        	try {
        		SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
        		System.out.println(execution);
        	} catch (RepeatKillException e){
        		System.out.println(e.getMessage());
        	} catch (SeckillCloseException e){
        		System.out.println(e.getMessage());
        	}
        } else {
        	System.out.println(exposer);
        }
    }
    
    @Test
    public void executeSeckillProcedure() {
    	long seckillId = 1005;
    	long userPhone = 13580110101L;
    	Exposer exposer = seckillService.exportSeckillUrl(seckillId);
    	if(exposer.isExposed()) {
    		String md5 = exposer.getMd5();
    		SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
    		System.out.println(execution.getStateInfo());
    	}
    }

}