package pe.com.maquistemas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="materiales_proveedores")
public class MaterialProveedor implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="idmaterial")
	private Material material;
	
	@OneToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "MaterialProveedor [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + ", material="
				+ material + ", proveedor=" + proveedor + "]";
	}





	private static final long serialVersionUID = 6029152973733050935L;

	
	
	
}
