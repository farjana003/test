package controller;

import model.Library;
import service.LibraryService;

public class LibraryController {

    public static String saveData(Library data) {
        return LibraryService.storeLibraryInfo(data);
    }

    public static Object[][] getAllData() {
        return LibraryService.getAllLibraries();
    }

    public static String deleteData(int roll) {
        return LibraryService.deleteData(roll);
    }

    public static Library getByRoll(int roll) {
        return LibraryService.getById(roll);
    }

    public static Library getById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
