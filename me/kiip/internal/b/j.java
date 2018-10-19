package me.kiip.internal.b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import me.kiip.internal.a.a;
import me.kiip.internal.a.g;
import me.kiip.internal.a.n;































public class j
  extends b
{
  private final a a;
  private final SSLSocketFactory b;
  
  public j()
  {
    this(null);
  }
  


  public j(a paramA)
  {
    this(paramA, null);
  }
  



  public j(a paramA, SSLSocketFactory paramSSLSocketFactory)
  {
    a = paramA;
    b = paramSSLSocketFactory;
  }
  
  public h a(n<?> paramN, Map<String, String> paramMap)
    throws IOException, a
  {
    Object localObject1 = paramN.c();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramN.g());
    localHashMap.putAll(paramMap);
    if (a != null) {
      localObject2 = a.a((String)localObject1);
      if (localObject2 == null) {
        throw new IOException("URL blocked by rewriter: " + (String)localObject1);
      }
      localObject1 = localObject2;
    }
    Object localObject2 = new URL((String)localObject1);
    HttpURLConnection localHttpURLConnection = a((URL)localObject2, paramN);
    for (String str : localHashMap.keySet()) {
      localHttpURLConnection.addRequestProperty(str, (String)localHashMap.get(str));
    }
    a(localHttpURLConnection, paramN);
    
    int i = localHttpURLConnection.getResponseCode();
    if (i == -1)
    {

      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
    
    if (!a(paramN.a(), i)) {
      return new h(i, a(localHttpURLConnection.getHeaderFields()));
    }
    
    return new h(i, a(localHttpURLConnection.getHeaderFields()), localHttpURLConnection
      .getContentLength(), a(localHttpURLConnection));
  }
  
  static List<g> a(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    for (Iterator localIterator1 = paramMap.entrySet().iterator(); localIterator1.hasNext();) { localEntry = (Map.Entry)localIterator1.next();
      

      if (localEntry.getKey() != null) {
        for (String str : (List)localEntry.getValue())
          localArrayList.add(new g((String)localEntry.getKey(), str));
      }
    }
    Map.Entry localEntry;
    return localArrayList;
  }
  






  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304);
  }
  



  private static InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    InputStream localInputStream;
    


    try
    {
      localInputStream = paramHttpURLConnection.getInputStream();
    } catch (IOException localIOException) {
      localInputStream = paramHttpURLConnection.getErrorStream();
    }
    return localInputStream;
  }
  

  protected HttpURLConnection a(URL paramURL)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    



    localHttpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    
    return localHttpURLConnection;
  }
  




  private HttpURLConnection a(URL paramURL, n<?> paramN)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = a(paramURL);
    
    int i = paramN.s();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    

    if (("https".equals(paramURL.getProtocol())) && (b != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(b);
    }
    
    return localHttpURLConnection;
  }
  
  static void a(HttpURLConnection paramHttpURLConnection, n<?> paramN)
    throws IOException, a
  {
    switch (paramN.a())
    {


    case -1: 
      byte[] arrayOfByte = paramN.k();
      if (arrayOfByte != null) {
        paramHttpURLConnection.setRequestMethod("POST");
        a(paramHttpURLConnection, paramN, arrayOfByte);
      }
      

      break;
    case 0: 
      paramHttpURLConnection.setRequestMethod("GET");
      break;
    case 3: 
      paramHttpURLConnection.setRequestMethod("DELETE");
      break;
    case 1: 
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramN);
      break;
    case 2: 
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramN);
      break;
    case 4: 
      paramHttpURLConnection.setRequestMethod("HEAD");
      break;
    case 5: 
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      break;
    case 6: 
      paramHttpURLConnection.setRequestMethod("TRACE");
      break;
    case 7: 
      paramHttpURLConnection.setRequestMethod("PATCH");
      b(paramHttpURLConnection, paramN);
      break;
    default: 
      throw new IllegalStateException("Unknown method type.");
    }
    
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, n<?> paramN) throws IOException, a {
    byte[] arrayOfByte = paramN.o();
    if (arrayOfByte != null) {
      a(paramHttpURLConnection, paramN, arrayOfByte);
    }
  }
  


  private static void a(HttpURLConnection paramHttpURLConnection, n<?> paramN, byte[] paramArrayOfByte)
    throws IOException, a
  {
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.addRequestProperty("Content-Type", paramN
      .n());
    DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    localDataOutputStream.write(paramArrayOfByte);
    localDataOutputStream.close();
  }
  
  public static abstract interface a
  {
    public abstract String a(String paramString);
  }
}
