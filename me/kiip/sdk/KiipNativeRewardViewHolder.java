package me.kiip.sdk;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class KiipNativeRewardViewHolder extends RecyclerView.ViewHolder
{
  public KiipNativeRewardView nativeRewardView;
  
  public KiipNativeRewardViewHolder(View view, int viewId)
  {
    this(view, viewId, KiipNativeRewardView.RewardViewType.MEDIUM_RECTANGLE);
  }
  
  public KiipNativeRewardViewHolder(View view, int viewId, KiipNativeRewardView.RewardViewType type) {
    super(view);
    nativeRewardView = ((KiipNativeRewardView)view.findViewById(viewId));
    nativeRewardView.setRewardViewType(type);
  }
  
  public static RecyclerView.ViewHolder Create(android.content.Context c, View view, int viewId, KiipNativeRewardView.RewardViewType type) {
    KiipNativeRewardViewHolder localKiipNativeRewardViewHolder = new KiipNativeRewardViewHolder(view, viewId, type);
    return localKiipNativeRewardViewHolder;
  }
  
  public boolean isRewardLoaded() {
    return nativeRewardView.isRewardRendered();
  }
  
  public void unregisterView() {
    if (nativeRewardView != null) {
      nativeRewardView.removeAllViews();
    }
  }
}
