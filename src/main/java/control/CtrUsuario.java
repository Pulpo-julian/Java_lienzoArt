package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoUsuario;

/**
 * Servlet implementation class CtrUsuario
 */

@WebServlet("/formulario")
public class CtrUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> errores = new HashMap<String, String>();
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String ciudad = request.getParameter("ciudades");
		String codigoPostal = request.getParameter("codigoPostal");
		String direccion = request.getParameter("direccion");
		
		if(cedula == null || cedula.isBlank() || cedula.isEmpty()) {
			errores.put("cedula", "debe escribir la cedula");
		}
		
		if(cedula == null || nombre.isBlank() || nombre.isEmpty()) {
			errores.put("nombre", "debe escribir el nombre");
		}
		
		if(apellidos == null || apellidos.isBlank() || apellidos.isEmpty()) {
			errores.put("apellidos", "debe escribir los apellidos");
		}
	
		if(correo == null || correo.isBlank() || !correo.contains("@") || correo.isEmpty()) {
			errores.put("correo", "debe escribir un correo que contenga un \"@\"");
		}
		
		
		if(correo == null || password.isBlank() || password.isEmpty()) {
			errores.put("password", "debe ingresar una contraseña");
		}
		
		if(telefono == null || telefono.isBlank() || password.isEmpty()) {
			errores.put("telefono", "debe ingresar el telefono");
		}
		
		if(ciudad == null || ciudad.isBlank() || password.isEmpty()) {
			errores.put("ciudades", "debe elegir su ciudad de residencia");
		}
		
		if(codigoPostal == null || codigoPostal.isBlank() || codigoPostal.isEmpty()) {
			errores.put("codigoPostal", "debe ingresar el codigo postal");
		}
		
		if(direccion == null || direccion.isBlank() || direccion.isEmpty()) {
			errores.put("direccion", "debe ingresar su direccion");
		}
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		if(errores.size() ==  0) {
			
			try {
				
				daoUsuario.insertarUsuario(cedula, nombre, apellidos, correo, 3, password, telefono, ciudad, codigoPostal, direccion);
				
			} catch (Exception e) {
				
				e.printStackTrace(System.out);
				
			}
			
			
			
			
		}
		
		
		
		request.setAttribute("errores", errores);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		/*
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(428);
		numeros.add(1250);
		numeros.add(569320);
		numeros.add(2036);
		numeros.add(98410);
		
		request.setAttribute("listNumeros", numeros);
		
		
		
		getServletContext().getRequestDispatcher("/usuarioFormulario.jsp").forward(request, response);
		*/

		
		//doGet(request, response);
	}

}
