package studentCatalog;

import java.util.Iterator;
import java.util.Vector;
import java.lang.Iterable;

/***
 * Desc: A studentCatalog which contains students
 * @see Student
 * @author Yushun Xiang
 * @date 2021/10/17 9:11
 */
public class StudentCatalog implements Iterable<Student>{
    private Vector<Student> students;
    Iterable<Student> its;
    Iterator<Student> it;
    /**
     * Desc:
     * @param
     * @return {@link null}
     * @author Yushun Xiang
     * @date 2021/10/17 8:51
     */
    public StudentCatalog() {
        students = new Vector<Student>();
        Iterable<Student> its = students;
        Iterator<Student> it = students.iterator();
    }

    /**
     * Desc:
     * @param
     * @return {@link Vector<Student>}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public Vector<Student> getStudents() {
        return students;
    }

    /**
     * Desc:
     * @param student
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Desc:
     * @param student
     * @return
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /**
     * Desc:
     * @param id
     * @return {@link Student}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public Student getStudent(String id) {
        for(Student student : students) {

            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Desc:
     * @param index
     * @return {@link Student}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public Student getStudent(int index) {
        return students.get(index);
    }

    /**
     * Desc:
     * @param
     * @return {@link int}
     * @author Yushun Xiang
     * @date 2021/10/17 8:52
     */
    public int getNumberOfStudents() {
        return students.size();
    }
    /**
     * Desc: Determine if there are any students with this number.
     * @param id
     * @return {@link boolean}
     * @author Yushun Xiang
     * @date 2021/10/17 10:01
     */
    public boolean isStudent(String id) {
        if (this.getStudent(id) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    @Override
    public String toString() {
        return "StudentCatalog{" +
                "students=" + students +
                ", its=" + its +
                ", it=" + it +
                '}';
    }
}
