import java.util.*;
import java.io.*;

class Patients {
    String name;
    String disease;
    int age;
}

class Doctors {
    String name;
    String disease;
    int age;
    int fee;
}

public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("****************************************************");
            System.out.println("------------ Nagpur Government Hospital ------------");
            System.out.println("****************************************************");
            System.out.println("Please select by corresponding number - ");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Medicine Management");
            System.out.println("4. Income/Expense Statement");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    patient();
                    break;
                case 2:
                    doctors();
                    break;
                case 3:
                    medicine();
                    break;
                case 4:
                    money();
                    break;
                default:
                    System.out.println("Unspecified Selection !");
            }
        }
    }

    public static void patient() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.printf("Please enter today's date (dd/mm/yyyy) - ");
            String date = sc.next();
            System.out.println("Please enter by corresponding number - ");
            System.out.println("1. New Patient");
            System.out.println("2. Old Patient");
            int p = sc.nextInt();
            switch (p) {
                case 1:
                    BufferedWriter wfile = new BufferedWriter(new FileWriter("Patients.txt", true));
                    System.out.printf("Enter patient's full name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.printf("Enter patient's age : ");
                    int age = sc.nextInt();
                    System.out.printf("Enter the disease patient is suffering with : ");
                    sc.nextLine();
                    String disease = sc.nextLine();
                    wfile.write(name + "\n" + age + "\n" + disease + "\n" + "Last appointment date : " + date + "\n");
                    wfile.close();
                    break;
                case 2:
                    BufferedReader rfile = new BufferedReader(new FileReader("Patients.txt"));
                    System.out.printf("Enter patient's name : ");
                    sc.nextLine();
                    String old_name = sc.nextLine();
                    String line;
                    int count = 0;
                    int patient_count = 0;
                    while ((line = rfile.readLine()) != null) {
                        patient_count++;
                        if (old_name.equals(line)) {
                            count++;
                            System.out.println("The patient's details are - ");
                            System.out.println(line);
                            for (int i = 1; i <= 3; i++) {
                                patient_count++;
                                line = rfile.readLine();
                                System.out.println(line);
                            }
                        }
                    }
                    if (count == 0) {
                        System.out.println("No patient record found !");
                    }
                    rfile.close();
                    System.out.println("The total patient count is : " + (patient_count / 4));
                    break;
                default:
                    System.out.println("Unspecified Selection !");
            }
        }
    }

    public static void doctors() throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter by corresponding number - ");
            System.out.println("1. Doctor list according to disease");
            System.out.println("2. New Doctor");
            int p = sc.nextInt();
            switch (p) {
                case 1:
                    BufferedReader rfile = new BufferedReader(new FileReader("Doctors.txt"));
                    System.out.printf("Enter the disease patient is suffering with : ");
                    sc.nextLine();
                    String old_disease = sc.nextLine();
                    String line;
                    int count = 0;
                    System.out.println("For the disease " + old_disease + " the doctors found are - ");
                    while ((line = rfile.readLine()) != null) {
                        if (old_disease.equals(line)) {
                            count++;
                            for (int i = 1; i <= 3; i++) {
                                line = rfile.readLine();
                                System.out.println(line);
                            }
                        }
                    }
                    if (count == 0) {
                        System.out.println("No doctor's found !");
                    }
                    rfile.close();
                    System.out.println("The total doctor count for this disease is : " + count);
                    break;
                case 2:
                    BufferedWriter wfile = new BufferedWriter(new FileWriter("Doctors.txt", true));
                    System.out.printf("Enter doctor's full name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.printf("Enter doctor's age : ");
                    int age = sc.nextInt();
                    System.out.printf("Enter the disease to handled by the doctor : ");
                    sc.nextLine();
                    String disease = sc.nextLine();
                    System.out.printf("Enter doctor's consultation fee charged : ");
                    int fee = sc.nextInt();
                    wfile.write(
                            disease + "\n" + "Name: " + name + "\n" + "Age: " + age + "\n" + "Consultation fee: "
                                    + fee + "\n");
                    wfile.close();
                    break;
                default:
                    System.out.println("Unspecified Selection !");
            }
        }
    }

    public static void medicine() {

    }

    public static void money() {

    }
}