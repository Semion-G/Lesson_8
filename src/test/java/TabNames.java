public enum TabNames {

    BOOKS("Books"),
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics"),
    APPARALY("Apparel & Shoes"),
    DIGITAL("Digital downloads"),
    JEWELRY("Jewelry"),
    GIFT("Gift Cards");


    private String name;

    TabNames(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
