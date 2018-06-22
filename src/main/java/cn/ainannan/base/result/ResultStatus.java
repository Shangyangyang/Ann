package cn.ainannan.base.result;

public enum ResultStatus {
	
	OK(1), // 成功
	ERROR(0); // 失败

	public int status;

	ResultStatus(int status) {
		this.status = status;
	}
}
