package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Reserva;
import br.ucsal.geu.model.Tipo;
import br.ucsal.util.Conexao;

public class ReservaDAO {
	
	private Conexao conexao;
	
	public ReservaDAO() {
		this.conexao = Conexao.getConexao();
	}
	
	public List<Reserva> ListLazy() {
		Statement stmt;
		List<Reserva> reserva = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,titulo,descricao,justificativa,solicitante,telefone,data,hora_inicio,hora_fim,espaco_id\n" + 
					" from reservas");
			while(rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setTitulo(rs.getString("titulo"));
				r.setDescricao(rs.getString("descricao"));
				r.setJustificativa(rs.getString("justificativa"));
				r.setSolicitante(rs.getString("solicitante"));
				r.setTelefone(rs.getString("telefone"));
				r.setData(rs.getDate("data").toLocalDate());
				r.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
				r.setHoraFim(rs.getTime("hora_fim").toLocalTime());
				
				Espaco espaco = new Espaco();
				espaco.setId(rs.getInt("espaco_id"));
				r.setEspaco(espaco);
				
				reserva.add(r);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
	}
	
	public List<Reserva> listar() {
		Statement stmt;
		List<Reserva> reservas = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select reservas.id,titulo,descricao,justificativa,solicitante,telefone,data,hora_inicio,hora_fim,espaco_id,identificacao,andar,bloco_id,nome,letra,latitude,longitude,tipo_id,tipos.nome as nometipo, tipos.descricao \n" + 
					"from reservas,espacos,blocos,tipos \n" + 
					"where reservas.espaco_id = espacos.id and espacos.bloco_id = blocos.id and espacos.tipo_id = tipos.id");
			while(rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setTitulo(rs.getString("titulo"));
				r.setDescricao(rs.getString("descricao"));
				r.setJustificativa(rs.getString("justificativa"));
				r.setSolicitante(rs.getString("solicitante"));
				r.setTelefone(rs.getString("telefone"));
				r.setData(rs.getDate("data").toLocalDate());
				r.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
				r.setHoraFim(rs.getTime("hora_fim").toLocalTime());
				Espaco e = new Espaco();
				e.setId(rs.getInt("id"));
				e.setIdentificacao(rs.getString("identificacao"));
				e.setAndar(rs.getString("andar"));
				
				Bloco b = new Bloco();
				b.setId(rs.getInt("bloco_id"));
				e.setBloco(b);
				
				Tipo t = new Tipo();
				t.setId(rs.getInt("tipo_id"));
				e.setTipo(t);
				
				r.setEspaco(e);
				
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public void inserir(Reserva reserva) {
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into Reservas (titulo,descricao,justificativa,solicitante,telefone,data,hora_inicio,hora_fim,espaco_id) values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1, reserva.getTitulo());
			ps.setString(2, reserva.getDescricao());
			ps.setString(3, reserva.getJustificativa());
			ps.setString(4, reserva.getSolicitante());
			ps.setString(5, reserva.getTelefone());
			ps.setDate(6, java.sql.Date.valueOf(reserva.getData()));
			ps.setTime(7, java.sql.Time.valueOf(reserva.getHoraInicio()));
			ps.setTime(8, java.sql.Time.valueOf(reserva.getHoraFim()));
			ps.setInt(9, reserva.getEspaco().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
