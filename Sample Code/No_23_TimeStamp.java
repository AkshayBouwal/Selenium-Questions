package Questions;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class No_23_TimeStamp {

    /*
    Create Time Stamp that can be used for Screenshot ID
     */

    public static void approach1() {

        //SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy_HH_mm_ssss");

        Date date = new Date();

        String stamp = format.format(date);

        System.out.println(stamp);

    }

    public static void approach2() {

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());


    }

    public static void approach3() {

        LocalDateTime time = LocalDateTime.now();

        String str = time.toString();

        String timeStamp = str.replace("-", "").replace(":", "").replace(".", "");

        System.out.println(str);
        System.out.println(timeStamp);
    }

    public static void main(String[] args) {

        //approach1();
        //approach2();
        approach3();


    }
}
