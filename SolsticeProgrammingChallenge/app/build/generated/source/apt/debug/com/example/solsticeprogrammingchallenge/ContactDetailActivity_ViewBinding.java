// Generated code from Butter Knife. Do not modify!
package com.example.solsticeprogrammingchallenge;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactDetailActivity_ViewBinding implements Unbinder {
  private ContactDetailActivity target;

  @UiThread
  public ContactDetailActivity_ViewBinding(ContactDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactDetailActivity_ViewBinding(ContactDetailActivity target, View source) {
    this.target = target;

    target.contactImageView = Utils.findRequiredViewAsType(source, R.id.largeImageView, "field 'contactImageView'", ImageView.class);
    target.nametv = Utils.findRequiredViewAsType(source, R.id.nametv, "field 'nametv'", TextView.class);
    target.companyNametv = Utils.findRequiredViewAsType(source, R.id.companyNametv, "field 'companyNametv'", TextView.class);
    target.infoListView = Utils.findRequiredViewAsType(source, R.id.infoListView, "field 'infoListView'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactImageView = null;
    target.nametv = null;
    target.companyNametv = null;
    target.infoListView = null;
  }
}
