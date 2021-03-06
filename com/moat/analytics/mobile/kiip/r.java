package com.moat.analytics.mobile.kiip;

import android.graphics.Rect;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;













final class r
  extends c
  implements NativeDisplayTracker
{
  private final Map<String, String> ʼ;
  private final Set<NativeDisplayTracker.MoatUserInteractionType> ʻ = new HashSet();
  
  r(View paramView, Map<String, String> paramMap)
  {
    super(paramView, true, false);
    b.ˏ(3, "NativeDisplayTracker", this, "Initializing.");
    ʼ = paramMap;
    Object localObject;
    r localR; String str2; String str1; if (paramView == null) {
      paramView = "Target view is null";
      paramMap = "NativeDisplayTracker initialization not successful, " + paramView;
      localObject = paramMap;localR = this;str2 = "NativeDisplayTracker";str1 = "[ERROR] ";
      



















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      b.ˏ(3, str2, localR, (String)localObject);
      b.ˎ(str1, (String)localObject);ˋ = new o(paramView);return; }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      paramView = "AdIds is null or empty";
      paramMap = "NativeDisplayTracker initialization not successful, " + paramView;
      localObject = paramMap;localR = this;str2 = "NativeDisplayTracker";str1 = "[ERROR] ";
      





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      b.ˏ(3, str2, localR, (String)localObject);
      b.ˎ(str1, (String)localObject);ˋ = new o("AdIds is null or empty");return;
    }
    
    if ((paramView = getInstanceˊ) == null) {
      paramMap = "prepareNativeDisplayTracking was not called successfully";
      paramView = "NativeDisplayTracker initialization not successful, " + paramMap;
      localObject = paramView;localR = this;str2 = "NativeDisplayTracker";str1 = "[ERROR] ";
      





















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      b.ˏ(3, str2, localR, (String)localObject);
      b.ˎ(str1, (String)localObject);ˋ = new o(paramMap);return;
    }
    













































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    ˏ = ˋ;
    try
    {
      super.ˋ(ˏ);
      





































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      paramView = this; if (ˏ != null) {
        ˏ.ˊ(paramView.ᐝ());
      }
      b.ˎ("[SUCCESS] ", "NativeDisplayTracker created for " + ʽ() + ", with adIds:" + paramMap
        .toString()); return;
    } catch (o paramMap) {
      ˋ = paramMap;
    }
  }
  


  final String ˊ()
  {
    return "NativeDisplayTracker";
  }
  
  public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType paramMoatUserInteractionType)
  {
    try {
      b.ˏ(3, "NativeDisplayTracker", this, "reportUserInteractionEvent:" + paramMoatUserInteractionType.name());
      if (!ʻ.contains(paramMoatUserInteractionType)) {
        ʻ.add(paramMoatUserInteractionType);
        JSONObject localJSONObject;
        (localJSONObject = new JSONObject()).accumulate("adKey", ˎ);
        localJSONObject.accumulate("event", paramMoatUserInteractionType.name().toLowerCase());
        if (ˏ != null)
          ˏ.ˋ(localJSONObject.toString());
      }
      return;
    } catch (JSONException localJSONException) {
      b.ˏ("NativeDisplayTracker", this, "Got JSON exception");
      o.ॱ(localJSONException); return;
    } catch (Exception localException) {
      o.ॱ(
        localException;
    }
  }
  





  private String ᐝ()
  {
    String str1 = "";
    try {
      Object localObject = ʼ;
      
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      String str2; for (int i = 0; i < 8; i++) {
        str2 = "moatClientLevel" + i;
        if (((Map)localObject).containsKey(str2)) {
          localLinkedHashMap.put(str2, ((Map)localObject).get(str2));
        }
      }
      for (i = 0; i < 8; i++) {
        str2 = "moatClientSlicer" + i;
        if (((Map)localObject).containsKey(str2)) {
          localLinkedHashMap.put(str2, ((Map)localObject).get(str2));
        }
      }
      for (Iterator localIterator = ((Map)localObject).keySet().iterator(); localIterator.hasNext();) { str2 = (String)localIterator.next();
        if (!localLinkedHashMap.containsKey(str2)) {
          String str3 = (String)((Map)localObject).get(str2);
          localLinkedHashMap.put(str2, str3);
        }
      }
      localObject = 
      



















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        new JSONObject(localLinkedHashMap).toString();b.ˏ(3, "NativeDisplayTracker", this, "Parsed ad ids = " + (String)localObject);str1 = "{\"adIds\":" + (String)localObject + ", \"adKey\":\"" + ˎ + "\", \"adSize\":" + ˊॱ() + "}";
    }
    catch (Exception localException)
    {
      o.ॱ(
        localException; }
    return str1;
  }
  
  private String ˊॱ()
  {
    try {
      Rect localRect;
      int j = (localRect = y.ˏ(super.ʻ())).width();
      int i = localRect.height();
      HashMap localHashMap;
      (localHashMap = new HashMap()).put("width", Integer.toString(j));
      localHashMap.put("height", Integer.toString(i));
      return new JSONObject(localHashMap).toString();
    } catch (Exception localException) {
      o.ॱ(localException;
    }
    return null;
  }
}
