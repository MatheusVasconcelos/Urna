package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidades.Candidato;
import Entidades.Pessoa;
import Entidades.Votacao;
import Entidades.Voto;

public class urnaDAO {
	public String cadastrarVoto(Voto user, Candidato cand, Pessoa pessoa) throws SQLException, ClassNotFoundException{
		String retorno = "";
		String verifica = "SELECT num FROM candidato WHERE num='"+user.getNum()+"'";
		boolean x = false;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(verifica);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				x = true;
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(x==true){
		String sql = "INSERT INTO quemvotou (titulo) VALUES(?)";
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			PreparedStatement prepara = con.prepareStatement(sql);
			prepara.setInt(1, pessoa.getCPF());
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		sql = "INSERT INTO voto(num, branco, nulo) VALUES(?,?,?)";
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			PreparedStatement prepara = con.prepareStatement(sql);
			prepara.setInt(1, user.getNum());
			prepara.setString(2, user.getBranco());
			prepara.setString(3, user.getNulo());
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		sql = "SELECT nome FROM candidato WHERE num='"+user.getNum()+"'";
		String x1 = "";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				x1 = rs.getString("nome");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		sql = "INSERT INTO votacao(nome, num) VALUES(?,?)";
		try{
			ConnectionFactory.openConnection();
			Connection con1 = ConnectionFactory.getConnection();
			Statement stm = con1.createStatement();
			PreparedStatement prepara = con1.prepareStatement(sql);
			prepara.setString(1, x1);
			prepara.setInt(2, user.getNum());
			prepara.execute();
			prepara.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		retorno = "votou";
		}
		if(x==false){
			retorno = "candidatonaoexiste";
		}
		return retorno;
	}
	
	public static List<Votacao> cadastrarVotacao() throws ClassNotFoundException{
		String sql = "SELECT nome, num, count(num) as total FROM votacao WHERE nome!='' AND num!=0 GROUP BY num ORDER BY total DESC";
		int x  = 0;
		List<Votacao> votacao = new ArrayList<Votacao>();
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Votacao vot = new Votacao();
				vot.setNome(rs.getString("nome"));
				vot.setTotal(rs.getInt("total")-1);
				vot.setNum(rs.getInt("num"));
				votacao.add(vot);
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		return votacao;
	}
	
	public String maisVotado() throws ClassNotFoundException{
		String sql = "SELECT num, count(num) as total FROM voto WHERE num!=''GROUP BY num ORDER BY total DESC LIMIT 2";
		int[] x  = new int[2];
		int[] s = new int[2];
		String nome = "";
		int i  = 0;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				x[i] = rs.getInt("num");
				s[i] = rs.getInt("total");
				i++;
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		sql = "SELECT nome FROM Candidato WHERE num='"+x[0]+"'";
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nome = rs.getString("nome");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		if(s[1] == s[0]){
			nome="";
		}
		return nome;
	}
	
	public String menosVotado() throws ClassNotFoundException{
		String sql = "SELECT num, count(num) as total FROM voto WHERE num!='' GROUP BY num ORDER BY total ASC LIMIT 2";
		int[] x  = new int[2];
		String nome = "";
		int i = 0;
		int[] s = new int[2];
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				x[i] = rs.getInt("num");
				s[i] = rs.getInt("total");
				i++;
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		sql = "SELECT nome FROM Candidato WHERE num='"+x[0]+"'";
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nome = rs.getString("nome");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		if(s[1] == s[0]){
			nome="";
		}
		return nome;
	}
	
	public int votosBrancos() throws ClassNotFoundException{
		String sql = "SELECT num FROM voto WHERE branco='V'";
		int row = 0;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				row++;
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		return row;
	}
	
	public int eleitores() throws ClassNotFoundException{
		String sql = "SELECT nome FROM eleitor";
		int row = 0;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				row++;
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		return row;
	}
	
	public int votosNulos() throws ClassNotFoundException{
		String sql = "SELECT num FROM voto WHERE nulo='V'";
		int row = 0;
		try{
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				row++;
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		return row;
	}
	
	public String candidatoEleito(Votacao voto) throws ClassNotFoundException{
		 String sql = "SELECT count(*) as total FROM votacao";
		 int row = 0;
		 int count = 0;
		 String nome = "";
		 try{
			 ConnectionFactory.openConnection();
			 Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 row = rs.getInt("total");
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 sql = "SELECT nome, count(num) as total FROM votacao WHERE num!=''GROUP BY num ORDER BY total DESC LIMIT 1";
		 try{
			 ConnectionFactory.openConnection();
			 Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 nome = rs.getString("nome");
				 count = rs.getInt("total");
				 
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 if(count > (row/2)){
			 return nome;
		 }else{
			 return "";
		 }
	}
	
	public List<Votacao> segundoTurno() throws ClassNotFoundException{
		String sql = "SELECT count(*) as total FROM votacao";
		int row = 0;
		int total = 0;
		List<Votacao> segundoTurno = new ArrayList<Votacao>();
		try{
			 ConnectionFactory.openConnection();
			 Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 row = rs.getInt("total");
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		sql = "SELECT nome, count(num) as total FROM votacao WHERE num!=''GROUP BY num ORDER BY total DESC LIMIT 1";
		try{
			 ConnectionFactory.openConnection();
			 Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 total = rs.getInt("total");
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(total <= row/2){
			sql = "SELECT nome, count(num) as total FROM votacao WHERE num!=''GROUP BY num ORDER BY total DESC LIMIT 2";
			try{
				 ConnectionFactory.openConnection();
				 Connection con = ConnectionFactory.getConnection();
				 PreparedStatement ps = con.prepareStatement(sql);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()){
					 	Votacao vot = new Votacao();
						vot.setNome(rs.getString("nome"));
						segundoTurno.add(vot);
				 }
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return segundoTurno;
	}
	
	
}	
