package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.remote.NotificationResult;

import org.primefaces.component.export.ExporterFactory;

import Entidades.Candidato;
import Entidades.Eleitor;
import Entidades.Pessoa;

public class pessoaDAO {
		public boolean cadastrarEleitor(Eleitor user) throws SQLException, ClassNotFoundException{
			String verifica = "SELECT RG FROM eleitor WHERE RG='"+user.getRG()+"'";
			boolean x = false;
			try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(verifica);
			while(rs.next()){
				x = true;
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(x==false){
			String sql = "INSERT INTO eleitor(cpf, nome, end, titulo, senha, RG) VALUES(?,?,?,?,?,?)";

			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1, user.getCPF());
				prepara.setString(2, user.getNome());
				prepara.setString(3, user.getEnd());
				prepara.setInt(4, user.getTitulo());
				prepara.setString(5, user.getSenha());
				prepara.setInt(6, user.getRG());
				prepara.execute();
				prepara.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			sql = "INSERT INTO pessoa(cpf, nome, senha) VALUES(?,?,?)";

			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1, user.getCPF());
				prepara.setString(2, user.getNome());
				prepara.setString(3, user.getSenha());
				prepara.execute();
				prepara.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
			return x;
	}
		
	  public boolean verificarNum(Candidato user) throws ClassNotFoundException{
			String verifica = "SELECT num FROM candidato WHERE num='"+user.getNum()+"'";
			boolean x = false;
			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(verifica);
				while(rs.next()){
					x = true;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return x;
		}
		public boolean cadastrarCandidato(Candidato user) throws ClassNotFoundException{
			String verifica = "SELECT RG FROM candidato WHERE RG='"+user.getRG()+"'";
			boolean x = false;
			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(verifica);
				while(rs.next()){
					x = true;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(x==false){
			String sql = "INSERT INTO candidato(cpf, nome, end, titulo, senha, RG, num) VALUES(?,?,?,?,?,?,?)";

			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1, user.getCPF());
				prepara.setString(2, user.getNome());
				prepara.setString(3, user.getEnd());
				prepara.setInt(4, user.getTitulo());
				prepara.setString(5, user.getSenha());
				prepara.setInt(6, user.getRG());
				prepara.setInt(7, user.getNum());
				prepara.execute();
				prepara.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			sql = "INSERT INTO pessoa(cpf, nome, senha) VALUES(?,?,?)";

			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setInt(1, user.getCPF());
				prepara.setString(2, user.getNome());
				prepara.setString(3, user.getSenha());
				prepara.execute();
				prepara.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			sql = "INSERT INTO votacao(nome, num) VALUES(?,?)";

			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				PreparedStatement prepara = con.prepareStatement(sql);
				prepara.setString(1, user.getNome());
				prepara.setInt(2, user.getNum());
				prepara.execute();
				prepara.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
			return x;
		}
		
		
		public boolean login(Pessoa user) throws ClassNotFoundException{
			String sql = "SELECT nome, senha, cpf FROM pessoa WHERE nome='"+user.getNome()+"' AND senha='"+user.getSenha()+"'";
			Pessoa pessoa = new Pessoa();
			boolean x = false;
			try{
				ConnectionFactory.openConnection();
				Connection con = ConnectionFactory.getConnection();
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					x = true;
					user.setCPF(rs.getInt("cpf"));
				}
				return x;
			}catch(SQLException e){
				return false;
			}
		}
}
