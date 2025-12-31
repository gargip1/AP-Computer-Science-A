class StudentId
  {
    String studentFirstName;
    String studentLastName;
    int studentId;

    public StudentId()
    {
      studentFirstName = "First";
      studentLastName = "Last";
      studentId = 111111;
    }

    public StudentId(String inputFirstName, String inputLastName, int inputStudentId)
    {
      studentFirstName = inputFirstName;
      studentLastName = inputLastName;
      studentId = inputStudentId;
    }

    public void setFirstName(String inputFirstName) 
    {
      studentFirstName = inputFirstName;
    }
    
     public void setLastName(String inputLastName) 
    {
      studentLastName = inputLastName;
    }

     public void setStudentId(int inputStudentId) 
    {
      studentId = inputStudentId;
    }

     public String getFirstName() 
    {
      return studentFirstName;
    }
    
     public String getLastName() 
    {
      return studentLastName;
    }

     public int getStudentId() 
    {
      return studentId;
    }

    public String getPassword()
    {
      char firstChar = studentLastName.charAt(0);
      char lastChar = studentLastName.charAt(studentLastName.length());
      String stringId = String.valueOf(studentId);
      return firstChar + stringId + lastChar;
    }

    public String toString()
    {
      return "Name = " + studentFirstName +" " + studentLastName + "\nStudent Id = "+studentId;
    }
  }
