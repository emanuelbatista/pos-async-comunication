/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.repository;

import br.edu.ifpb.pos.core.bo.Message;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Enqueuer {
    
    private final Queue<Message> messages;

    private Enqueuer() {
        this.messages=new ConcurrentLinkedQueue();
    }
    
     public static Enqueuer getInstance() {
        return EnqueuerHolder.INSTANCE;
    }
    
    private static class EnqueuerHolder {
        private static final Enqueuer INSTANCE = new Enqueuer();
    }
    
    public void enqueue(Message msg){
        this.messages.add(msg);
    }
    
    public Message dequeue(){
        return this.messages.poll();
    }
    
    
    
}
