package ApiTest.Pojos;

public class DeletePetResponse {
    private int code;
    private String type;
    private String message;

    public DeletePetResponse() {
    }

    public DeletePetResponse(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "DeletePetResponse{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
