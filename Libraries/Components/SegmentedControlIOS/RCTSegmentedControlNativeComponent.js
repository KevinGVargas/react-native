/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 *
 * @flow
 * @format
 */
'use strict';

import codegenNativeComponent from '../../Utilities/codegenNativeComponent';
import type {ViewProps} from '../View/ViewPropTypes';
import type {BubblingEvent, WithDefault, Int32} from '../../Types/CodegenTypes';
import type {ColorValue} from '../../StyleSheet/StyleSheetTypes';

export type OnChangeEvent = BubblingEvent<
  $ReadOnly<{|
    value: Int32,
    selectedSegmentIndex: Int32,
  |}>,
>;

type NativeProps = $ReadOnly<{|
  ...ViewProps,

  // Props
  values?: $ReadOnlyArray<string>,
  selectedIndex?: ?WithDefault<Int32, 0>,
  enabled?: ?WithDefault<boolean, true>,
  tintColor?: ?ColorValue,
  momentary?: ?WithDefault<boolean, false>,

  // Events
  onChange?: ?(event: OnChangeEvent) => mixed,
|}>;

export default codegenNativeComponent<NativeProps>('RCTSegmentedControl');
