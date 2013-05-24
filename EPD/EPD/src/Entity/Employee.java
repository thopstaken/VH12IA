package Entity;

public class Employee {
	private String name;
        private String job;
        private Sex sex;

	public Employee(String name, String job, Sex sex)
	{
		this.name = name;
                this.job = job;
                this.sex = sex;
	}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setSex(Employee.Sex sex) {
        this.sex = sex;
    }

    public Employee.Sex getSex() {
        return sex;
    }

    public enum Sex
        {
            MAN, WOMAN    
        }
        
}
