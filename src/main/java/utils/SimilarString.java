
package utils;


public class SimilarString {
    private String a;
    private String b;

    public SimilarString() {
    }

    
    public SimilarString(String a, String b) {
        this.a = a;
        this.b = b;
    }
    
    public int isSimilar(String a, String b) {
        // Độ dài tối thiểu để xem a và b là gần giống
        int minLength = 3; // Độ dài tối thiểu có thể thay đổi tùy ý
        
        // Nếu độ dài chuỗi a hoặc b nhỏ hơn độ dài tối thiểu, không thể coi là gần giống
        if (a.length() < minLength || b.length() < minLength) {
            return 0;
        }
        
        // So sánh chuỗi a với từng phần của chuỗi b
        for (int i = 0; i <= b.length() - a.length(); i++) {
            if (b.substring(i, i + a.length()).equals(a)) {
                return 1;
            }
        }
        
        // Nếu không tìm thấy chuỗi a trong chuỗi b
        return 0;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    
    
}
