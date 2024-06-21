package day09;

class E_ThisEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student3 std1 = new Student3();
		Student3 std2 = new Student3(1,2,2,"enffl");
		

	}

}

class Student3 {
	private int grade, classNum, num;
	private String name;
	private static String schoolName="KHSchool";
	
	public String getSchoolName() {
		return schoolName;
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student3(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	public Student3() {
		this(1,1,1,"bdj");
	}
	
}
