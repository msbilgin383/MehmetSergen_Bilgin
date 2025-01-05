package ApiTest.Pojos;

import java.util.Arrays;

public class GetByIdResponse {
    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    @Override
    public String toString() {
        return "GetByIdResponse{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }

    public GetByIdResponse(int id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public GetByIdResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*{
        "id": 0,
            "category": {
                "id": 0,
                "name": "string"
            },
        "name": "doggie",
            "photoUrls": [
                    "string"
                ],
        "tags": [
                    {
                        "id": 0,
                        "name": "string"
                    }
                ],
        "status": "available"
    }*/
}
