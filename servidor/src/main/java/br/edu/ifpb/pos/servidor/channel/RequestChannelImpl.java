/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.channel;

import br.edu.ifpb.pos.core.bo.Message;
import br.edu.ifpb.pos.core.channel.RequestChannel;
import br.edu.ifpb.pos.servidor.producer.Producer;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "RequestChannel",serviceName = "RequestChannel",targetNamespace = "http://channel.core.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class RequestChannelImpl implements RequestChannel {

    private Producer producer;

    public RequestChannelImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void request(Message msg) {
        producer.request(msg);
    }

}
