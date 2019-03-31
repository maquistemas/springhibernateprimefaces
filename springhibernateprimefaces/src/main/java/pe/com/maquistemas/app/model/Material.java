package pe.com.maquistemas.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="materiales")
public class Material implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	@Column(name="descripcion", length=200)
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="idtipomaterial")
	private TipoMaterial tipoMaterial;
	
	@OneToOne(mappedBy="material" /*,cascade = CascadeType.ALL*/ /*,fetch = FetchType.LAZY, optional = false*/)
	private MaterialProveedor materialProveedor;
	
	public void setMaterialProveedor(MaterialProveedor materialProveedor) {
		if (materialProveedor == null) {
			if (this.materialProveedor != null) {
				this.materialProveedor.setMaterial(null);
			}
		} else {
			this.materialProveedor.setMaterial(this);
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



	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}


	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}


	public MaterialProveedor getMaterialProveedor() {
		return materialProveedor;
	}


	


	












	@Override
	public String toString() {
		return "Material [id=" + id + ", descripcion=" + descripcion + ", tipoMaterial=" + tipoMaterial + "]";
	}


















	private static final long serialVersionUID = 6957638739731714862L;

}
