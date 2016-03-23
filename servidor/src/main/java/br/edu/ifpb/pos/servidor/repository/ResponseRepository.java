/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.servidor.repository;

import br.edu.ifpb.pos.core.bo.Response;
import br.edu.ifpb.pos.core.bo.ResponseType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ResponseRepository {
    
    private final Map<String,Response> responses;
    
    private ResponseRepository() {
        this.responses=new HashMap<>();
    }
    
    public static ResponseRepository getInstance() {
        return ResponseRepositoryHolder.INSTANCE;
    }
    
    private static class ResponseRepositoryHolder {

        private static final ResponseRepository INSTANCE = new ResponseRepository();
    }
    
    public void store(Response response){
        responses.put(response.getSessionUID(), response);
    }
    
    public Response getResponse(String uid){
        Response response=responses.get(uid);
        if(response==null){
            return new Response(uid, ResponseType.NO_RESPONSE, "Sem resposta", 404,null);
        }
        responses.remove(uid);
        return response;
    }
}
