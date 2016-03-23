/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor;

import br.edu.ifpb.pos.servidor.channel.PullingChannelImpl;
import br.edu.ifpb.pos.servidor.channel.RegistryChannelImpl;
import br.edu.ifpb.pos.servidor.channel.RequestChannelImpl;
import br.edu.ifpb.pos.servidor.producer.Processor;
import br.edu.ifpb.pos.servidor.producer.Producer;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Loader {
    
    public static void main(String[] args) {
        Producer producer=new Producer();
        Endpoint.publish("http://localhost:8080/pulling", new PullingChannelImpl(producer));
        Endpoint.publish("http://localhost:8080/request", new RequestChannelImpl(producer));
        Endpoint.publish("http://localhost:8080/registry", new RegistryChannelImpl(producer));
        new Thread(new Processor()).start();
        System.out.println("Fim");
    }
}