package com.moat.analytics.mobile.kiip.base.functional;

import java.util.NoSuchElementException;











public final class Optional<T>
{
  private static final Optional<?> ˏ = new Optional();
  




  private final T ˋ;
  




  private Optional()
  {
    ˋ = null;
  }
  













  public static <T> Optional<T> empty()
  {
    return ˏ;
  }
  





  private Optional(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException("Optional of null value.");
    ˋ = paramT;
  }
  







  public static <T> Optional<T> of(T paramT)
  {
    return new Optional(paramT);
  }
  









  public static <T> Optional<T> ofNullable(T paramT)
  {
    if (paramT == null) return empty(); return of(paramT);
  }
  








  public final T get()
  {
    if (ˋ == null) {
      throw new NoSuchElementException("No value present");
    }
    return ˋ;
  }
  




  public final boolean isPresent()
  {
    return ˋ != null;
  }
  






  public final T orElse(T paramT)
  {
    if (ˋ != null) return ˋ; return paramT;
  }
  













  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    
    if (!(paramObject instanceof Optional)) {
      return false;
    }
    
    paramObject = (Optional)paramObject;
    
    return (ˋ == ˋ) || ((ˋ != null) && (ˋ != null) && (ˋ.equals(ˋ)));
  }
  







  public final int hashCode()
  {
    if (ˋ == null) return 0; return ˋ.hashCode();
  }
  











  public final String toString()
  {
    if (ˋ != null)
      return String.format("Optional[%s]", new Object[] { ˋ }); return "Optional.empty";
  }
}
