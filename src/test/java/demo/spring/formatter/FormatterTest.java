package demo.spring.formatter;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;
import org.springframework.format.number.CurrencyFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by raist on 2016/5/31.
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormatterTest {

    @Test
    public void test1() throws ParseException {
        CurrencyFormatter formatter = new CurrencyFormatter();
        formatter.setFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.CEILING);
        Assert.assertEquals(new BigDecimal("123.13"),formatter.parse("$123.125", Locale.US));
    }

    @Test
    public void test2(){
        CurrencyFormatter formatter = new CurrencyFormatter();
        formatter.setFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.CEILING);
//        System.out.println(formatter.print(new BigDecimal("123"), Locale.US));
        Assert.assertEquals("$123.00",formatter.print(new BigDecimal("123"), Locale.US));
    }
}
