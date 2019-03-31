package pe.com.maquistemas.app;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import pe.com.maquistemas.app.config.SpringCoreConfig;
import pe.com.maquistemas.app.model.Material;
import pe.com.maquistemas.app.model.MaterialProveedor;
import pe.com.maquistemas.app.model.Proveedor;
import pe.com.maquistemas.app.service.MaterialProveedorService;

public class TestMaterialProveedor {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
			CrudMaterialProveedor crud = context.getBean(CrudMaterialProveedor.class);
			
			MaterialProveedor mp = new MaterialProveedor();
			mp.setId(0);
			mp.setDescripcion("Titan");
			mp.setPrecio(100.25);
			Material m = new Material();
			m.setId(1);
			mp.setMaterial(m);
			Proveedor p = new Proveedor();
			p.setId(1);
			mp.setProveedor(p);
			crud.crear(mp);
			crud.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}


@Component
class CrudMaterialProveedor{
	@Autowired
	MaterialProveedorService materialProveedorService;
	
	final static Logger logger = Logger.getLogger(CrudMaterialProveedor.class);
	public void crear(MaterialProveedor materialProveedor) {
		materialProveedorService.guardar(materialProveedor);
		logger.info("creado");
	}
	
	public void listar() {
		logger.info("listar");
		materialProveedorService.listar().stream().forEach(x->{
			System.out.println(x);
		});
		
	}
}