package pe.com.maquistemas.app;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import pe.com.maquistemas.app.config.SpringCoreConfig;
import pe.com.maquistemas.app.model.Material;
import pe.com.maquistemas.app.model.TipoMaterial;
import pe.com.maquistemas.app.service.MaterialService;

public class TestMaterial {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
			CrudMaterial crud = context.getBean(CrudMaterial.class);
			
			Material m = new Material();
			m.setId(0);
			m.setDescripcion("Acero galvanizado 3 1/2");
			
			TipoMaterial tm = new TipoMaterial();
			tm.setId(1);
			m.setTipoMaterial(tm);
			crud.crear(m);
			
			crud.listar();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

@Component
class CrudMaterial{
	@Autowired
	MaterialService materialService;
	
	final static Logger logger = Logger.getLogger(CrudMaterial.class);
	
	public void crear(Material material) {
		materialService.guardar(material);
		logger.info("creado");
	}
	
	public void listar() {
		materialService.listar().stream().forEach(x->{
			System.out.println(x);
		});
	}
	
	
}
