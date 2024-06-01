package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Phu Bao
 */
public class GenerateCode {

    //tạo mã
    public static String generateMa(String keyWord) {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String timeString = dateFormat.format(now);

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String randomString = keyWord + timeString + randomNumber;
        return randomString;
    }

    //tạo mật khẩu
    public static String generatePassword(String ma, String namSinh) {
        String password = ma + "#" + namSinh;
        String hashPassword = PasswordHashing.hashPassword(password);
        return hashPassword;
    }

    //tạo email
    public static String generateEmail(String ma, String tenChucVu) {
        String email = ma.toLowerCase() + "@ptitwater." + tenChucVu + ".com";
        return email;
    }

    //định dạng tiền tệ
    public static String generateMoneyCurrency(int money) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        String formattedTienThoi = decimalFormat.format(money);
        return formattedTienThoi + " đồng";
    }

}
