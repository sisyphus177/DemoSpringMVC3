package demo.spring.mvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raist on 2016/5/31.
 *
 */
public class InputDateConverter implements Converter<String,Date> {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println("InputDateConverter with format:"+format);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
