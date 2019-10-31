package http;

public enum Status {

    SUCCESS(1, "Success"),

    BAD_REQUEST(2, "Bad Request"),

    INTERNAL_SERVER_ERROR(3, "Internal Server Error");

    private final int code;

    private final String desc;

    Status(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
