package pe.com.maquistemas.app.service;

import java.io.Serializable;
import java.util.List;

import pe.com.maquistemas.app.model.TipoMaterial;

public interface TipoMaterialService {
	public Serializable guardar(TipoMaterial TipoMaterial);

	public TipoMaterial buscarPorId(int id);

	public boolean actualizar(TipoMaterial TipoMaterial);

	public List<TipoMaterial> listar();

	public boolean eliminar(TipoMaterial TipoMaterial);

}
