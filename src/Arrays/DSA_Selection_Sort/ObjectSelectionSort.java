package Arrays.DSA_Selection_Sort;


class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class ObjectSelectionSort {
    public static void main(String[] args) {
        Student[] student = {
                new Student("Aziz", 99),
                new Student("Bob", 86),
                new Student("Charlie", 89)
        };

        // Sort by grade
        for (int i = 0; i < student.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < student.length; j++) {
                if (student[j].grade < student[minIdx].grade)
                    minIdx = j;
            }

            Student temp = student[i];
            student[i] = student[minIdx];
            student[minIdx] = temp;
        }
        for (Student s : student) {
            System.out.println(s.name + ": " + s.grade);
        }
    }
}
