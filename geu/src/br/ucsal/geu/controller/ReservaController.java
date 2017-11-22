package br.ucsal.geu.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.EspacoDAO;
import br.ucsal.geu.dao.ReservaDAO;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Reserva;

@WebServlet("/reservas")
public class ReservaController extends HttpServlet {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String q = request.getParameter("q");
		if(q != null && q.equals("new")) {
			EspacoDAO dao = new EspacoDAO();
			request.setAttribute("listaespaco", dao.listar());
			request.getRequestDispatcher("reservaform.jsp").forward(request, response);
		} else {
			ReservaDAO dao = new ReservaDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String justificativa = request.getParameter("justificativa");
		String solicitante = request.getParameter("solicitante");
		String telefone = request.getParameter("telefone");
		String data = request.getParameter("data");
		String horaInicio = request.getParameter("inicio");
		String horaFim = request.getParameter("fim");
		String espacoID = request.getParameter("espaco");

		Reserva reserva = new Reserva();
		reserva.setTitulo(titulo);
		reserva.setDescricao(descricao);
		reserva.setJustificativa(justificativa);
		reserva.setSolicitante(solicitante);
		reserva.setTelefone(telefone);
		reserva.setData(LocalDate.parse(data, dateFormat));
		reserva.setHoraInicio(LocalTime.parse(horaInicio, timeFormat));
		reserva.setHoraFim(LocalTime.parse(horaFim, timeFormat));
		EspacoDAO espacoDAO = new EspacoDAO();
		int id = Integer.parseInt(espacoID);
		Espaco espaco = espacoDAO.getByID(id);
		reserva.setEspaco(espaco);
		
		ReservaDAO dao = new ReservaDAO();
		dao.inserir(reserva);
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("reservalist.jsp").forward(request, response);
		
	}

}
