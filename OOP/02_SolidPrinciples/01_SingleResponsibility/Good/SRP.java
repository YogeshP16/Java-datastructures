public class SRP {
    public static void main(String[] args) {
        GenerateReport generateReport = new GenerateReport();
        SendMail sendMail = new SendMail();

        // Perform the tasks
        generateReport.generate();
        sendMail.send();
    }

}
