package pe.com.maquistemas.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	
@Table(name="tipo_materiales")
public class TipoMaterial implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	@Column(name="descripcion", length=200)
	private String descripcion;
	
	@OneToMany(mappedBy="tipoMaterial")
	private List<Material> materiales;
	
	
	
	
	
	
	
	
//	
//	public TipoMaterial(Integer id, String descripcion) {
//		this.id = id;
//		this.descripcion = descripcion;
//	}


















	public Integer getId() {
		return id;
	}









	@Override
	public String toString() {
		return "TipoMaterial [id=" + id + ", descripcion=" + descripcion + "]";
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









	public List<Material> getMateriales() {
		return materiales;
	}









	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}









	private static final long serialVersionUID = -131109214676211117L;

}
	