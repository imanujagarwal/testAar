package me.kiip.internal.b;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.kiip.internal.a.g;
import me.kiip.internal.a.n;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;




















class a
  extends b
{
  private final i a;
  
  a(i paramI)
  {
    a = paramI;
  }
  
  public h a(n<?> paramN, Map<String, String> paramMap)
    throws IOException, me.kiip.internal.a.a
  {
    HttpResponse localHttpResponse;
    try
    {
      localHttpResponse = a.b(paramN, paramMap);
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      throw new SocketTimeoutException(localConnectTimeoutException.getMessage());
    }
    
    int i = localHttpResponse.getStatusLine().getStatusCode();
    
    Header[] arrayOfHeader1 = localHttpResponse.getAllHeaders();
    ArrayList localArrayList = new ArrayList(arrayOfHeader1.length);
    for (Header localHeader : arrayOfHeader1) {
      localArrayList.add(new g(localHeader.getName(), localHeader.getValue()));
    }
    
    if (localHttpResponse.getEntity() == null) {
      return new h(i, localArrayList);
    }
    
    long l = localHttpResponse.getEntity().getContentLength();
    if ((int)l != l) {
      throw new IOException("Response too large: " + l);
    }
    
    return new h(i, localArrayList, 
    

      (int)localHttpResponse.getEntity().getContentLength(), localHttpResponse
      .getEntity().getContent());
  }
}
