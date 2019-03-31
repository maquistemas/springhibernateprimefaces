package pe.com.maquistemas.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.maquistemas.app.model.Empleado;
import pe.com.maquistemas.app.model.TipoMaterial;
import pe.com.maquistemas.app.service.EmpleadoService;
import pe.com.maquistemas.app.service.TipoMaterialService;

/**
 * 
 * @author John
 *
 */
@Component
public class CrudEmpleado {

	final static Logger logger = Logger.getLogger(CrudEmpleado.class);

	@Autowired
	private EmpleadoService empService;
	
	@Autowired
	TipoMaterialService tipoMaterialService;
	
	public void crear(TipoMaterial tipoMaterial) {
		logger.info("crear: ");
		tipoMaterialService.guardar(tipoMaterial);
		logger.info("creado: ");
	}
	
	public  void listarTipoMaterial() {
		tipoMaterialService.listar().stream().forEach(x->{
			x.getDescripcion();
		});
	}
	
	
	
	
	public Empleado getEmpleadobyID(int id) {
		Empleado empById = empService.buscarPorId(id);
		logger.info("Empleado: " + empById);
		return empById;
	}
	
	public void registrar(Empleado empleado) {
		empService.guardar(empleado);
	}
	
	public void eliminar(Empleado empleado) {
		empService.eliminar(empleado);
	}
	
	public List<Empleado> listar(){
		return empService.listar();
	}
	
	
	
	public void procesarCrud()
	{
		logger.info("Nuevo Empleado:");
		Empleado empleado = new Empleado();
		empleado.setApellidos("Verastegui");
		empleado.setNombres("raul");
		empleado.setCargo("Moza");
		empleado.setSalario(1500);
		
//		if (empService.guardar(empleado)) {
//			logger.info("Empleado guardado con exito.");
//		}else{
//			logger.info("No se pudo guardar el empleado.");
//		}
		
		Empleado empById = empService.buscarPorId(1);
		logger.info("Empleado: " + empById);
		
		//empById.setSalario(3000);
//		if (empService.actualizar(empById)) {
//			logger.info("Actualizado correctamente.");
//		}else{
//			logger.info("No se pudo actualizar.");
//		}
		
		
//		Empleado empEliminar = empService.buscarPorId(4);
//		logger.info("Empleado a eliminar: " + empEliminar);
		
//		if (empService.eliminar(empEliminar)) {
//			logger.info("Eliminado correctamente.");
//		}else{
//			logger.info("No se pudo eliminar.");
//		}
		
		List<Empleado> lstEmpleado = empService.listar();
		logger.info("Empleados: " + lstEmpleado.size());
		for (Empleado emp : lstEmpleado) {
			logger.info(emp.toString());
		}
		
		
		
		

	}

}
