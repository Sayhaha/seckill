package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * ������ɱ�ɹ���¼����ϸ
	 * @param seckillId
	 * @param userPhone
	 * @return ���������
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

	/**
	 * ����id��ѯSuccessKilled��¼����Я����ɱ��Ʒ����ʵ��
	 * @param seckilled
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckilled") long seckilled, @Param("userPhone") long userPhone);
}
