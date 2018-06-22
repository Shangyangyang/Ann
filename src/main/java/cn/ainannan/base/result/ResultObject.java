package cn.ainannan.base.result;

public class ResultObject {
	
	private int status = ResultStatus.OK.status;
	private int code = ResultCode.SUCCESS.code;
	
	private String message = null;
	
	private Object data = null;
	
	public ResultObject setCode(ResultCode resultCode) {		
		this.code = resultCode.code;
		return this;
	}
	
	public ResultObject setCode(int code) {
		this.code = code;
		return this;
	}
	
	public ResultObject setStatus(ResultStatus resultStatus) {
		this.status = resultStatus.status;
		return this;
	}
	
	public ResultObject setStatus(int status) {
		this.status = status;
		return this;
	}	

	public ResultObject setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResultObject setData(Object data) {
		this.data = data;
		return this;
	}
	
	public int getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}	
}
