/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.cliente;

import br.edu.ifpb.pos.core.bo.Message;
import br.edu.ifpb.pos.core.bo.Response;
import br.edu.ifpb.pos.core.bo.ResponseType;
import br.edu.ifpb.pos.core.channel.PullingChannel;
import br.edu.ifpb.pos.core.channel.RegistryChannel;
import br.edu.ifpb.pos.core.channel.RequestChannel;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Random;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Loader {

    public static void main(String[] args) throws MalformedURLException, RemoteException, InterruptedException {
        PullingChannel pullingChannel = ChannelManager.getPullingChannel();
        RequestChannel requestChannel = ChannelManager.getRequestChannel();
        RegistryChannel registryChannel = ChannelManager.getRegistryChannel();
        //
        
        String session=registryChannel.registry();
        System.out.println("Registrando...."+session);
        //
        Message msg=new Message();
        msg.setSession(session);
        Integer dado=new Random().nextInt(100);
        System.out.println("O dado é: "+dado);
        msg.setDado(dado);
        requestChannel.request(msg);
        //
        
        while (true) {
            Response response=pullingChannel.pulling(session);
            if(response.getResponseType()==ResponseType.NO_RESPONSE){
                System.out.println("No response");
            }
            if(response.getResponseType()==ResponseType.SUCESS){
                System.out.println("A resposta é:"+response.getResponse()+", Sessão: "+response.getSessionUID());
                break;
            }
            Thread.sleep(5000);
        }
    }
}
