package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error errorFatal = new Error(true, 3, "Reload");
        errorFatal.printInfo();
    }

    public void printInfo() {
        System.out.println("Статус активности: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Действие: " + message);
    }
}
