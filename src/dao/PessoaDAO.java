package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import classes.Pessoa;

public class PessoaDAO{
	public java.sql.Connection conexao;
	
	public PessoaDAO() throws ServletException{
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
	}
	
	public void add(Pessoa pessoa){
		String sql = "insert into pessoa(nome, cpf, endereco, cidade, estado)" + "values(?,?,?,?,?)";
	
		try {
			PreparedStatement par = conexao.prepareStatement(sql);
			
			par.setString(1, pessoa.getNome());
			par.setString(2, pessoa.getCpf());
			par.setString(3, pessoa.getEndereco());
			par.setString(4, pessoa.getCidade());
			par.setString(5, pessoa.getUf());
			
			par.execute();
			par.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void aleterar(Pessoa pessoa){
		String sql = "update pessoa set nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ? where id = ?";
		try{
			PreparedStatement par = conexao.prepareStatement(sql);
			
			par.setString(1, pessoa.getNome());
			par.setString(2, pessoa.getCpf());
			par.setString(3, pessoa.getEndereco());
			par.setString(4, pessoa.getCidade());
			par.setString(4, pessoa.getUf());
			par.execute();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void excluir(Pessoa pessoa){
		String sql = "DELETE FROM `pessoa` WHERE `pessoa`.`id` = ?";
		try{
			PreparedStatement par = conexao.prepareStatement(sql);
			System.out.println(pessoa.getId());
			par.setInt(1, pessoa.getId());
			par.execute();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public List<Pessoa> buscarTodos(){
		List<Pessoa> listarPessoas = new ArrayList<>();
		
		String sql = "Select * from pessoa";
		Pessoa pessoa = null ;
		
		try(PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			
			ResultSet result = preparedStatement.executeQuery();
			
			
			while(result.next()){
				pessoa = new Pessoa();
				pessoa.setId(result.getInt("id"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setEndereco(result.getString("endereco"));
				pessoa.setCidade(result.getString("cidade"));
				pessoa.setUf(result.getString("uf"));
				
				listarPessoas.add(pessoa);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return listarPessoas;
	}
}
