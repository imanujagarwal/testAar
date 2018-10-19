package me.kiip.internal.b;

import java.io.IOException;
import java.util.Map;
import me.kiip.internal.a.a;
import me.kiip.internal.a.n;
import org.apache.http.HttpResponse;

@Deprecated
public abstract interface i
{
  public abstract HttpResponse b(n<?> paramN, Map<String, String> paramMap)
    throws IOException, a;
}
