package com.moat.analytics.mobile.kiip;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;








final class w
  extends d
  implements ReactiveVideoTracker
{
  private Integer ˏॱ;
  
  public w(String paramString)
  {
    super(paramString);
    b.ˏ(3, "ReactiveVideoTracker", this, "Initializing.");
    b.ˎ("[SUCCESS] ", "ReactiveVideoTracker created");
  }
  
  final String ˊ()
  {
    return "ReactiveVideoTracker";
  }
  
  final Map<String, Object> ˊॱ() throws o
  {
    HashMap localHashMap = new HashMap();
    View localView = (View)ʼ.get();
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    if (localView != null) {
      localInteger1 = Integer.valueOf(localView.getWidth());
      localInteger2 = Integer.valueOf(localView.getHeight());
    }
    localHashMap.put("duration", ˏॱ);
    localHashMap.put("width", localInteger1);
    localHashMap.put("height", localInteger2);
    return localHashMap;
  }
  
  public final boolean trackVideoAd(Map<String, String> paramMap, Integer paramInteger, View paramView)
  {
    try {
      ˋ();
      ˏ();
      ˏॱ = paramInteger;
      return super.ˋ(paramMap, paramView);
    } catch (Exception paramMap) {
      ॱ("trackVideoAd", paramMap);
    }
    return false;
  }
  
  final JSONObject ˋ(MoatAdEvent paramMoatAdEvent)
  {
    if ((ॱ == MoatAdEventType.AD_EVT_COMPLETE) && (!ˊ.equals(MoatAdEvent.ˏ)) && 
      (!ˋ(ˊ, ˏॱ))) {
      ॱ = MoatAdEventType.AD_EVT_STOPPED;
    }
    
    return super.ˋ(paramMoatAdEvent);
  }
  
  final void ˏ(List<String> paramList) throws o
  {
    if (ˏॱ.intValue() < 1000) {
      throw new o(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[] { ˏॱ }));
    }
    super.ˏ(paramList);
  }
}
