package top.qilixiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.qilixiang.entity.Student;
import top.qilixiang.service.StudentService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    @ResponseBody
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "success";
    }

    @RequestMapping("/searchStudentById/{id}")
    @ResponseBody
    public Student findStudent(@PathVariable("id") Integer id){

        Student student = studentService.findStudentById(id);

        return student;
    }

    @RequestMapping("velocityDemo")
    public ModelAndView velocityDemo(){
        Student stu = new Student();
        stu.setId(88);
        stu.setName("name");
        stu.setAge(33);
        stu.setScore(99);

        studentService.addStudent(stu);

        ModelAndView modelAndView = new ModelAndView("velocity-demo");
        modelAndView.addObject("stu",stu);
        return modelAndView;
    }
}
