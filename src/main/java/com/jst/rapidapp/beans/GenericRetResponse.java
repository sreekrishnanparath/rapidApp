package com.jst.rapidapp.beans;



public class GenericRetResponse {

    private String errCode;

    private String errMessage;

    private String xmlDoc;

    private String JsonString;

    public String getJsonString() {
        return JsonString;
    }


    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public String getXmlDoc() {
        return xmlDoc;
    }

    public GenericRetResponse(String errCode, String errMessage, String xmlDoc, String jsonString) {
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.xmlDoc = xmlDoc;
        JsonString = jsonString;
    }
}
