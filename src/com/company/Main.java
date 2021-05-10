package com.company;

import services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IAccountService accountService = new AccountService();
        IEmployeeFullTimeService employeeFullTimeService = new EmployeeFullTimeService();
        IEmployeePartTimeService employeePartTimeService = new EmployeePartTimeService();
        final Scanner SCANNER_SELECT = new Scanner(System.in);
        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("Number 1: Đăng nhập.");
            System.out.println("Number 2: Đăng ký.");
            System.out.println("Number 3: Lấy lại mật khẩu.");
            System.out.println("Number 0: Thoát chương trình.");
            int num = SCANNER_SELECT.nextInt();
            switch (num) {
                case 1:
                    loginProgram(employeeFullTimeService, employeePartTimeService, accountService);
                    break;
               case 2:
                    accountService.creatAccount();
                    break;
               case 3:
                    accountService.forgotPassword();
                    break;
               case 0:
                   System.exit(0);
            }
        }
    }


    public static void loginProgram(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService, IAccountService accountService){
        if(accountService.loginUser()) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Chọn chức năng: ");
            System.out.println("Number 1: Vào Của Menu Của Admin..!.");
            System.out.println("Number 2: Đổi mật khẩu.");
            System.out.println("Number 3: Trở lại..!");
            switch (sc1.nextInt()) {
                case 1:
                    while (true) {
                        System.out.println("----------------------------------------------");
                        System.out.println(" --- MENU ADMIN  ---");
                        System.out.println("Mời bạn chọn chức năng quản lý .");
                        System.out.println("Number 1: Thêm mới nhân viên. ");
                        System.out.println("Number 2: Hiển thị nhân viên. ");
                        System.out.println("Number 3: Sửa đổi nhân viên. ");
                        System.out.println("Number 4: Xóa Nhân viên: ");
                        System.out.println("Number 5: Tính lương của nhân viên. ");
                        System.out.println("Number 6: Thay đổi trạng thái làm việc của nhân viên. ");
                        System.out.println("Number 7: Tìm kiếm nhân viên.");
                        Scanner sc3 = new Scanner(System.in);
                        switch (sc3.nextInt()) {
                            case 1:
                                addEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 2:
                                displayEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 3:
                                changeEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 4:
                                deleteEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 5:
                                calculateSalaryEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 6:
                                changeStatusEmployyee(employeeFullTimeService, employeePartTimeService);
                                break;
                            case 7:
                                searchEmployee(employeeFullTimeService, employeePartTimeService);
                                break;
                        }
                    }
                case 2:
                    accountService.changePassword();
                    break;
                case 3:
                    break;
            }
        }else {
            menuOfUser(employeeFullTimeService, employeePartTimeService, accountService);
        }

    }
    public static void menuOfUser(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService, IAccountService accountService){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Chọn chức năng: ");
        System.out.println("Number 1: Vào menu chính.");
        System.out.println("Number 2: Đổi mật khẩu.");
        System.out.println("Number 3: Trở lại..!");
        switch (sc1.nextInt()) {
            case 1:
                while (true) {
                    System.out.println("----------------------------------------------");
                    System.out.println(" --- MENU CHÍNH ---");
                    System.out.println("Mời bạn chọn chức năng quản lý .");
                    System.out.println("Number 1: Hiển thị nhân viên. ");
                    System.out.println("Number 2: Tính lương của nhân viên. ");
                    System.out.println("Number 3: Tìm kiếm nhân viên.");
                    Scanner sc3 = new Scanner(System.in);
                    switch (sc3.nextInt()) {
                        case 1:
                            displayEmployee(employeeFullTimeService, employeePartTimeService);
                            break;
                        case 2:
                            calculateSalaryEmployee(employeeFullTimeService, employeePartTimeService);
                            break;
                        case 3:
                            searchEmployee(employeeFullTimeService, employeePartTimeService);
                            break;
                    }
                }
                    case 2:
                        accountService.changePassword();
                        break;
                    case 3:
                        break;
        }
    }

    public static void addEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        Scanner sc4 = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời chọn kiểu nhân viên: ");
        System.out.println("Number 1: Nhân viên Full Time. ");
        System.out.println("Number 2: Nhân viên Part Time.");
        System.out.println("Number 3: Trở lại.");
        switch (sc4.nextInt()) {
            case 1:
                employeeFullTimeService.addEmployeeFullTime();
                break;
            case 2:
                employeePartTimeService.addEmployeePartTime();
                break;
            case 3:
                break;
        }
    }
    public static void displayEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){

        Scanner sc5 = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời chọn kiểu nhân viên hiển thị: ");
        System.out.println("Number 1: Hiển thị nhân viên full time. ");
        System.out.println("Number 2: Hiển thị nhân viên part time. ");
        System.out.println("Number 3: Hiển thị nhân viên  đang làm.");
        System.out.println("Number 4: Hiển thị nhân viên đang nghỉ.");
        System.out.println("Number 5: Hiển thị toàn bộ nhân viên. ");
        System.out.println("Number 6: Trở lại..!");
        switch (sc5.nextInt()) {
            case 1:
                System.out.println("Nhân viên full time đang làm : ");
                employeeFullTimeService.displayEmployeeFullTimeTrue();
                System.out.println(" Nhân viên full time đang nghỉ: ");
                employeeFullTimeService.displayEmployeeFullTimeFalse();
                break;
            case 2:
                System.out.println("Nhân viên part time đang làm : ");
                employeePartTimeService.displayEmployeePartTimeTrue();
                System.out.println(" Nhân viên part time đang nghỉ: ");
                employeePartTimeService.displayEmployeePartTimeFalse();
                break;
            case 3:
                System.out.println("Nhân viên full time đang làm : ");
                employeeFullTimeService.displayEmployeeFullTimeTrue();
                System.out.println("Nhân viên part time đang làm : ");
                employeePartTimeService.displayEmployeePartTimeTrue();
                break;
            case 4:
                System.out.println(" Nhân viên full time đang nghỉ: ");
                employeeFullTimeService.displayEmployeeFullTimeFalse();
                System.out.println(" Nhân viên part time đang nghỉ: ");
                employeePartTimeService.displayEmployeePartTimeFalse();
                break;
            case 5:
                System.out.println("Nhân viên full time đang làm : ");
                employeeFullTimeService.displayEmployeeFullTimeTrue();
                System.out.println("Nhân viên part time đang làm : ");
                employeePartTimeService.displayEmployeePartTimeTrue();
                System.out.println(" Nhân viên full time đang nghỉ: ");
                employeeFullTimeService.displayEmployeeFullTimeFalse();
                System.out.println(" Nhân viên part time đang nghỉ: ");
                employeePartTimeService.displayEmployeePartTimeFalse();
                break;
            case 6:
                break;
        }

    }
    public static void changeEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời bạn chọn kiểu nhân viên muốn thay đổi");
        System.out.println("Number 1: Nhân viên Full Time. ");
        System.out.println("Number 2: Nhân viên Part Time. ");
        System.out.println("Number 3: Trở lại..!");
        Scanner sc6 = new Scanner(System.in);
        switch (sc6.nextInt()){
            case 1:
                employeeFullTimeService.updateEmployeeFullTime();
                break;
            case 2:
                employeePartTimeService.updateEmployeePartTime();
                break;
            case 3:
                break;
        }
    }
        public static void deleteEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời bạn chọn kiểu nhân viên muốn xóa");
        System.out.println("Number 1: Nhân viên Full Time. ");
        System.out.println("Number 2: Nhân viên Part Time. ");
        System.out.println("Number 3: Trở lại.");
        Scanner sc7 = new Scanner(System.in);
        switch (sc7.nextInt()){
            case 1:
                employeeFullTimeService.deleteEmployeeFullTime();
                break;
            case 2:
                employeePartTimeService.deleteEmployeePartTime();
                break;
            case 3:
                break;
        }
    }
    public static void calculateSalaryEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời bạn chọn loại nhân viên: ");
        System.out.println("Number 1: Nhân viên Full Time.");
        System.out.println("Number 2: Nhân viên Part Time.");
        System.out.println("Number 3: Trở lại.");
        Scanner sc8 = new Scanner(System.in);
        switch (sc8.nextInt()){
            case 1:
                employeeFullTimeService.calculateSalaryFullTime();
                break;
            case 2:
                employeePartTimeService.calculateSalaryPartTime();
                break;
            case 3:
                break;
        }
    }
    public static void changeStatusEmployyee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời bạn chọn kiểu nhân viên :");
        System.out.println("Number 1: Nhân viên Full Time.");
        System.out.println("Number 2: Nhân viên Part Time.");
        System.out.println("Number 3: Trở lại.");
        Scanner sc9 = new Scanner(System.in);
        switch (sc9.nextInt()){
            case 1:
                employeeFullTimeService.changeStatusEmployeeFullTime();
                break;
            case 2:
                employeePartTimeService.changeStatusEmployeePartTime();
                break;
            case 3:
                break;
        }
    }
    public static void searchEmployee(IEmployeeFullTimeService employeeFullTimeService, IEmployeePartTimeService employeePartTimeService){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Mời bạn chọn kiểu nhân viên");
        System.out.println("Number 1: Nhân viên Full Time.");
        System.out.println("Number 2: Nhân viên Part Time.");
        System.out.println("Number 3: Trở lại.");
        Scanner sc10 = new Scanner(System.in);
        switch (sc10.nextInt()){
            case 1:
                employeeFullTimeService.searchEmployeeFullTime();
                break;
            case 2:
                employeePartTimeService.searchEmployeePartTime();
                break;
            case 3:
                break;
        }
    }
}
