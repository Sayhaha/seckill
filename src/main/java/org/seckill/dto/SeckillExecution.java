package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;

public class SeckillExecution {
	
	// ��ɱ��Ʒ��id
	private long seckillId;
	
	// ��ɱִ�н����״̬
	private int state;
	
	// ״̬����
	private String stateInfo;
	
	// ��ɱ�ɹ��Ķ���
	private SuccessKilled successkilled;
	
	
	public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessKilled successkilled) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.successkilled = successkilled;
	}
	
	

	public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}



	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccesskilled() {
		return successkilled;
	}

	public void setSuccesskilled(SuccessKilled successkilled) {
		this.successkilled = successkilled;
	}
	
	

}
