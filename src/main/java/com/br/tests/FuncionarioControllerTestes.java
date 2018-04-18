package com.br.tests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.br.controller.FuncionarioController;
import com.br.domain.Funcionario;
import com.br.repository.FuncionarioRepository;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(FuncionarioController.class)
public class FuncionarioControllerTestes {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	private static final String URL = "http://localhost:8080/api/funcionarios";

    @Test
	public void todos() throws Exception {
         mvc.perform(get(URL+"/todos").contentType(MediaType.APPLICATION_JSON))
                 					  .andExpect(status().isOk());
	}
    
    @Test
	public void novo() throws Exception {
    	 Funcionario novoFuncionario = new Funcionario("Teste POST",15000);
    	 Gson gson = new Gson();
         String json = gson.toJson(novoFuncionario);
         
         MvcResult result =  mvc.perform(post(URL+"/").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
 		 MockHttpServletResponse response = result.getResponse();

 		 assertEquals(200, response.getStatus());
	}
    
    @Test
	public void alterar() throws Exception {
    	 Funcionario jsonObj = new Funcionario(100,"Teste PUT",15000);
    	 Gson gson = new Gson();
         String json = gson.toJson(jsonObj);
         
         MvcResult result =  mvc.perform(put(URL+"/"+jsonObj.getId())
        		 				.contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
 		 MockHttpServletResponse response = result.getResponse();

 		 assertEquals(200, response.getStatus());
	}
    
    @Test
 	public void excluir() throws Exception {
     	 Funcionario jsonObj = new Funcionario(100,"Teste PUT",15000);
     	 
         MvcResult result =  mvc.perform(delete(URL+"/"+jsonObj.getId())
         		 				.contentType(MediaType.APPLICATION_JSON)).andReturn();
  		 MockHttpServletResponse response = result.getResponse();

  		 assertEquals(200, response.getStatus());
 	}


}
