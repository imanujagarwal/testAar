package me.kiip.internal.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
























public class k
{
  public final int a;
  public final byte[] b;
  public final Map<String, String> c;
  public final List<g> d;
  public final boolean e;
  public final long f;
  
  @Deprecated
  public k(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this(paramInt, paramArrayOfByte, paramMap, a(paramMap), paramBoolean, paramLong);
  }
  








  public k(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong, List<g> paramList)
  {
    this(paramInt, paramArrayOfByte, a(paramList), paramList, paramBoolean, paramLong);
  }
  































  @Deprecated
  public k(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
  
  private k(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, List<g> paramList, boolean paramBoolean, long paramLong)
  {
    a = paramInt;
    b = paramArrayOfByte;
    c = paramMap;
    if (paramList == null) {
      d = null;
    } else {
      d = Collections.unmodifiableList(paramList);
    }
    e = paramBoolean;
    f = paramLong;
  }
  

























  private static Map<String, String> a(List<g> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    
    for (g localG : paramList) {
      localTreeMap.put(localG.a(), localG.b());
    }
    return localTreeMap;
  }
  
  private static List<g> a(Map<String, String> paramMap) {
    if (paramMap == null) {
      return null;
    }
    if (paramMap.isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramMap.size());
    for (Map.Entry localEntry : paramMap.entrySet()) {
      localArrayList.add(new g((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
}
