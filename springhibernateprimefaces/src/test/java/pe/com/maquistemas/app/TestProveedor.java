package pe.com.maquistemas.app;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import pe.com.maquistemas.app.config.SpringCoreConfig;
import pe.com.maquistemas.app.model.Proveedor;
import pe.com.maquistemas.app.service.ProveedorService;

public class TestProveedor {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
			CrudProveedor crud = context.getBean(CrudProveedor.class);
			
			Proveedor p = new Proveedor();
			p.setDescripcion("Acerisa");
			crud.crear(p);
			crud.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

@Component
class CrudProveedor{
	@Autowired
	ProveedorService proveedorService;
	
	final static Logger logger = Logger.getLogger(CrudProveedor.class);
	
	public void crear(Proveedor proveedor) {
		proveedorService.guardar(proveedor);
		logger.info("creado");
	}
	
	public void listar() {
		proveedorService.listar().stream().forEach(x->{
			System.out.println(x);
		});
	}
	
	
}
