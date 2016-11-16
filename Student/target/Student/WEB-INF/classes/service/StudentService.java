package service;
public interface StudentService {
  Student save(Student student);
  boolean findByLogin(String userName, String password);
  boolean findByUserName(String userName);
}