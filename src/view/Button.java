package view;

public class Button {
    private final String id;
    private final String text;
    private final String tag;

    public Button(String id, String text, String tag) {
        this.id = id;
        this.text = text;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
