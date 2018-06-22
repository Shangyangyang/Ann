package cn.ainannan.base.result;

public class ResultGen {
	
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static ResultObject genSuccessResult() {
		return new ResultObject().setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static ResultObject genSuccessResult(Object data) {
		return new ResultObject().setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	public static ResultObject genFailResult(String message) {
		return new ResultObject().setStatus(ResultStatus.ERROR).setCode(ResultCode.FAIL).setMessage(message);
	}
}
