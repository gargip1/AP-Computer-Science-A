public class Main {
  public static void main(String[] args){
    StudentId student1 = new StudentId();
    System.out.println(student1);

    student1.setFirstName("Ada");
    student1.setLastName("Lovelace");
    student1.setStudentId(223344);
    System.out.println(student1);

    StudentId student2 = new StudentId("Buzz", "Lightyear", 123456);
    System.out.println(student2);

  }
}
