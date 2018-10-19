package me.kiip.internal.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.kiip.internal.a.a;
import me.kiip.internal.a.g;
import me.kiip.internal.a.n;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;






































public abstract class b
  implements i
{
  public b() {}
  
  public abstract h a(n<?> paramN, Map<String, String> paramMap)
    throws IOException, a;
  
  @Deprecated
  public final HttpResponse b(n<?> paramN, Map<String, String> paramMap)
    throws IOException, a
  {
    h localH = a(paramN, paramMap);
    
    ProtocolVersion localProtocolVersion = new ProtocolVersion("HTTP", 1, 1);
    
    BasicStatusLine localBasicStatusLine = new BasicStatusLine(localProtocolVersion, localH.a(), "");
    BasicHttpResponse localBasicHttpResponse = new BasicHttpResponse(localBasicStatusLine);
    
    ArrayList localArrayList = new ArrayList();
    for (Object localObject1 = localH.b().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (g)((Iterator)localObject1).next();
      localArrayList.add(new BasicHeader(((g)localObject2).a(), ((g)localObject2).b())); }
    Object localObject2;
    localBasicHttpResponse.setHeaders((Header[])localArrayList.toArray(new Header[localArrayList.size()]));
    
    localObject1 = localH.d();
    if (localObject1 != null) {
      localObject2 = new BasicHttpEntity();
      ((BasicHttpEntity)localObject2).setContent((InputStream)localObject1);
      ((BasicHttpEntity)localObject2).setContentLength(localH.c());
      localBasicHttpResponse.setEntity((HttpEntity)localObject2);
    }
    
    return localBasicHttpResponse;
  }
}
