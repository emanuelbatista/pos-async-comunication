/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.cliente;

import br.edu.ifpb.pos.core.channel.PullingChannel;
import br.edu.ifpb.pos.core.channel.RegistryChannel;
import br.edu.ifpb.pos.core.channel.RequestChannel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ChannelManager {
    
    public static PullingChannel getPullingChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:8080/pulling?wsdl");
        QName qName=new QName("http://channel.core.pos.ifpb.edu.br/", "PullingChannel");
        Service service=Service.create(url, qName);
        return service.getPort(PullingChannel.class);
    }
    
    public static RegistryChannel getRegistryChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:8080/registry?wsdl");
        QName qName=new QName("http://channel.core.pos.ifpb.edu.br/", "RegistryChannel");
        Service service=Service.create(url, qName);
        return service.getPort(RegistryChannel.class);
    }
    public static RequestChannel getRequestChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:8080/request?wsdl");
        QName qName=new QName("http://channel.core.pos.ifpb.edu.br/", "RequestChannel");
        Service service=Service.create(url, qName);
        return service.getPort(RequestChannel.class);
    }
    
}
