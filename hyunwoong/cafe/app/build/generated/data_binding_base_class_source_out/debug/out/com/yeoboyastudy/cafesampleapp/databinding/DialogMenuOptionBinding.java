// Generated by view binder compiler. Do not edit!
package com.yeoboyastudy.cafesampleapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.yeoboyastudy.cafesampleapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogMenuOptionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView additional;

  @NonNull
  public final TextView cancel;

  @NonNull
  public final TextView complete;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final ConstraintLayout option1;

  @NonNull
  public final ConstraintLayout option2;

  @NonNull
  public final RadioButton radioButton1;

  @NonNull
  public final RadioButton radioButton2;

  @NonNull
  public final RadioButton radioButton3;

  @NonNull
  public final RadioButton radioButton4;

  @NonNull
  public final RadioButton radioButton5;

  @NonNull
  public final RadioGroup radioGroup1;

  @NonNull
  public final RadioGroup radioGroup2;

  @NonNull
  public final TextView temperature;

  private DialogMenuOptionBinding(@NonNull ConstraintLayout rootView, @NonNull TextView additional,
      @NonNull TextView cancel, @NonNull TextView complete, @NonNull ConstraintLayout header,
      @NonNull ConstraintLayout option1, @NonNull ConstraintLayout option2,
      @NonNull RadioButton radioButton1, @NonNull RadioButton radioButton2,
      @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4,
      @NonNull RadioButton radioButton5, @NonNull RadioGroup radioGroup1,
      @NonNull RadioGroup radioGroup2, @NonNull TextView temperature) {
    this.rootView = rootView;
    this.additional = additional;
    this.cancel = cancel;
    this.complete = complete;
    this.header = header;
    this.option1 = option1;
    this.option2 = option2;
    this.radioButton1 = radioButton1;
    this.radioButton2 = radioButton2;
    this.radioButton3 = radioButton3;
    this.radioButton4 = radioButton4;
    this.radioButton5 = radioButton5;
    this.radioGroup1 = radioGroup1;
    this.radioGroup2 = radioGroup2;
    this.temperature = temperature;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogMenuOptionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogMenuOptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_menu_option, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogMenuOptionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.additional;
      TextView additional = ViewBindings.findChildViewById(rootView, id);
      if (additional == null) {
        break missingId;
      }

      id = R.id.cancel;
      TextView cancel = ViewBindings.findChildViewById(rootView, id);
      if (cancel == null) {
        break missingId;
      }

      id = R.id.complete;
      TextView complete = ViewBindings.findChildViewById(rootView, id);
      if (complete == null) {
        break missingId;
      }

      id = R.id.header;
      ConstraintLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.option1;
      ConstraintLayout option1 = ViewBindings.findChildViewById(rootView, id);
      if (option1 == null) {
        break missingId;
      }

      id = R.id.option2;
      ConstraintLayout option2 = ViewBindings.findChildViewById(rootView, id);
      if (option2 == null) {
        break missingId;
      }

      id = R.id.radioButton1;
      RadioButton radioButton1 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton1 == null) {
        break missingId;
      }

      id = R.id.radioButton2;
      RadioButton radioButton2 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton2 == null) {
        break missingId;
      }

      id = R.id.radioButton3;
      RadioButton radioButton3 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton3 == null) {
        break missingId;
      }

      id = R.id.radioButton4;
      RadioButton radioButton4 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton4 == null) {
        break missingId;
      }

      id = R.id.radioButton5;
      RadioButton radioButton5 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton5 == null) {
        break missingId;
      }

      id = R.id.radioGroup1;
      RadioGroup radioGroup1 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup1 == null) {
        break missingId;
      }

      id = R.id.radioGroup2;
      RadioGroup radioGroup2 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup2 == null) {
        break missingId;
      }

      id = R.id.temperature;
      TextView temperature = ViewBindings.findChildViewById(rootView, id);
      if (temperature == null) {
        break missingId;
      }

      return new DialogMenuOptionBinding((ConstraintLayout) rootView, additional, cancel, complete,
          header, option1, option2, radioButton1, radioButton2, radioButton3, radioButton4,
          radioButton5, radioGroup1, radioGroup2, temperature);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
