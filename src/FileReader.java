import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader {
	
	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;
	
	public FileReader(String name) {
            this.filename = name;
            this.comparator = new Comparator<Student>(){
                @Override
                public int compare(Student x, Student y){
                    return (int) x.marks - (int) y.marks;
                }
            };
            this.hashMap = new MyHashMap(3, this.comparator);
	}
	
	public void createHeap() throws FileNotFoundException {
            Scanner scan = new Scanner(new FileInputStream(this.filename));
            String[] lineInfo;
            Student currentStudent;
            while(scan.hasNextLine()){
                lineInfo = scan.nextLine().trim().split(",");
                String studentName = lineInfo[0];
                char studentSection = lineInfo[1].charAt(0);
                double studentMarks = Double.valueOf(lineInfo[2]);
                currentStudent = new Student(studentName, studentSection, studentMarks);
                hashMap.put(studentSection, currentStudent);
            }
	}
	
	public Student getMaxOfSection(char section) {
            return this.hashMap.get(section);
	}
}

// class GradeCompare implements Comparator<Student> {
// }
