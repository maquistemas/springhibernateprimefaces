package pe.com.maquistemas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	@Column(name="descripcion", length=200)
	private String descripcion;
	
	@OneToOne(mappedBy="proveedor")
	private MaterialProveedor materialProveedor;
	
	public void setMaterialProveedor(MaterialProveedor materialProveedor) {
		if (materialProveedor == null) {
			if(this.materialProveedor != null) {
				this.materialProveedor.setProveedor(null);
			}
		} else {
			this.materialProveedor.setProveedor(this);
		}
		this.materialProveedor = materialProveedor;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MaterialProveedor getMaterialProveedor() {
		return materialProveedor;
	}

	
	
	
	
	



	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", descripcion=" + descripcion + "]";
	}









	private static final long serialVersionUID = 1319087690684252115L;

}
