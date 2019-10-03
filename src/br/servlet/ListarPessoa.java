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

@WebServlet("/main")
public class ListarPessoa extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		Pessoa pessoa1 = new Pessoa();
		PessoaDAO cadPes = new PessoaDAO();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Retorno Cadastro</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1> LISTA DE PESSOAS</h1>");
		out.println("<p>"+cadPes.buscarTodos()+"</p>");


		out.println("</body>");
		
		out.println("</html>");
		
		
	}
}
