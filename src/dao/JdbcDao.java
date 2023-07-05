package dao;

import config.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Library;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDao {

    private static int lastId = 0;

    private static int getLastId() {
        if (lastId == 0) {
            try (Connection conn = DbConfig.getConnection()) {
                PreparedStatement stmtMaxId = conn.prepareStatement("select coalesce(max(id), 0) as max_Id from library");
                ResultSet rsMaxId = stmtMaxId.executeQuery();
                if (rsMaxId.next()) {
                    lastId = rsMaxId.getInt("max_id");
                }
                DbConfig.closeStatement(stmtMaxId, rsMaxId);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ++lastId;
    }

    public static int save(Library data) {
        int Id = getLastId();
        data.setId(Id);

        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("insert into library (ID," +
"NAME," +
"COURSE," +
"SEM," +
"EMAIL," +
"PHNO," +
"BOOKTITLE," +
"BOOKAUTHOR," +
"BOOKID," +
"ABOUT," +
"EDITION) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, Id);
            stmt.setString(2, data.getName());
            stmt.setString(3, data.getCourse());
            stmt.setInt(4, data.getSemester());
            stmt.setString(5, data.getEmail());
            stmt.setInt(6, data.getPhoneno());
            stmt.setString(7, data.getBooktitle());
            stmt.setString(8, data.getBookauthor());
            stmt.setInt(9, data.getBookid());
            stmt.setString(10, data.getAbout());
            stmt.setInt(11, data.getEdition());

            int result = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Id;
    }

    public static int edit(Library data) {
        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("update library set name = ?, course = ?, semester = ?, email = ?, phoneno = ?, booktitle = ?, bookauthor = ?, bookid = ?, about = ?, edition = ? where \"Id\" = ?");
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getCourse());
            stmt.setInt(3, data.getSemester());
            stmt.setString(4, data.getEmail());
            stmt.setInt(5, data.getPhoneno());
            stmt.setString(6, data.getBooktitle());
            stmt.setString(7, data.getBookauthor());
            stmt.setInt(8, data.getBookid());
            stmt.setString(9, data.getAbout());
            stmt.setInt(10, data.getEdition());
            stmt.setInt(11, data.getId());

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static List<Library> findAll() {
        List<Library> list = new LinkedList<>();
        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from library order by \"id\" asc");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Library lib = new Library();
                lib.setId(rs.getInt("Id"));
                lib.setName(rs.getString("name"));
                lib.setCourse(rs.getString("course"));
                lib.setSemester(rs.getInt("semester"));
                lib.setEmail(rs.getString("email"));
                lib.setPhoneno(rs.getInt("phoneno"));
                lib.setBooktitle(rs.getString("booktitle"));
                lib.setBookauthor(rs.getString("bookauthor"));
                lib.setBookid(rs.getInt("bookid"));
                lib.setAbout(rs.getString("about"));
                lib.setEdition(rs.getInt("edition"));

                list.add(lib);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Library getById(int Id) {
        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from library where \"Id\" = ?");
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Library lib = new Library();
                lib.setId(rs.getInt("Id"));
                lib.setName(rs.getString("name"));
                lib.setCourse(rs.getString("course"));
                lib.setSemester(rs.getInt("semester"));
                lib.setEmail(rs.getString("email"));
                lib.setPhoneno(rs.getInt("phoneno"));
                lib.setBooktitle(rs.getString("booktitle"));
                lib.setBookauthor(rs.getString("bookauthor"));
                lib.setBookid(rs.getInt("bookid"));
                lib.setAbout(rs.getString("about"));
                lib.setEdition(rs.getInt("edition"));
                return lib;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Library();
    }

    public static int delete(int Id) {
        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("delete from library where \"Idno\" = ?");
            stmt.setInt(1, Id);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}