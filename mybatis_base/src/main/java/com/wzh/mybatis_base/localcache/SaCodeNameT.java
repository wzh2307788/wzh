package com.wzh.mybatis_base.localcache;

public class SaCodeNameT {
    private String codeType;
    private String codeFlag;
    private String codeName;
    private String status;
    private String codeFlagExt;


    public SaCodeNameT(String codeType, String codeFlag, String codeName, String status, String codeFlagExt) {
        this.codeType = codeType;
        this.codeFlag = codeFlag;
        this.codeName = codeName;
        this.status = status;
        this.codeFlagExt = codeFlagExt;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeFlag() {
        return codeFlag;
    }

    public void setCodeFlag(String codeFlag) {
        this.codeFlag = codeFlag;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeFlagExt() {
        return codeFlagExt;
    }

    public void setCodeFlagExt(String codeFlagExt) {
        this.codeFlagExt = codeFlagExt;
    }
}
