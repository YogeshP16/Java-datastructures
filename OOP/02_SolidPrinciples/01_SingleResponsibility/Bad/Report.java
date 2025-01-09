public class Report {
    public void GnerateReport(){
        System.out.println("generated");

    }
    public void SendMail(){
        System.out.println("sent");
        
    }

    public static void main(String[] args) {
        Report obj = new Report();
        obj.GnerateReport();
    }

}
// single responsibility principle --> a class should have only one job to do
// here class doing two jobs so hard to maintain
// so we separate into two classes in good example
