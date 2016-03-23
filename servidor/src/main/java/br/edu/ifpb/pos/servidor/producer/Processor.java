/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.producer;

import br.edu.ifpb.pos.core.bo.Message;
import br.edu.ifpb.pos.core.bo.Response;
import br.edu.ifpb.pos.core.bo.ResponseType;
import br.edu.ifpb.pos.servidor.repository.Enqueuer;
import br.edu.ifpb.pos.servidor.repository.ResponseRepository;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Processor implements Runnable {

    private final Enqueuer enqueuer;
    private final ResponseRepository responseRepository;

    public Processor() {
        enqueuer = Enqueuer.getInstance();
        responseRepository = ResponseRepository.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            Message message = enqueuer.dequeue();
            if (message == null) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                }
                continue;
            }
            try {
                long time = System.currentTimeMillis();
                Random random = new Random();
                Integer dado = message.getDado();
                Thread.sleep(random.nextInt(20000) + 10000);
                time = System.currentTimeMillis() - time;
                responseRepository.store(new Response(message.getSession(), ResponseType.SUCESS, null, 200,String.valueOf(dado)));
            } catch (InterruptedException ex) {
                responseRepository.store(new Response(message.getSession(), ResponseType.FAIL, "Erro interno", 500,null));
                return;
            }
        }
    }

}
