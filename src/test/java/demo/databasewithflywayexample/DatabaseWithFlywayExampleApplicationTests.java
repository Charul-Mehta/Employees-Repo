package demo.databasewithflywayexample;


import com.zemoso.dao.DepartmentsDAO;
import com.zemoso.dao.EmployeeDAO;
import com.zemoso.entities.Department;
import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;
import com.zemoso.service.DepartmentsService;
import com.zemoso.service.EmployeeService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DatabaseWithFlywayExampleApplicationTests {

	//DepartmentsService departmentsService=Mockito.mock(DepartmentsService.class);
	@Mock
	DepartmentsDAO departmentsDAO;

	@Mock
	EmployeeDAO employeeDAO;

//	@Test
//	void contextLoads() {
//		DepartmentsService departmentsService=mock(DepartmentsService.class);
//		DepartmentsDAO repo= mock(DepartmentsDAO.class);
//
//
//		List<Department> list=departmentsService.getDepts();
//		Assert.assertEquals(list.stream().count(),0);
//
//		departmentsService.saveDept("first dept");
//		list=departmentsService.getDepts();
//		Assert.assertEquals(list.stream().count(),1);
//	}

	@Test
	void departmentServiceTest(){
		assertNotNull(departmentsDAO);
		DepartmentsService departmentsService=new DepartmentsService(departmentsDAO);
		List<Department> list=departmentsService.getDepts();
		Assert.assertEquals(list.stream().count(),0);
		departmentsDAO.save(new Department("first"));
		list=departmentsService.getDepts();
		Assert.assertEquals(list.stream().count(),1);
		//Assert.assertEquals(departmentsService.saveDept("first dept").getName(),"first dept");

	}

	@Test
	void saveDepartmentTest(){
		DepartmentsService departmentsService=new DepartmentsService(departmentsDAO);
		departmentsService.saveDept("first dept");
		Mockito.verify(departmentsDAO).save(Mockito.any(Department.class));
	}

	@Test
	void getDepartmentTest(){
		DepartmentsService departmentsService=new DepartmentsService(departmentsDAO);
		List<Department> list=departmentsService.getDepts();
		Mockito.verify(departmentsDAO).findAll();
	}

	@Test
	void getDeptsByIdTest() throws NotFoundException {
		DepartmentsService departmentsService=new DepartmentsService(departmentsDAO);
		Optional<Department> dept= Optional.of(new Department());
		when(departmentsDAO.findById(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"))).thenReturn(dept);
		departmentsService.getDeptsById(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"));
		verify(departmentsDAO).findById(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"));
	}

	@Test
	void updateEmployeeTest() throws NotFoundException {

		EmployeeService employeeService=new EmployeeService(employeeDAO);
		Optional<Employee> emp= Optional.of(new Employee(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"), "myName",100));
		Employee emp1=new Employee(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"), "myName",100);

		when(employeeDAO.findById(UUID.fromString("d94f8697-8fc8-4290-8bb6-3584ffae5b89"))).thenReturn(emp);
		when(employeeDAO.save(emp1)).thenReturn(emp1);
		//employeeService.updateEmployee("d94f8697-8fc8-4290-8bb6-3584ffae5b89",10);

		Employee emp2=employeeService.updateEmployee("d94f8697-8fc8-4290-8bb6-3584ffae5b89", 10);

		assertEquals(110,emp2.getSalary());
	}


}
