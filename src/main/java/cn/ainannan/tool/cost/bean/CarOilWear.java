package cn.ainannan.tool.cost.bean;

import java.util.Date;

import cn.ainannan.base.bean.BaseBean;

public class CarOilWear extends BaseBean<CarOilWear> {
	private Double shengTotal;	// 总升数
	private Date startTime;		// 计算开始时间
	private Date endTime;		// 计算结束时间
	private Integer lichengTotal;	// 总里程
	private Double money;			// 总花费
	private Double averageYoujia;	// 平均油价
	private Double baigongliyouhao;	// 百公里油耗

	public Double getShengTotal() {
		return shengTotal;
	}

	public void setShengTotal(Double shengTotal) {
		this.shengTotal = shengTotal;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getLichengTotal() {
		return lichengTotal;
	}

	public void setLichengTotal(Integer lichengTotal) {
		this.lichengTotal = lichengTotal;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getAverageYoujia() {
		return averageYoujia;
	}

	public void setAverageYoujia(Double averageYoujia) {
		this.averageYoujia = averageYoujia;
	}


	public CarOilWear(Double shengTotal, Date startTime, Date endTime, Integer lichengTotal, Double money,
			Double averageYoujia, Double baigongjiyouhao) {
		super();
		this.shengTotal = shengTotal;
		this.startTime = startTime;
		this.endTime = endTime;
		this.lichengTotal = lichengTotal;
		this.money = money;
		this.averageYoujia = averageYoujia;
		this.baigongliyouhao = baigongjiyouhao;
	}

	public CarOilWear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarOilWear(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Double getBaigongliyouhao() {
		return baigongliyouhao;
	}

	public void setBaigongliyouhao(Double baigongliyouhao) {
		this.baigongliyouhao = baigongliyouhao;
	}

}
