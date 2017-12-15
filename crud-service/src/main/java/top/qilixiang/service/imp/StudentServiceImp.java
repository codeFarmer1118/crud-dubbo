package top.qilixiang.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qilixiang.dao.StudentMapper;
import top.qilixiang.entity.Student;
import top.qilixiang.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void addStudent(Student student) {
        studentMapper.insertSelective(student);
    }

    public Student findStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
