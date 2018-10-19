package com.moat.analytics.mobile.kiip;









public enum MoatAdEventType
{
  private final String ˋ;
  








  private MoatAdEventType(String paramString)
  {
    ˋ = paramString;
  }
  
  public final String toString()
  {
    return ˋ;
  }
  
  public static MoatAdEventType fromString(String paramString) {
    if (paramString != null) {
      for (MoatAdEventType localMoatAdEventType : values()) {
        if (paramString.equalsIgnoreCase(localMoatAdEventType.toString())) {
          return localMoatAdEventType;
        }
      }
    }
    return null;
  }
}
