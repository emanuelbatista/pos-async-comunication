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
import br.edu.ifpb.pos.servidor.repository.IndentificationManager;
import br.edu.ifpb.pos.servidor.repository.ResponseRepository;
import java.rmi.RemoteException;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Producer {

    private final IndentificationManager indentificationManager;
    private final Enqueuer enqueuer;
    private final ResponseRepository responseRepository;

    public Producer() {
        this.enqueuer = Enqueuer.getInstance();
        this.indentificationManager = IndentificationManager.getInstance();
        this.responseRepository = ResponseRepository.getInstance();
    }

    public String registry() throws RemoteException {
        return indentificationManager.registry();

    }

    public void request(Message request){
        enqueuer.enqueue(request);
    }

    public Response pulling(String session) throws RemoteException {
        Response response = responseRepository.getResponse(session);
        if (!response.getResponseType().equals(ResponseType.NO_RESPONSE)) {
            indentificationManager.release(session);
        }
        return response;
    }

}
