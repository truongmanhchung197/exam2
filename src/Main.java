import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<PhoneBook> phoneBooks;
    private static final String FILE_HEADER = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void main(String[] args) {
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    if (phoneBooks.size()==0){
                        System.out.println("Không có danh bạ nào");

                    } else {
                        for (int i=0;i<phoneBooks.size();i++){
                            System.out.println("Tel, Group, Full name, Gender, Address, Date, Email ");
                            phoneBooks.get(i).display();
                        }
                    }
                    break;
                case 2:
                    addNewPhoneBook();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("1. Tìm kiếm theo sđt");
                    System.out.println("2. Tìm kiếm theo tên");
                    System.out.println("Nhập vào lựa chọn của bạn");
                    int number = input.nextInt();
                    switch (number){
                        case 1:
                            searchByTel();
                            break;
                        case 2:
                            searchByName();
                            break;
                        default:
                            System.out.println("Mới chọn lại");
                    }
                    break;
                case 6:
                    System.out.println(readFileCsv());
                    break;
                case 7:
                    savePhoneBookCSV();
                    break;
                case 8:
                    System.exit(-1);
                    break;

            }
        } while (true);
    }


    public static String readFileCsv() {
        BufferedReader br = null;
        String csvSplitBy = ",";
        String line;
        String text = "";
        try {
            br = new BufferedReader(new FileReader("contacts.csv"));
            while ((line = br.readLine()) != null) {
                text += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text;
    }

    public static void addNewPhoneBook() {

        System.out.println("Tel ");
        System.out.println("Group ");
        System.out.println("Full name ");
        System.out.println("Gender ");
        System.out.println("Address ");
        System.out.println("Date of birth ");
        System.out.println("Email ");

        Scanner input = new Scanner(System.in);
        String tel = input.nextLine();
        String group = input.nextLine();
        String fullName = input.nextLine();
        String gender = input.nextLine() ;
        String address = input.nextLine() ;
        String date = input.nextLine() ;
        String email = input.nextLine();

        PhoneBook phoneBook=new PhoneBook(tel,group,fullName,gender,address,date,email);
        phoneBooks.add(phoneBook);

    }

    public static void updateTel(){
        System.out.println("Nhập vào sđt cần chỉnh sửa");
        Scanner input = new Scanner(System.in);
        String tel= input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (tel.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).setTel(tel);
                System.out.println("Đã sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm được danh bạ với số điện thoại trên");
    }

    public static void updateGroup(){
        System.out.println("Nhập vào group cần chỉnh sửa");
        Scanner input = new Scanner(System.in);
        String group= input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (group.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).setGroup(group);
                System.out.println("Đã sửa thành công");
            }
        }
    }

    public static void updateName(){
        System.out.println("Nhập vào họ tên cần chỉnh sửa");
        Scanner input = new Scanner(System.in);
        String name= input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (name.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).setFullName(name);
                System.out.println("Đã sửa thành công");
            }
        }
    }

    public static void updateGender(){
        System.out.println("Nhập vào giới tính cần chỉnh sửa");
        Scanner input = new Scanner(System.in);
        String gender= input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (gender.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).setGender(gender);
                System.out.println("Đã sửa thành công");
            }
        }
    }

    public static void updateAddress(){
        System.out.println("Nhập vào địa chỉ cần chỉnh sửa");
        Scanner input = new Scanner(System.in);
        String address= input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (address.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).setAddress(address);
                System.out.println("Đã sửa thành công");
            }
        }
    }

    public static void update(){
        System.out.println("1. Số điện thoại");
        System.out.println("2. Nhóm danh bạ");
        System.out.println("3. Họ tên");
        System.out.println("4. Giới tính");
        System.out.println("5. Địa chỉ");
        System.out.println("6. Ngày sinh" );
        System.out.println("7. Email");
        System.out.println("Nhập vào lựa chọn của bạn: ");
        Scanner input = new Scanner(System.in);
        int choice=input.nextInt();
        input.nextLine();
        switch (choice){
            case 1:
                updateTel();
                break;
            case 2:
                updateGroup();
                break;
            case 3:
                updateName();
                break;
            case 4:
                updateGender();
                break;
            case 5:
                updateAddress();
                break;
            default:
                System.out.println("Mời chọn lại");
        }
    }

    public static void delete(){
        System.out.println("Nhập vào sđt cần xóa");
        Scanner input = new Scanner(System.in);
        String tel = input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (tel.equals(phoneBooks.get(i).getTel())){
                phoneBooks.remove(i);
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không có sđt này");
    }

    public static void searchByTel(){
        System.out.println("Nhập vào sđt cần tìm: ");
        Scanner input = new Scanner(System.in);
        String tel=input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (tel.equals(phoneBooks.get(i).getTel())){
                phoneBooks.get(i).display();
                return;
            }
        }
        System.out.println("Không có sđt này");
    }

    public static void searchByName(){
        System.out.println("Nhập vào họ tên cần tìm: ");
        Scanner input = new Scanner(System.in);
        String fullName=input.nextLine();
        for (int i=0;i<phoneBooks.size();i++){
            if (fullName.equals(phoneBooks.get(i).getFullName())){
                phoneBooks.get(i).display();
                return;
            }
        }
        System.out.println("Không có họ tên này");
    }

    public static void savePhoneBookCSV(){

        FileWriter fileWriter=null;
        try {
            File file;
            fileWriter=new FileWriter("contacts.csv");
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (int i=0;i<phoneBooks.size();i++){
                fileWriter.append(phoneBooks.get(i).getTel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getFullName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getDateOFBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBooks.get(i).getEmail());
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }





}
