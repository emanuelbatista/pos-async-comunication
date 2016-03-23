/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.channel;

import br.edu.ifpb.pos.core.channel.RegistryChannel;
import br.edu.ifpb.pos.servidor.producer.Producer;
import java.rmi.RemoteException;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "RegistryChannel",serviceName = "RegistryChannel",targetNamespace = "http://channel.core.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class RegistryChannelImpl implements RegistryChannel{
    
    private Producer producer;

    public RegistryChannelImpl(Producer producer) {
        this.producer = producer;
    }
    

    @Override
    public String registry() throws RemoteException {
        return producer.registry();
    }
    
}
