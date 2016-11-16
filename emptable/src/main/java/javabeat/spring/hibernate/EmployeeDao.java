package javabeat.spring.hibernate;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate
                             hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    public Employee getEmployee(final String id){
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session)
                throws HibernateException,SQLException {
                return session.load(Employee.class, id);
            }
        };
        return (Employee)hibernateTemplate.execute(callback);
    }

    public void saveOrUpdate(final Employee employee){
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session)
                throws HibernateException,SQLException {
                session.saveOrUpdate(employee);
                return null;
            }
        };
        hibernateTemplate.execute(callback);
    }
}