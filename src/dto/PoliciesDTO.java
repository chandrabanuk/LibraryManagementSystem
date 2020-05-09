package dto;

public class PoliciesDTO {
    private int authorId;
    private String authorName;
    private int publisherId;
    private String publisherName;
    private int publisherContact;
    private int typeId;
    private String typeName;


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
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

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
