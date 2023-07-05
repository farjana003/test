package model;

public class Library {
    private int roll;
    private int id;
    private String name = "";
    private String course = "";
    private int semester;
    private String email = "";
    private int phoneno;
    private String booktitle = "";
    private String bookauthor = "";
    private int bookid;
    private String about = "";
    private int edition;
    
    public int getRoll() {
        return roll;
    }
    
    public void setRoll(int roll){
        this.roll = roll;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getPhoneno() {
        return phoneno;
    }
    
    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }
    
    public String getBooktitle() {
        return booktitle;
    }
    
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
    public String getBookauthor() {
        return bookauthor;
    }
    
    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
    
    public int getBookid() {
        return bookid;
    }
    
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    
    public String getAbout() {
        return about;
    }
    
    public void setAbout(String about) {
        this.about = about;
    }
    
    public int getEdition() {
        return edition;
    }
    
    public void setEdition(int edition) {
        this.edition = edition;
    }
   
   
}
