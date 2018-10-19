package me.kiip.internal.f;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;




public class a
  extends SimpleDateFormat
{
  private SimpleDateFormat a;
  
  public a()
  {
    super("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
    setTimeZone(TimeZone.getTimeZone("UTC"));
    
    a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    a.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public Date parse(String string) throws ParseException
  {
    try {
      return super.parse(string);
    } catch (ParseException localParseException) {}
    return a.parse(string);
  }
}
