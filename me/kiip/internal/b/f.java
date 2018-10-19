package me.kiip.internal.b;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import me.kiip.internal.a.a;
import me.kiip.internal.a.n;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;






























@Deprecated
public class f
  implements i
{
  protected final HttpClient a;
  
  public f(HttpClient paramHttpClient)
  {
    a = paramHttpClient;
  }
  
  private static void a(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap) {
    for (String str : paramMap.keySet()) {
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  









  public HttpResponse b(n<?> paramN, Map<String, String> paramMap)
    throws IOException, a
  {
    HttpUriRequest localHttpUriRequest = a(paramN, paramMap);
    a(localHttpUriRequest, paramMap);
    a(localHttpUriRequest, paramN.g());
    a(localHttpUriRequest);
    HttpParams localHttpParams = localHttpUriRequest.getParams();
    int i = paramN.s();
    

    HttpConnectionParams.setConnectionTimeout(localHttpParams, 5000);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    return a.execute(localHttpUriRequest);
  }
  

  static HttpUriRequest a(n<?> paramN, Map<String, String> paramMap)
    throws a
  {
    Object localObject;
    
    switch (paramN.a())
    {


    case -1: 
      localObject = paramN.k();
      if (localObject != null) {
        HttpPost localHttpPost = new HttpPost(paramN.c());
        localHttpPost.addHeader("Content-Type", paramN.j());
        
        ByteArrayEntity localByteArrayEntity = new ByteArrayEntity((byte[])localObject);
        localHttpPost.setEntity(localByteArrayEntity);
        return localHttpPost;
      }
      return new HttpGet(paramN.c());
    

    case 0: 
      return new HttpGet(paramN.c());
    case 3: 
      return new HttpDelete(paramN.c());
    case 1: 
      localObject = new HttpPost(paramN.c());
      ((HttpPost)localObject).addHeader("Content-Type", paramN.n());
      a((HttpEntityEnclosingRequestBase)localObject, paramN);
      return localObject;
    
    case 2: 
      localObject = new HttpPut(paramN.c());
      ((HttpPut)localObject).addHeader("Content-Type", paramN.n());
      a((HttpEntityEnclosingRequestBase)localObject, paramN);
      return localObject;
    
    case 4: 
      return new HttpHead(paramN.c());
    case 5: 
      return new HttpOptions(paramN.c());
    case 6: 
      return new HttpTrace(paramN.c());
    case 7: 
      localObject = new a(paramN.c());
      ((a)localObject).addHeader("Content-Type", paramN.n());
      a((HttpEntityEnclosingRequestBase)localObject, paramN);
      return localObject;
    }
    
    throw new IllegalStateException("Unknown request method.");
  }
  
  private static void a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, n<?> paramN)
    throws a
  {
    byte[] arrayOfByte = paramN.o();
    if (arrayOfByte != null) {
      ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(arrayOfByte);
      paramHttpEntityEnclosingRequestBase.setEntity(localByteArrayEntity);
    }
  }
  







  protected void a(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {}
  






  public static final class a
    extends HttpEntityEnclosingRequestBase
  {
    public a() {}
    






    public a(String paramString)
    {
      setURI(URI.create(paramString));
    }
    
    public String getMethod()
    {
      return "PATCH";
    }
  }
}
