public class Student {
    public static void main(String[] args) {
        Students loki = new Students();
        loki.marks = 89;
        loki.name = "oreo";

        loki.result();

        
    }
}

class Students{
    int marks;
    String name;

    void result(){
        System.out.println(name + " scores " + marks);
    }

}
