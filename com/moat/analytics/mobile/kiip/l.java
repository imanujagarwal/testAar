package com.moat.analytics.mobile.kiip;

import com.moat.analytics.mobile.kiip.base.functional.Optional;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;




final class l
{
  l() {}
  
  private static String ˋ(InputStream paramInputStream)
    throws IOException
  {
    char[] arrayOfChar = new char['Ā'];
    StringBuilder localStringBuilder = new StringBuilder();
    paramInputStream = new InputStreamReader(paramInputStream, "UTF-8");
    
    int j = 0;
    do { int i; if ((i = paramInputStream.read(arrayOfChar, 0, 256)) <= 0) break;
      j += i;
      localStringBuilder.append(arrayOfChar, 0, i);
    } while (j < 1024);
    


    return localStringBuilder.toString();
  }
  







  static Optional<String> ॱ(String paramString)
  {
    InputStream localInputStream = null;
    
    try
    {
      (paramString = (HttpURLConnection)new URL(paramString).openConnection()).setUseCaches(false);
      paramString.setReadTimeout(10000);
      paramString.setConnectTimeout(15000);
      paramString.setRequestMethod("GET");
      paramString.setDoInput(true);
      
      paramString.connect();
      
      if (paramString.getResponseCode() >= 400) {
        return Optional.empty();
      }
      

      return Optional.of(ˋ(localInputStream = paramString.getInputStream()));
    } catch (IOException localIOException2) {
      return Optional.empty();
    } finally {
      if (localInputStream != null) {
        try {
          localInputStream.close();
        }
        catch (IOException localIOException4) {}
      }
    }
  }
}
