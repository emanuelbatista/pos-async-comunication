/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.repository;

import br.edu.ifpb.pos.servidor.bo.Session;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class IndentificationManager {
    
    private final Map<String,Session> sessions;
    
    private IndentificationManager() {
        this.sessions=new HashMap<>();
    }
    
    public static IndentificationManager getInstance() {
        return IndentificationManagerHolder.INSTANCE;
    }
    
    private static class IndentificationManagerHolder {
        private static final IndentificationManager INSTANCE = new IndentificationManager();
    }
    
    public String registry(){
        String uid=String.valueOf(System.currentTimeMillis()+sessions.size());
        sessions.put(uid, new Session(uid));
        return uid;
    }

    public Session getSession(String uid){
        return sessions.get(uid);
    }
    
    public void release(String uid){
        sessions.remove(uid);
    }
    
    
}
