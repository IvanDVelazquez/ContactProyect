// Generated code from Butter Knife. Do not modify!
package com.example.solsticeprogrammingchallenge;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactDetailActivity_ViewBinding implements Unbinder {
  private ContactDetailActivity target;

  private View view7f0700a7;

  @UiThread
  public ContactDetailActivity_ViewBinding(ContactDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactDetailActivity_ViewBinding(final ContactDetailActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.contactImageView = Utils.findRequiredViewAsType(source, R.id.largeImageView, "field 'contactImageView'", ImageView.class);
    target.nametv = Utils.findRequiredViewAsType(source, R.id.nametv, "field 'nametv'", TextView.class);
    target.companytv = Utils.findRequiredViewAsType(source, R.id.companytv, "field 'companytv'", TextView.class);
    target.infoListView = Utils.findRequiredViewAsType(source, R.id.infoListView, "field 'infoListView'", ListView.class);
    view = Utils.findRequiredView(source, R.id.starfav, "field 'starfav' and method 'changeStar'");
    target.starfav = Utils.castView(view, R.id.starfav, "field 'starfav'", ImageView.class);
    view7f0700a7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.changeStar();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.contactImageView = null;
    target.nametv = null;
    target.companytv = null;
    target.infoListView = null;
    target.starfav = null;

    view7f0700a7.setOnClickListener(null);
    view7f0700a7 = null;
  }
}
