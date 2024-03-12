package ra.run;

import java.util.Scanner;

import ra.business.Book;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] library = new Book[100];

        int choice;
        int bookCount = 0;

        while (true) {
            // Hiển thị menu
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");

            // Nhập lựa chọn từ người dùng
            choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sách cần thêm mới: ");
                    int newBooksCount = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < newBooksCount; i++) {
                        library[bookCount] = new Book();
                        library[bookCount].inputData();
                        library[bookCount].calInterest();
                        bookCount++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < bookCount; i++) {
                        library[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < bookCount; i++) {
                        for (int j = i + 1; j < bookCount; j++) {
                            if (library[j].getInterest() < library[i].getInterest()) {
                                Book temp = library[i];
                                library[i] = library[j];
                                library[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sách theo lợi nhuận tăng dần.");
                    for (int i = 0; i < bookCount; i++) {
                        library[i].displayData();
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int deleteBookId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].getBookId() == deleteBookId) {
                            found = true;
                            for (int j = i; j < bookCount - 1; j++) {
                                library[j] = library[j + 1];
                            }
                            bookCount--;
                            System.out.println("Đã xóa sách có mã sách " + deleteBookId);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách có mã sách " + deleteBookId);
                    }
                    break;
                case 5:
                    System.out.print("Nhập chuỗi tìm kiếm: ");
                    String searchBook = scanner.nextLine().toLowerCase();
                    boolean foundBooks = false;
                    for (int i = 0; i < bookCount; i++) {
                        Book currentBook = library[i];
                        if (currentBook.getBookName().toLowerCase().contains(searchBook) || currentBook.getDescription().toLowerCase().contains(searchBook)) {
                            currentBook.displayData();
                            foundBooks = true;
                        }
                    }
                    if (!foundBooks) {
                        System.out.println("Không tìm thấy sách nào phù hợp với chuỗi tìm kiếm.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập mã sách cần thay đổi thông tin: ");
                    int updateBookId = Integer.parseInt(scanner.nextLine());
                    boolean foundBook = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].getBookId() == updateBookId) {
                            foundBook = true;
                            System.out.println("Thông tin hiện tại của sách có mã sách " + updateBookId + ":");
                            library[i].displayData();

                            System.out.println("Nhập thông tin mới cho sách có mã sách " + updateBookId + ":");
                            library[i].inputData();

                            // Hiển thị thông tin đã được cập nhật
                            System.out.println("Thông tin sau khi cập nhật:");
                            library[i].displayData();
                        }
                    }
                    // Nếu không tìm thấy sách
                    if (!foundBook) {
                        System.out.println("Không tìm thấy sách có mã sách " + updateBookId);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

}

