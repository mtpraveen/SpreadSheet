package javabeat.spring.hibernate;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class SpringHibernateTest {

    public static void main(String[] args) {

        Resource resource = new FileSystemResource(
            "./src/main/resources/beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("ABC");
        employee.setAge(20);
        employee.setSalary(15000.00d);

        EmployeeDao employeeDao = (EmployeeDao)factory.getBean(
            "EmployeeDao");
        employeeDao.saveOrUpdate(employee);

        Employee empResult = employeeDao.getEmployee("123");
        System.out.println(empResult);
    }
}