package com.urp.tool;

public enum JsonReturnCode {
	    NOT_LOGIN("401","δ��¼"),
	    SUCCESS ("200","�ɹ�"),
	    FAIL ("500","�ڲ�ʧ��"),
		ACCESS_ERROR ("403","��ֹ����"),
		NOT_FOUND ("404","ҳ��δ����");
	    private String code;
	    private String desc;

	    JsonReturnCode(String code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }
}
