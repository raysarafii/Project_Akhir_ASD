/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting;

/**
 *
 * @Nama:Muhammad Raysa Rafii'udin
 * Nim:235150707111004
 * Kelas:TI-B
 */
import java.util.Scanner;

import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Judul: " + title + ", Pengarang: " + author + ", Tahun: " + year;
    }
}

public class BookSortingApp {
    // Bubble Sort
    public static void bubbleSort(Book[] books, String sortBy) {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition = false;
                if (sortBy.equalsIgnoreCase("judul")) {
                    condition = books[j].title.compareTo(books[j + 1].title) > 0;
                } else if (sortBy.equalsIgnoreCase("pengarang")) {
                    condition = books[j].author.compareTo(books[j + 1].author) > 0;
                } else if (sortBy.equalsIgnoreCase("tahun")) {
                    condition = books[j].year > books[j + 1].year;
                }

                if (condition) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(Book[] books, String sortBy) {
        int n = books.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                boolean condition = false;
                if (sortBy.equalsIgnoreCase("judul")) {
                    condition = books[j].title.compareTo(books[minIdx].title) < 0;
                } else if (sortBy.equalsIgnoreCase("pengarang")) {
                    condition = books[j].author.compareTo(books[minIdx].author) < 0;
                } else if (sortBy.equalsIgnoreCase("tahun")) {
                    condition = books[j].year < books[minIdx].year;
                }

                if (condition) {
                    minIdx = j;
                }
            }

            // Swap
            Book temp = books[minIdx];
            books[minIdx] = books[i];
            books[i] = temp;
        }
    }

    // Print buku
    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah buku
        System.out.print("Masukkan jumlah buku: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Book[] books = new Book[n];

        // Input data buku
        for (int i = 0; i < n; i++) {
            System.out.println("Masukkan data buku ke-" + (i + 1) + ":");
            System.out.print("Judul: ");
            String title = scanner.nextLine();
            System.out.print("Pengarang: ");
            String author = scanner.nextLine();
            System.out.print("Tahun Terbit: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            books[i] = new Book(title, author, year);
        }

        // Pilih atribut pengurutan
        System.out.println("Pilih atribut untuk mengurutkan:");
        System.out.println("1. Judul");
        System.out.println("2. Pengarang");
        System.out.println("3. Tahun Terbit");
        System.out.print("Pilihan Anda: ");
        int sortByChoice = scanner.nextInt();
        scanner.nextLine(); 

        String sortBy = switch (sortByChoice) {
            case 1 -> "judul";
            case 2 -> "pengarang";
            case 3 -> "tahun";
            default -> {
                System.out.println("Pilihan tidak valid. Default ke 'judul'.");
                yield "judul";
            }
        };

        // Pilih algoritma pengurutan
        System.out.println("Pilih algoritma sorting:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.print("Pilihan Anda: ");
        int algoChoice = scanner.nextInt();

        switch (algoChoice) {
            case 1 -> {
                bubbleSort(books, sortBy);
                System.out.println("Daftar buku setelah Bubble Sort:");
            }
            case 2 -> {
                selectionSort(books, sortBy);
                System.out.println("Daftar buku setelah Selection Sort:");
            }
            default -> {
                System.out.println("Pilihan tidak valid. Tidak ada pengurutan dilakukan.");
                return;
            }
        }

        // Output hasil pengurutan
        printBooks(books);
        scanner.close();
    }
}
