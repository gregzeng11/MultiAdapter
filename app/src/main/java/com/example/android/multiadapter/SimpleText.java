/*
 * Copyright 2016 drakeet. https://github.com/drakeet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.multiadapter;

import androidx.annotation.NonNull;

/**
 * created by zyh
 * on 2019-10-11
 */
public class SimpleText extends SimpleContent {

  public static final String TYPE = "simple_text";
  public @NonNull
  String text;


  public SimpleText(@NonNull String text) {
    super(TYPE);
    this.text = text;
  }
}
