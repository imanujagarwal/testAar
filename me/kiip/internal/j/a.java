package me.kiip.internal.j;

import android.net.Uri;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import me.kiip.internal.a.k;
import me.kiip.internal.a.p;
import me.kiip.internal.a.p.a;
import me.kiip.internal.a.p.b;
import me.kiip.internal.a.u;
import me.kiip.internal.b.l;
import org.json.JSONException;
import org.json.JSONObject;



public class a
  extends l
{
  private static final DateFormat a = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
  
  static { a.setTimeZone(TimeZone.getTimeZone("UTC")); }
  





  private String b;
  




  private String c;
  




  public a(int paramInt, String paramString, JSONObject paramJSONObject, p.b<JSONObject> paramB, p.a paramA)
  {
    super(paramInt, paramString, paramJSONObject, paramB, paramA);
  }
  

  public void a(String paramString1, String paramString2)
  {
    b = paramString1;
    c = paramString2;
  }
  
  private String x() {
    switch (a()) {
    case -1: 
      return "POST";
    case 0: 
      return "GET";
    case 3: 
      return "DELETE";
    case 1: 
      return "POST";
    case 2: 
      return "PUT";
    }
    throw new IllegalStateException("Unknown method type.");
  }
  
  public Map<String, String> g()
    throws me.kiip.internal.a.a
  {
    HashMap localHashMap = new HashMap();
    
    try
    {
      String str1 = a.format(new Date());
      


      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(c.getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      


      localMessageDigest.update(o());
      String str4 = me.kiip.internal.d.a.a(localMessageDigest.digest(), 2);
      

      String str2 = String.format("%s\n%s\n%s\n%s\n%s", new Object[] {
        x(), str4, 
        
        n(), str1, 
        
        Uri.parse(c()).getPath() });
      

      localMac.init(localSecretKeySpec);
      byte[] arrayOfByte = localMac.doFinal(str2.getBytes());
      String str3 = me.kiip.internal.d.a.a(arrayOfByte, 2);
      
      localHashMap.put("Date", str1);
      localHashMap.put("Content-MD5", str4);
      


      localHashMap.put("Authorization", String.format("KiipV2 %s:%s", new Object[] { b, str3 }));
      

      localHashMap.put("Accept-Encoding", "gzip");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (InvalidKeyException localInvalidKeyException) {}
    



    return localHashMap;
  }
  
  protected p<JSONObject> a(k paramK)
  {
    p localP = super.a(paramK);
    
    if ((a != null) && (((JSONObject)a).has("error"))) {
      return p.a(new me.kiip.internal.i.a(((JSONObject)a).optString("error")));
    }
    
    return localP;
  }
  
  public void b(u paramU)
  {
    String str = null;
    if (a != null) {
      try {
        JSONObject localJSONObject = new JSONObject(new String(a.b));
        str = localJSONObject.optString("error", null);
      }
      catch (JSONException localJSONException) {}
    }
    
    super.b(str != null ? new me.kiip.internal.i.a(str) : paramU);
  }
}
