package com.moat.analytics.mobile.kiip;

import java.util.HashMap;
import java.util.Map;













public class MoatAdEvent
{
  static final Integer ˏ = Integer.valueOf(Integer.MIN_VALUE);
  private static final Double ˋ = Double.valueOf(NaN.0D);
  
  public static final Double VOLUME_MUTED = Double.valueOf(0.0D);
  public static final Double VOLUME_UNMUTED = Double.valueOf(1.0D);
  
  Integer ˊ;
  
  Double ˎ;
  
  private final Double ʽ;
  private final Long ʼ;
  MoatAdEventType ॱ;
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType, Integer paramInteger, Double paramDouble)
  {
    ʼ = Long.valueOf(System.currentTimeMillis());
    ॱ = paramMoatAdEventType;
    ˎ = paramDouble;
    ˊ = paramInteger;
    ʽ = Double.valueOf(p.ॱ());
  }
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType, Integer paramInteger) {
    this(paramMoatAdEventType, paramInteger, ˋ);
  }
  
  public MoatAdEvent(MoatAdEventType paramMoatAdEventType) {
    this(paramMoatAdEventType, ˏ, ˋ);
  }
  
  final Map<String, Object> ॱ() {
    HashMap localHashMap;
    (localHashMap = new HashMap()).put("adVolume", ˎ);
    localHashMap.put("playhead", ˊ);
    localHashMap.put("aTimeStamp", ʼ);
    localHashMap.put("type", ॱ.toString());
    localHashMap.put("deviceVolume", ʽ);
    return localHashMap;
  }
}
