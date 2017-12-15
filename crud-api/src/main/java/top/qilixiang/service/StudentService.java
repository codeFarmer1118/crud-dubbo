package top.qilixiang.service;

import top.qilixiang.entity.Student;

/**
 * 提供接口
 */
public interface StudentService {

    /**
     * 添加学生
     * @param student
     */
    void addStudent(Student student);

    /**
     * 根据主键查询
     * @param id
     */
    Student findStudentById(Integer id);
}
