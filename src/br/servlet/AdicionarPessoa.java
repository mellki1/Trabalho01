package br.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Pessoa;
import dao.PessoaDAO;

@WebServlet("/adicionaPessoa")
public class AdicionarPessoa extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String endereco = req.getParameter("endereco");
		String cidade = req.getParameter("cidade");
		String uf = req.getParameter("uf");
		
		Pessoa pessoa1 = new Pessoa();
		PessoaDAO cadPes = new PessoaDAO();
		
		pessoa1.setNome(nome);
		pessoa1.setCpf(cpf);
		pessoa1.setEndereco(endereco);
		pessoa1.setCidade(cidade);
		pessoa1.setUf(uf);
		cadPes.add(pessoa1);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Retorno Cadastro</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1> CADASTRO EFETUADO COM SUCESSO!</h1>");

		out.println("Nome: "+nome);
		out.println("<br>CPF: "+cpf);
		out.println("<br>Endereco: "+endereco);
		out.println("<br>Cidade: "+cidade);
		out.println("<br>UF: "+uf);


		out.println("</body>");
		
		out.println("</html>");
		
		
	}
}
