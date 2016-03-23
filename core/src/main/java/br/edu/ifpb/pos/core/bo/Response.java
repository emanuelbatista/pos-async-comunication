/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.core.bo;

import java.io.Serializable;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Response implements Serializable {

    private String sessionUID;
    private ResponseType responseType;
    private String response;
    private String message;
    private Integer flag;

    public Response() {
    }

    public Response(String sessionUID, ResponseType responseType, String message, Integer flag, String response) {
        this.sessionUID = sessionUID;
        this.responseType = responseType;
        this.message = message;
        this.flag = flag;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getSessionUID() {
        return sessionUID;
    }

    public void setSessionUID(String sessionUID) {
        this.sessionUID = sessionUID;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
