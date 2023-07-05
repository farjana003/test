package service;

import dao.JdbcDao;
import model.Library;

import java.util.List;

public class LibraryService {

    public static String storeLibraryInfo(Library data) {
        if (data.getId() > 0) {
            JdbcDao.edit(data);
        } else {
            JdbcDao.save(data);
        }
        return (data.getId() > 0) ? "Successfully stored info" : "Failed to store info";
    }

    public static Object[][] getAllLibrary() {
        List<Library> students = JdbcDao.findAll();
        Object[][] dataSet = new Object[students.size()][5];
        for (int i = 0; i < students.size(); i++) {
            Library s = students.get(i);

            Object[] data = new Object[11];
            data[0] = s.getId();
            data[1] = s.getName();
            data[2] = s.getCourse();
            data[3] = s.getSemester();
            data[4] = s.getEmail();
            data[5] = s.getPhoneno();
            data[6] = s.getBooktitle();
            data[7] = s.getBookauthor();
            data[8] = s.getBookid();
            data[9] = s.getAbout();
            data[10] = s.getEdition();

            dataSet[i] = data;
        }
        return dataSet;
    }

    public static Library getById(int roll) {
        return JdbcDao.getById(roll);
    }

    public static String deleteData(int roll) {
        int count = JdbcDao.delete(roll);
        return count > 0 ? "Successfully removed data" : "Failed to remove data";
    }

    public static Object[][] getAllLibraries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Library getByroll(int roll) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
