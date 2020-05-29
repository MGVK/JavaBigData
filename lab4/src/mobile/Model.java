package mobile;

public class Model extends SiemensMobile {

    private String code;
    private String size;
    private int    recommendedPrice;

    public Model(String code, String size, int recommendedPrice) {
        this.code = code;
        this.size = size;
        this.recommendedPrice = recommendedPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(int recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }
}
