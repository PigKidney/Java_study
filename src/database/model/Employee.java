package database.model;

public class Employee {
	// DB로부터 null이 나올수도 있으므로 기본타입보다는 Wrapper 클래스를 사용하는것이 좋다
	Integer employee_id;
	String first_name;
	String last_name;
	String email;
	String phone_number;
	String HIRE_DATE;
	String JOB_ID;
	Integer SALARY;
	Double COMMISSION_PCT;
	Integer MANAGER_ID;
	Integer DEPARTMENT_ID;

	public Employee(
			Integer employee_id, 
			String first_name, 
			String last_name, 
			String email, 
			String phone_number,
			String HIRE_DATE, 
			String JOB_ID, 
			Integer SALARY, 
			Double COMMISSION_PCT, 
			Integer MANAGER_ID,
			Integer DEPARTMENT_ID) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.HIRE_DATE = HIRE_DATE;
		this.JOB_ID = JOB_ID;
		this.SALARY = SALARY;
		this.COMMISSION_PCT = COMMISSION_PCT;
		this.MANAGER_ID = MANAGER_ID;
		this.DEPARTMENT_ID = DEPARTMENT_ID;

	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s %s %s %s %d %f %d %d",
		employee_id,
		first_name,
		last_name,
		email, 
		phone_number,
		HIRE_DATE,
		JOB_ID,
		SALARY,
		COMMISSION_PCT,
		MANAGER_ID,
		DEPARTMENT_ID);
	}
}
