/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.channel;

import br.edu.ifpb.pos.core.channel.PullingChannel;
import br.edu.ifpb.pos.core.bo.Response;
import br.edu.ifpb.pos.servidor.producer.Producer;
import java.rmi.RemoteException;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "PullingChannel",serviceName = "PullingChannel",targetNamespace = "http://channel.core.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class PullingChannelImpl implements PullingChannel{
    
    private Producer producer;

    public PullingChannelImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public Response pulling(String session) throws RemoteException {
        return producer.pulling(session);
    }
    
    
}
