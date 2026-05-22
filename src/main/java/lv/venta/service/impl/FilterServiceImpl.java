package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.enums.Degree;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Grade> filterGradesByStudentId(long id) throws Exception {
		if(id < 1) {
			throw new Exception("Id nevar būt negatīvs");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Students ar id " + id + " neeksistē");
		}
		if(gradeRepo.count() == 0) {
			throw new Exception("Atzīmju tabula ir tukša un nevaram filtrēt");
		}
		ArrayList<Grade> resultFromDB = gradeRepo.findByStudentIds(id);
		
		if(resultFromDB.isEmpty()) {
			throw new Exception("Studentam ar id " + id + " nav piesaistīta neviena atzīme");
		}
		
		return resultFromDB;
	}

	@Override
	public ArrayList<Grade> filterGradesByCourseTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorDegree(Degree degree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
