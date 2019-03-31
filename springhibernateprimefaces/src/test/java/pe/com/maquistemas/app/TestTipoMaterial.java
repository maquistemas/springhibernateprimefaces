package pe.com.maquistemas.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import pe.com.maquistemas.app.config.SpringCoreConfig;
import pe.com.maquistemas.app.model.TipoMaterial;
import pe.com.maquistemas.app.service.TipoMaterialService;


public class TestTipoMaterial {
	
//	final static Logger logger = Logger.getLogger(TestTipoMaterial.class);
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
			CrudTestTipoMaterial crud = context.getBean(CrudTestTipoMaterial.class);
			
			/*TipoMaterial tm = new TipoMaterial();
			tm.setId(1);
			tm.setDescripcion("Acero");
			tm.setMateriales(null);
			crud.crear(tm);*/
			
			crud.listar();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


@Component
class CrudTestTipoMaterial{
	@Autowired
	TipoMaterialService tipoMaterialService;
	
	final static Logger logger = Logger.getLogger(CrudTestTipoMaterial.class);
	
	public void crear(TipoMaterial tipoMaterial) {
		tipoMaterialService.guardar(tipoMaterial);
		logger.info("creado");
	}
	
	public  void listar() {
		logger.info("listar");
		tipoMaterialService.listar().stream().forEach(x->{
			System.out.println(x);
		});
		
	}
	
}

