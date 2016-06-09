package demo.spring.mvc.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by raist on 2016/5/31.
 *
 */
public class InputDateFormatter implements Formatter<Date> {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println("InputDateFormatter with format:"+format);
        return sdf.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
