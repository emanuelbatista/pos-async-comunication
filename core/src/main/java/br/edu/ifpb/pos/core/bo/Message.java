/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.core.bo;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Message {
    
    private String session;
    private Integer dado;

    public Message() {
    }

    public Message(String session, Integer dado) {
        this.session = session;
        this.dado = dado;
    }
    
    public Integer getDado() {
        return dado;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }
    

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
    
}
