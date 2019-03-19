package pe.com.maquistemas.app.config;

import pe.com.maquistemas.app.dao.EmployeeDao;
import pe.com.maquistemas.app.dao.UserManagementDAO;
import pe.com.maquistemas.app.dao.UserManagementDAOImpl;
import pe.com.maquistemas.app.dao.impl.EmployeeDaoImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"pe.com.maquistemas.app"})
public class SpringCoreConfig {

    @Bean
    public UserManagementDAO userManagementDAO() {
        return new UserManagementDAOImpl();
    }
    
//    @Bean
//    public EmployeeDao employeeDao() {
//        return new EmployeeDaoImpl();
//    }

    
}
