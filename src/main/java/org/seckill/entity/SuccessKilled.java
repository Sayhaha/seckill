package org.seckill.entity;

import java.util.Date;

public class SuccessKilled {
	
	private long secKillId;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;
	
	//多对一，一个秒杀成功的seckill对应多个秒杀成功的记录
	private Seckill secKill;

	public long getSecKillId() {
		return secKillId;
	}

	public void setSecKillId(long secKillId) {
		this.secKillId = secKillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public Seckill getSecKill() {
		return secKill;
	}

	public void setSecKill(Seckill secKill) {
		this.secKill = secKill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [secKillId=" + secKillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}
	
	
}
