/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

import javax.annotation.Nullable;

/**
 * Basic type of animated node that maps directly from {@code Animated.Value(x)} of Animated.js
 * library.
 */
/*package*/ class ValueAnimatedNode extends AnimatedNode {
  /*package*/ Object mAnimatedObject = null;
  /*package*/ double mValue = Double.NaN;
  /*package*/ double mOffset = 0;
  private @Nullable AnimatedNodeValueListener mValueListener;

  public ValueAnimatedNode() {
    // empty constructor that can be used by subclasses
  }

  public ValueAnimatedNode(ReadableMap config) {
    mValue = config.getDouble("value");
    mOffset = config.getDouble("offset");
  }

  public double getValue() {
    return mOffset + mValue;
  }

  public Object getAnimatedObject() {
    return mAnimatedObject;
  }

  public void flattenOffset() {
    mValue += mOffset;
    mOffset = 0;
  }

  public void extractOffset() {
    mOffset += mValue;
    mValue = 0;
  }

  public void onValueUpdate() {
    if (mValueListener == null) {
      return;
    }
    mValueListener.onValueUpdate(getValue());
  }

  public void setValueListener(@Nullable AnimatedNodeValueListener listener) {
    mValueListener = listener;
  }
}
