package pe.com.maquistemas.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Ing. Ronald Angulo
 * 
 */
@Entity
@Table(name = "empleado")

// Named Queries Hibernate Query Language or Java Persistence Query Language(HQL
// or JPQL )
@NamedQueries({ 
	@NamedQuery(name = "empleado.buscarTodos", query = "from Empleado e"),
	@NamedQuery(name = "empleado.buscarPorId", query = "from Empleado e where e.id = :pId")
})

// Named Native Queries (SQL)
@NamedNativeQueries({
		@NamedNativeQuery(name = "empleado.nativeBuscarTodos", query = "select id, nombres, apellidos, cargo, salario from empleado e"),
		@NamedNativeQuery(name = "empleado.nativeBuscarPorId", query = "select id, nombres, apellidos, cargo, salario from empleado e where e.id = :pId") })

public class Empleado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2156709172557536871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "nombres", length = 50)
	private String nombres;

	@Column(name = "apellidos", length = 50)
	private String apellidos;

	@Column(name = "cargo", length = 50)
	private String cargo;

	@Column(name = "salario")
	private Integer salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}

}
