// Generated code from Butter Knife. Do not modify!
package com.example.solsticeprogrammingchallenge;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsActivity_ViewBinding implements Unbinder {
  private ContactsActivity target;

  @UiThread
  public ContactsActivity_ViewBinding(ContactsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactsActivity_ViewBinding(ContactsActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.favouriteContactsTV = Utils.findRequiredViewAsType(source, R.id.favouriteContactsTV, "field 'favouriteContactsTV'", TextView.class);
    target.otherContactsTV = Utils.findRequiredViewAsType(source, R.id.contactsTV, "field 'otherContactsTV'", TextView.class);
    target.favouriteListView = Utils.findRequiredViewAsType(source, R.id.favouriteContactsListView, "field 'favouriteListView'", ListView.class);
    target.otherContactsListView = Utils.findRequiredViewAsType(source, R.id.contactsListView, "field 'otherContactsListView'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.favouriteContactsTV = null;
    target.otherContactsTV = null;
    target.favouriteListView = null;
    target.otherContactsListView = null;
  }
}
