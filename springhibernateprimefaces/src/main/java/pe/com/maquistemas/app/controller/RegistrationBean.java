package pe.com.maquistemas.app.controller;

import pe.com.maquistemas.app.CrudEmpleado;

import pe.com.maquistemas.app.config.SpringCoreConfig;
import pe.com.maquistemas.app.dao.EmployeeDao;
import pe.com.maquistemas.app.dao.UserManagementDAO;
import pe.com.maquistemas.app.model.Empleado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "registration")
@ViewScoped
public class RegistrationBean implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationBean.class);

    @ManagedProperty(value = "#{userManagementDAO}")
    transient private UserManagementDAO userDao;
//    @ManagedProperty(value = "#{employeeDao}")
//    transient private EmployeeDao employeeDao;
    private String userName;
    private String operationMessage;
    
    
    
    
    public List<Empleado> empleados(){
    	
    	 AnnotationConfigApplicationContext contexta = null;
 		try {
 			contexta = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
 			CrudEmpleado application = contexta.getBean(CrudEmpleado.class);

 			return application.listar();
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 			return null;
 		} finally {
 			contexta.close();
 		}
    	
    }
    
    
    
    
    public void createNewUser() {
        try {
            LOGGER.info("Creating new user");
            FacesContext context = FacesContext.getCurrentInstance();
            /*boolean operationStatus = userDao.createUser(userName);
            context.isValidationFailed();
            if (operationStatus) {
                operationMessage = "User " + userName + " created";
            }*/
            
//            Empleado empById = employeeDao.buscarPorId(1);
//            System.out.println(">>>>>>>>>>"+empById.getApellidos());
//            LOGGER.info("Empleado: " + empById);
            
            
            
            
            
            AnnotationConfigApplicationContext contexta = null;
    		try {
    			contexta = new AnnotationConfigApplicationContext(SpringCoreConfig.class);
    			CrudEmpleado application = contexta.getBean(CrudEmpleado.class);
//
//    			//application.procesarCrud();
    			System.out.println(application.getEmpleadobyID(1).getApellidos());
    			
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			contexta.close();
    		}
            
            
            
            
            
            
            
            
            
            
            
        } catch (Exception ex) {
            LOGGER.error("Error registering new user ");
            ex.printStackTrace();
            operationMessage = "Error " + userName + " not created";
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserDao(UserManagementDAO userDao) {
        this.userDao = userDao;
    }

    public UserManagementDAO getUserDao() {
        return this.userDao;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

//	public EmployeeDao getEmployeeDao() {
//		return employeeDao;
//	}
//
//	public void setEmployeeDao(EmployeeDao employeeDao) {
//		this.employeeDao = employeeDao;
//	}
    
    
    
    
}
