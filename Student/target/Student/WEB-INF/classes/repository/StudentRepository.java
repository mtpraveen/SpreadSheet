@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
  
  @Query("select s from Student s where s.userName = :userName")
  Student findByUserName(@Param("userName") String userName);
  
}
