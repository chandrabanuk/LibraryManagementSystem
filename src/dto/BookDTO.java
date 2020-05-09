package dto;

public class BookDTO {
    private int aid;
    private String authorName;
    private int pid;
    private String publisherName;
    private int publisherContact;
    private int tid;
    private String typeName;
    private int sid;
    private String sectionName;
    private String title;
    private int bookId;

    public BookDTO() {
    }

    public BookDTO(int aid, String authorName, int pid, String publisherName, int publisherContact, int tid, String typeName, int sid, String sectionName) {
        this.aid = aid;
        this.authorName = authorName;
        this.pid = pid;
        this.publisherName = publisherName;
        this.publisherContact = publisherContact;
        this.tid = tid;
        this.typeName = typeName;
        this.sid = sid;
        this.sectionName = sectionName;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublisherContact() {
        return publisherContact;
    }

    public void setPublisherContact(int publisherContact) {
        this.publisherContact = publisherContact;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "aid=" + aid +
                ", authorName='" + authorName + '\'' +
                ", pid=" + pid +
                ", publisherName='" + publisherName + '\'' +
                ", publisherContact=" + publisherContact +
                ", tid=" + tid +
                ", typeName='" + typeName + '\'' +
                ", sid=" + sid +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
