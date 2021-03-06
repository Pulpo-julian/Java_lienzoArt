package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexion.Conexion;
import modelo.Usuario;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DaoUsuario {
	
	private static final String SQL_SELECT = "SELECT docid, nombres, apellidos, correo FROM tblusuario;";
	
	private static final String SQL_SELECT_DOCID = "SELECT docid, nombres, apellidos, correo FROM tblusuario WHERE docid = ?;";
	
	private static final String SQL_INSERT = "INSERT INTO tblusuario VALUES(?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SQL_UPDATE = "UPDATE tblusuario SET nombres = ?, apellidos = ?, correo = ? WHERE docid = ?;";
	
	private static final String SQL_DELETE = "DELETE FROM tblusuario WHERE docid = ?;";

	
	
	public List<Usuario> listar(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String docid = rs.getString(1);
				String nombres = rs.getString(2);
				String apellidos = rs.getString(3);
				String correo = rs.getString(4);
				
				usuarios.add(new Usuario(docid, nombres, apellidos, correo));
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(rs);
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
		return usuarios;
		
	}
	
	//CRUD functions
	public Usuario buscarUsuario(String doc){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_DOCID);
			stmt.setString(1, doc);
			rs = stmt.executeQuery();
			
			rs.next();
			String docid = rs.getString(1);
			String nombres = rs.getString(2);
			String apellidos = rs.getString(3);
			String correo = rs.getString(4);
			
			usuario = new Usuario(docid, nombres, apellidos, correo);
				
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(rs);
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
		return usuario;
		
	}

	public void insertarUsuario(String docid, String nombres, String apellidos, 
			String correo, int perfil, String clave, String telefono,
			String ciudad, String codigoPost, String direccion) {
		
		Connection conn = null;
		PreparedStatement stmt = null;

		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, docid);
			stmt.setString(2, nombres);
			stmt.setString(3, apellidos);
			stmt.setString(4, correo);
			stmt.setInt(5, perfil);
			stmt.setString(6, clave);
			stmt.setString(7, telefono);
			stmt.setString(8, ciudad);
			stmt.setString(9, codigoPost);
			stmt.setString(10, direccion);
			
			stmt.executeUpdate();
	

			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}

		
	}
	
	public void actualizarUsuario(String docid ,String nombres, String apellidos, String correo) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, nombres);
			stmt.setString(2, apellidos);
			stmt.setString(3, correo);
			stmt.setString(4, docid);
			stmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
	}
	
	public void borrarUsuario(String docid) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, docid);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}
		
	}
	
	
	
	
}
