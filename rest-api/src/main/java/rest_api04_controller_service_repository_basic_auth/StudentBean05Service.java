package rest_api04_controller_service_repository_basic_auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean05Service {
	
	StudentBean05Repository studentRepo;
	
	@Autowired
	public StudentBean05Service(StudentBean05Repository studentRepo) {
		 this.studentRepo=studentRepo;
	}
	
	//This method is for Get request
	
	public List <StudentBean05> listStudents(){
		
		return studentRepo.findAll();
	}
	
	public StudentBean05 getStudentById(Long id) {
		
		if(studentRepo.findById(id).isPresent()) {
			
			return studentRepo.findById(id).get();
		}
		else
		{
			return new StudentBean05();
		}
	}
	
	//This method for delete request
	public String deleteStdById(Long id)
	{
		if(!studentRepo.existsById(id)) {
			throw new IllegalStateException (id +"does not exist");
		}
		else
		{
			studentRepo.deleteById(id);
			return "Student whose id is : "+id+" is successfully deleted";
		}
	}
	

	
}