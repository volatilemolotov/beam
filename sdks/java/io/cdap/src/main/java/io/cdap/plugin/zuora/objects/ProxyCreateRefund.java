/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import javax.annotation.Nullable;

/** Object name: ProxyCreateRefund (ProxyCreateRefund). Related objects: */
@SuppressWarnings("unused")
@ObjectDefinition(
    Name = "ProxyCreateRefund",
    ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED)
public class ProxyCreateRefund extends BaseObject {
  /**
   * Name: AccountId (AccountId), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /** Name: Amount (Amount), Type: number. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
   * Name: Comment (Comment), Type: string. Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
   * Name: GatewayOptionData (GatewayOptionData), Type: ProxyCreateRefundGatewayOptionDataItem.
   * Options (custom, update, select): false, false, false
   */
  @Nullable
  @SerializedName("gatewayOptionData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayOptionData;

  /**
   * Name: GatewayState (GatewayState), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("gatewayState")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String gatewayState;

  /**
   * Name: MethodType (MethodType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("methodType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String methodType;

  /**
   * Name: PaymentMethodId (PaymentMethodId), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("paymentMethodId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentMethodId;

  /**
   * Name: ReasonCode (ReasonCode), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
   * Name: RefundDate (RefundDate), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("refundDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundDate;

  /**
   * Name: RefundInvoicePaymentData (RefundInvoicePaymentData), Type:
   * ProxyCreateRefundRefundInvoicePaymentDataItem. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("refundInvoicePaymentData")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundInvoicePaymentData;

  /**
   * Name: SoftDescriptor (SoftDescriptor), Type: string. Options (custom, update, select): false,
   * false, false
   */
  @Nullable
  @SerializedName("softDescriptor")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptor;

  /**
   * Name: SoftDescriptorPhone (SoftDescriptorPhone), Type: string. Options (custom, update,
   * select): false, false, false
   */
  @Nullable
  @SerializedName("softDescriptorPhone")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String softDescriptorPhone;

  /**
   * Name: SourceType (SourceType), Type: string. Options (custom, update, select): false, false,
   * false
   */
  @Nullable
  @SerializedName("sourceType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceType;

  /** Name: Type (Type), Type: string. Options (custom, update, select): false, false, false */
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;

  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("gatewayOptionData", gatewayOptionData, String.class);
    addCustomField("gatewayState", gatewayState, String.class);
    addCustomField("methodType", methodType, String.class);
    addCustomField("paymentMethodId", paymentMethodId, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("refundDate", refundDate, String.class);
    addCustomField("refundInvoicePaymentData", refundInvoicePaymentData, String.class);
    addCustomField("softDescriptor", softDescriptor, String.class);
    addCustomField("softDescriptorPhone", softDescriptorPhone, String.class);
    addCustomField("sourceType", sourceType, String.class);
    addCustomField("type", type, String.class);
  }
}
