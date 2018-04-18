package com.br.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.domain.Funcionario;
import com.br.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncionarioRepositoryTestes {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Test
	public void incluir() {
		Funcionario novo = new Funcionario("Teste",7800);
		Funcionario novoSalvo = funcionarioRepository.save(novo);
		Funcionario gravou = funcionarioRepository.findOne(novoSalvo.getId());
		assertNotNull(gravou);
	}
	
	@Test
	public void todos() {
		List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();
		assertNotNull(listaFuncionarios);
		assertTrue(!listaFuncionarios.isEmpty());
	}
	
	@Test
	public void alterar() {
		Funcionario novo = new Funcionario("TesteAlterar",8900);
		Funcionario novoSalvo = funcionarioRepository.save(novo);
		novoSalvo.setNome("Teste alterado ok!");
		novoSalvo.setSalario(4900);
		Funcionario alterado = funcionarioRepository.save(novoSalvo);
		assertNotNull(alterado);
	}
	
	@Test
	public void excluir() {
		Funcionario novo = new Funcionario("Teste excluir",1000);
		Funcionario novoSalvo = funcionarioRepository.save(novo);
		funcionarioRepository.delete(novoSalvo);
		assertTrue(funcionarioRepository.findOne(novoSalvo.getId()) == null);
	}

}
