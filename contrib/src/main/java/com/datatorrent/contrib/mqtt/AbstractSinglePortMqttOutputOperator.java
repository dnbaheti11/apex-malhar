/*
 * Copyright (c) 2013 DataTorrent, Inc. ALL Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datatorrent.contrib.mqtt;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.annotation.InputPortFieldAnnotation;

/**
 * This is an abstract output adapter for MQTT.&nbsp;
 * This operator has a single input port.
 * <p>
 * <br>
 * Ports:<br>
 * <b>Input</b>: Can have one input port<br>
 * <b>Output</b>: no output port<br>
 * <br>
 * Properties:<br>
 * None<br>
 * <br>
 * Compile time checks:<br>
 * None<br>
 * <br>
 * Run time checks:<br>
 * None<br>
 * <br>
 * <b>Benchmarks</b>:TBD
 * </p>
 * @displayName Abstract Single Port MQTT Output Operator
 * @category messaging
 * @tags output
 * @since 0.9.3
 */
public abstract class AbstractSinglePortMqttOutputOperator<T> extends AbstractMqttOutputOperator
{
  /**
   * Users need to provide implementation of what to do when encountering a tuple to message(s) to be sent to MQTT
   * @param tuple
   */
  public abstract void processTuple(T tuple);

  /**
   * The input port
   */
  @InputPortFieldAnnotation(name = "in")
  public final transient DefaultInputPort<T> inputPort = new DefaultInputPort<T>()
  {
    @Override
    public void process(T tuple)
    {
      processTuple(tuple); // This is an abstract call
    }
  };
}
