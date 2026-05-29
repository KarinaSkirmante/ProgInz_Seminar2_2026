package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Student;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICRUDStudentService;

@Service
public class CRUDStudentServiceImpl implements ICRUDStudentService{

	@Autowired
	private IStudentRepo studRepo;
	
	//TODO create un update pabeigt mājās, pēc līdzīga piemera, kā product (Sem1) create un update 
	
	@Override
	public void create(Student newObject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count() == 0) {
			throw new Exception("Studentu tabula ir tukša");
		}
		return (ArrayList<Student>) studRepo.findAll();
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(long id, String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
