package org.todoshis.springbootproject.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(long id, Student student) {
        Student updatedStudent = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exist"));
        if (student.getName() != null && student.getName().length() > 0 && !student.getName().equals(updatedStudent.getName())) {
            updatedStudent.setName(student.getName());
        }
        if (student.getEmail() != null && student.getEmail().length() > 0 && !student.getEmail().equals(updatedStudent.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            updatedStudent.setEmail(student.getEmail());
        }
        if (student.getDob() != null && !student.getDob().equals(updatedStudent.getDob())) {
            updatedStudent.setDob(student.getDob());
        }
    }
}
