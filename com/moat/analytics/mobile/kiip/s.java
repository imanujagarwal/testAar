package com.moat.analytics.mobile.kiip;

import android.support.annotation.VisibleForTesting;
import com.moat.analytics.mobile.kiip.base.asserts.Asserts;
import com.moat.analytics.mobile.kiip.base.functional.Optional;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;















class s<T>
  implements InvocationHandler
{
  private static final Object[] ˊ = new Object[0];
  
  private final a<T> ॱ;
  private final Class<T> ˎ;
  private final LinkedList<s<T>.e> ˋ;
  private boolean ˏ;
  private T ᐝ;
  
  private class e
  {
    private final WeakReference[] ˎ;
    private final LinkedList<Object> ˋ = new LinkedList();
    private final Method ˊ;
    
    private e(Method paramMethod, Object... paramVarArgs) {
      if (paramVarArgs == null) paramVarArgs = s.ˊ();
      this$1 = new WeakReference[paramVarArgs.length];
      int i = 0;
      int j = (paramVarArgs = paramVarArgs).length; for (int k = 0; k < j; k++) { Object localObject;
        if ((((localObject = paramVarArgs[k]) instanceof Map)) || ((localObject instanceof Integer)) || ((localObject instanceof Double)))
        {

          ˋ.add(localObject);
        }
        s.this[(i++)] = new WeakReference(localObject);
      }
      ˎ = s.this;
      ˊ = paramMethod;
    }
  }
  







  @VisibleForTesting
  private s(a<T> paramA, Class<T> paramClass)
    throws o
  {
    Asserts.checkNotNull(paramA);
    Asserts.checkNotNull(paramClass);
    ॱ = paramA;
    ˎ = paramClass;
    


    ˋ = new LinkedList();
    t.ˋ().ॱ(new t.a()
    {
      public final void ॱ() throws o {
        s.ॱ(s.this);
      }
    });
  }
  



















  static <T> T ˊ(a<T> paramA, Class<T> paramClass)
    throws o
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramA = new s(paramA, paramClass);
    
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, paramA);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable
  {
    try {
      Object localObject1 = paramArrayOfObject;paramArrayOfObject = paramMethod;paramObject = this;
      














































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































      Object localObject2 = paramArrayOfObject.getDeclaringClass();
      t localT = t.ˋ();
      if (Object.class.equals(localObject2)) {
        localObject2 = paramArrayOfObject.getName();
        if ("getClass".equals(localObject2)) {
          return ˎ;
        }
        if ("toString".equals(localObject2)) {
          paramArrayOfObject = paramArrayOfObject.invoke(paramObject, (Object[])localObject1);
          localObject1 = s.class.getName();
          paramObject = ˎ.getName();
          return String.valueOf(paramArrayOfObject).replace((CharSequence)localObject1, paramObject);
        }
        
        return paramArrayOfObject.invoke(paramObject, (Object[])localObject1);
      }
      if ((ˏ) && (ᐝ == null))
      {
        ˋ.clear();
        return ˊ(paramArrayOfObject);
      }
      if (ˋ == t.c.ॱ) {
        paramObject.ˋ();
        if (ᐝ != null) {
          return paramArrayOfObject.invoke(ᐝ, (Object[])localObject1);
        }
      }
      if ((ˋ == t.c.ˊ) && (
        (!ˏ) || (ᐝ != null))) {
        localObject2 = localObject1;localObject1 = paramArrayOfObject;
        








































        if (ˋ.size() >= 15) {
          ˋ.remove(5);
        }
        ˋ.add(new e(paramObject, (Method)localObject1, (Object[])localObject2, (byte)0));
      }
      return 
      














































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        ˊ(paramArrayOfObject);
    }
    catch (Exception localException)
    {
      o.ॱ(localException; }
    return ˊ(paramMethod);
  }
  



















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  private void ˋ()
    throws o
  {
    Object localObject = this; if (!ˏ) {
      try {
        Optional localOptional = ॱ.ˏ();
        ᐝ = localOptional.orElse(null);
      } catch (Exception localException1) {
        b.ˊ("OnOffTrackerProxy", localObject, "Could not create instance", localException1);
        o.ॱ(localException1);
      }
      ˏ = true;
    }
    if (ᐝ == null) {
      return;
    }
    
    for (localObject = ˋ.iterator(); ((Iterator)localObject).hasNext();) { e localE = (e)((Iterator)localObject).next();
      try {
        Object[] arrayOfObject = new Object[e.ˏ(localE).length];
        int i = 0;
        for (WeakReference localWeakReference : e.ˏ(localE)) {
          arrayOfObject[(i++)] = localWeakReference.get();
        }
        e.ॱ(localE).invoke(ᐝ, arrayOfObject);
      } catch (Exception localException2) {
        o.ॱ(
          localException2;
      } }
    ˋ.clear();
  }
  






  private static Boolean ˊ(Method paramMethod)
  {
    try
    {
      if (Boolean.TYPE.equals(paramMethod.getReturnType())) {
        return Boolean.valueOf(true);
      }
    } catch (Exception localException) {
      o.ॱ(
        localException;
    }
    return null;
  }
  
  static abstract interface a<T>
  {
    public abstract Optional<T> ˏ()
      throws o;
  }
}
