package com.moat.analytics.mobile.kiip;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.kiip.base.functional.Optional;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;









final class v
{
  private static LinkedHashSet<String> ˎ = new LinkedHashSet();
  
  v() {}
  
  @NonNull
  static Optional<WebView> ˋ(ViewGroup paramViewGroup, boolean paramBoolean) {
    try {
      if (paramViewGroup == null) {
        return Optional.empty();
      }
      if ((paramViewGroup instanceof WebView)) {
        return Optional.of((WebView)paramViewGroup);
      }
      LinkedList localLinkedList;
      (localLinkedList = new LinkedList()).add(paramViewGroup);
      paramViewGroup = null;
      int i = 0;
      label193: while ((!localLinkedList.isEmpty()) && (i < 100)) {
        i++;
        ViewGroup localViewGroup;
        int j = (localViewGroup = (ViewGroup)localLinkedList.poll()).getChildCount();
        for (int k = 0;; k++) { if (k >= j) break label193;
          View localView;
          if (((localView = localViewGroup.getChildAt(k)) instanceof WebView)) {
            b.ˏ(3, "WebViewHound", localView, "Found WebView");
            if ((paramBoolean) || (ॱ(String.valueOf(localView.hashCode())))) {
              if (paramViewGroup == null) {
                paramViewGroup = (WebView)localView;
              } else {
                b.ˏ(3, "WebViewHound", localView, "Ambiguous ad container: multiple WebViews reside within it.");
                b.ˎ("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                paramViewGroup = null;
                break;
              }
            }
          }
          if ((localView instanceof ViewGroup)) {
            localLinkedList.add((ViewGroup)localView);
          }
        }
      }
      return Optional.ofNullable(paramViewGroup);
    } catch (Exception localException) {}
    return Optional.empty();
  }
  
  private static boolean ॱ(String paramString)
  {
    try {
      paramString = ˎ.add(paramString);
      if (ˎ.size() > 50) {
        Iterator localIterator = ˎ.iterator();
        int i = 0;
        while ((i < 25) && (localIterator.hasNext())) {
          localIterator.next();
          localIterator.remove();
          i++;
        }
      }
      b.ˏ(3, "WebViewHound", null, paramString != 0 ? "Newly Found WebView" : "Already Found WebView");
      return paramString;
    } catch (Exception localException) {
      o.ॱ(localException; }
    return false;
  }
}
