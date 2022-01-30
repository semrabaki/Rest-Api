package rest_api04_controller_service_repository_basic_auth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentBean05Controller {
	
	private StudentBean05Service studentService;
	
	@Autowired
	public StudentBean05Controller (StudentBean05Service studentService)
	{
		this.studentService=studentService;
	}

	@GetMapping(path="/allStudents")
	@PreAuthorize("hasAnyRole('ROLe_ADMIN','ROLE_STUDENT')")
	public List<StudentBean05>getAllStudents(){
		return studentService.listStudents();
	}
	
	
	@GetMapping(path="/allStudents/{id}")
	@PreAuthorize("hasAnyRole('ROLe_ADMIN','ROLE_STUDENT')")
	public StudentBean05 getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	
	
	//for Delete request
	@DeleteMapping(path="/admin/api/v1/deleteStudents/{id}")
	public String deleteStdById(@PathVariable(value="id")Long id) {
		
		return studentService.deleteStdById(id);
	}
	

}
