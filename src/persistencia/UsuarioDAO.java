package persistencia;

import java.util.List;

import negocio.Empleado;

import org.hibernate.Session;


public class UsuarioDAO {

	private static UsuarioDAO instancia;

	private UsuarioDAO() {

	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}

	public boolean validarUsuario(String usuario, String password) {
		Session s = HibernateUtil.getCurrent();
		List<Empleado> list = s.createQuery(" from Empleado e where e.nombre = ? and  e.clave = ?").setString(0, usuario).setString(1,password).list();
		if(!list.isEmpty())
			return true;
		else
			return false;
	}

}
