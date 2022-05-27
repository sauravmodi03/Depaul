package shop.ui;

public enum EForm {

    TITLE("Title"),
    YEAR("Year"),
    DIRECTOR("Director"),
    COPIES_TO_ADD_REMOVE("Number of copies to add/remove");


    private final String val;
    EForm(String value) {
        this.val = value;
    }

    public String getVal() {
        return val;
    }
}
