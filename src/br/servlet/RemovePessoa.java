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


@WebServlet("/removePessoa")
public class RemovePessoa extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String endereco = req.getParameter("endereco");
		String cidade = req.getParameter("cidade");
		String uf = req.getParameter("uf");

		Pessoa pessoa1 = new Pessoa();
		PessoaDAO cadPes = new PessoaDAO();
		
		pessoa1.setId(id1);
		cadPes.excluir(pessoa1);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Retorno Exclusão</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1> EXLUSÃO DO USUÁRIO " + id + " CONCLUIDA COM SUCESSO!</h1>");

		
		out.println("<br>FOI EXCLUIDO DA BASE DE DADOS.");


		out.println("</body>");
		
		out.println("</html>");
		
		
	}
}
