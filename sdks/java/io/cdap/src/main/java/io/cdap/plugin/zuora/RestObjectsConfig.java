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
package io.cdap.plugin.zuora;

import io.cdap.plugin.zuora.objects.APaymentGatwayResponse;
import io.cdap.plugin.zuora.objects.ARPaymentType;
import io.cdap.plugin.zuora.objects.ARPaymentTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.ARPaymentTypewithSuccess;
import io.cdap.plugin.zuora.objects.ARPaymentTypewithSuccessFinanceInformationItem;
import io.cdap.plugin.zuora.objects.ARatedResultType;
import io.cdap.plugin.zuora.objects.ARatedResultTypeAdditionalInfoItem;
import io.cdap.plugin.zuora.objects.ARatedUsageResultType;
import io.cdap.plugin.zuora.objects.Account;
import io.cdap.plugin.zuora.objects.AccountCreditCardHolder;
import io.cdap.plugin.zuora.objects.AccountObjectCustomFields;
import io.cdap.plugin.zuora.objects.AccountObjectNSFields;
import io.cdap.plugin.zuora.objects.AccountSummaryInvoiceType;
import io.cdap.plugin.zuora.objects.AccountSummaryPaymentInvoiceType;
import io.cdap.plugin.zuora.objects.AccountSummaryPaymentType;
import io.cdap.plugin.zuora.objects.AccountSummarySubscriptionRatePlanType;
import io.cdap.plugin.zuora.objects.AccountSummarySubscriptionType;
import io.cdap.plugin.zuora.objects.AccountSummaryType;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeBasicInfo;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeBasicInfoAdditionalEmailAddressesItem;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeBasicInfoDefaultPaymentMethodItem;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeBillToContact;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeSoldToContact;
import io.cdap.plugin.zuora.objects.AccountSummaryTypeTaxInfoItem;
import io.cdap.plugin.zuora.objects.AccountSummaryUsageType;
import io.cdap.plugin.zuora.objects.AccountType;
import io.cdap.plugin.zuora.objects.AccountTypeBasicInfo;
import io.cdap.plugin.zuora.objects.AccountTypeBillToContact;
import io.cdap.plugin.zuora.objects.AccountTypeBillingAndPaymentItem;
import io.cdap.plugin.zuora.objects.AccountTypeBillingAndPaymentItemAdditionalEmailAddressesItem;
import io.cdap.plugin.zuora.objects.AccountTypeMetricsItem;
import io.cdap.plugin.zuora.objects.AccountTypeSoldToContact;
import io.cdap.plugin.zuora.objects.AccountTypeTaxInfoItem;
import io.cdap.plugin.zuora.objects.AccountingCodeItemType;
import io.cdap.plugin.zuora.objects.AccountingCodeItemWithoutSuccessType;
import io.cdap.plugin.zuora.objects.AccountingCodeObjectCustomFields;
import io.cdap.plugin.zuora.objects.AccountingPeriodObjectCustomFields;
import io.cdap.plugin.zuora.objects.AccountingPeriodType;
import io.cdap.plugin.zuora.objects.AccountingPeriodTypeFileIdsItem;
import io.cdap.plugin.zuora.objects.AccountingPeriodWithoutSuccessType;
import io.cdap.plugin.zuora.objects.AccountingPeriodWithoutSuccessTypeFileIdsItem;
import io.cdap.plugin.zuora.objects.ActionsErrorResponse;
import io.cdap.plugin.zuora.objects.AllCustomObjectDefinitionsInNamespaceResponse;
import io.cdap.plugin.zuora.objects.AmendRequest;
import io.cdap.plugin.zuora.objects.AmendRequestAmendOptionsItem;
import io.cdap.plugin.zuora.objects.AmendRequestPreviewOptionsItem;
import io.cdap.plugin.zuora.objects.AmendResult;
import io.cdap.plugin.zuora.objects.AmendResultAmendmentIdsItem;
import io.cdap.plugin.zuora.objects.Amendment;
import io.cdap.plugin.zuora.objects.AmendmentObjectCustomFields;
import io.cdap.plugin.zuora.objects.AmendmentRatePlanChargeData;
import io.cdap.plugin.zuora.objects.AmendmentRatePlanChargeDataRatePlanCharge;
import io.cdap.plugin.zuora.objects.AmendmentRatePlanChargeTier;
import io.cdap.plugin.zuora.objects.AmendmentRatePlanDataItem;
import io.cdap.plugin.zuora.objects.AmendmentType;
import io.cdap.plugin.zuora.objects.ApplyCreditMemoType;
import io.cdap.plugin.zuora.objects.ApplyPaymentType;
import io.cdap.plugin.zuora.objects.AttachmentResponseType;
import io.cdap.plugin.zuora.objects.AttachmentResponseWithoutSuccessType;
import io.cdap.plugin.zuora.objects.BadRequestResponse;
import io.cdap.plugin.zuora.objects.BadRequestResponseErrorsItem;
import io.cdap.plugin.zuora.objects.BatchDebitMemoType;
import io.cdap.plugin.zuora.objects.BatchInvoiceType;
import io.cdap.plugin.zuora.objects.BillToContact;
import io.cdap.plugin.zuora.objects.BillToContactPostOrder;
import io.cdap.plugin.zuora.objects.BillingDocumentFilesDeletionJobResponse;
import io.cdap.plugin.zuora.objects.BillingDocumentsResponseType;
import io.cdap.plugin.zuora.objects.BillingOptions;
import io.cdap.plugin.zuora.objects.BillingPreviewResult;
import io.cdap.plugin.zuora.objects.BillingPreviewRunResponse;
import io.cdap.plugin.zuora.objects.BillingUpdate;
import io.cdap.plugin.zuora.objects.BodyInSettingValueReponse;
import io.cdap.plugin.zuora.objects.BodyInSettingValueRequest;
import io.cdap.plugin.zuora.objects.BreakdownDetail;
import io.cdap.plugin.zuora.objects.CMTaxItemType;
import io.cdap.plugin.zuora.objects.CMTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CMTaxItemTypeNew;
import io.cdap.plugin.zuora.objects.CMTaxItemTypeNewFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CalloutAuth;
import io.cdap.plugin.zuora.objects.CalloutHistoryVOType;
import io.cdap.plugin.zuora.objects.CalloutMergeFields;
import io.cdap.plugin.zuora.objects.CancelSubscription;
import io.cdap.plugin.zuora.objects.ChargeMetricsData;
import io.cdap.plugin.zuora.objects.ChargeOverride;
import io.cdap.plugin.zuora.objects.ChargeOverrideBillingItem;
import io.cdap.plugin.zuora.objects.ChargeOverrideForEvergreen;
import io.cdap.plugin.zuora.objects.ChargeOverrideForEvergreenBillingItem;
import io.cdap.plugin.zuora.objects.ChargeOverrideForEvergreenPricingItem;
import io.cdap.plugin.zuora.objects.ChargeOverridePricingItem;
import io.cdap.plugin.zuora.objects.ChargePreviewMetrics;
import io.cdap.plugin.zuora.objects.ChargePreviewMetricsCmrrItem;
import io.cdap.plugin.zuora.objects.ChargePreviewMetricsTaxItem;
import io.cdap.plugin.zuora.objects.ChargePreviewMetricsTcbItem;
import io.cdap.plugin.zuora.objects.ChargePreviewMetricsTcvItem;
import io.cdap.plugin.zuora.objects.ChargeRSDetailType;
import io.cdap.plugin.zuora.objects.ChargeRatedResult;
import io.cdap.plugin.zuora.objects.ChargeTier;
import io.cdap.plugin.zuora.objects.ChargeUpdate;
import io.cdap.plugin.zuora.objects.ChargeUpdateForEvergreen;
import io.cdap.plugin.zuora.objects.ChildrenSettingValueRequest;
import io.cdap.plugin.zuora.objects.CommonErrorResponse;
import io.cdap.plugin.zuora.objects.CommonRatingErrorResponse;
import io.cdap.plugin.zuora.objects.CommonRatingErrorResponseReasonsItem;
import io.cdap.plugin.zuora.objects.CommonResponseType;
import io.cdap.plugin.zuora.objects.CommonResponseTypeReasonsItem;
import io.cdap.plugin.zuora.objects.CommonUsageErrorResponse;
import io.cdap.plugin.zuora.objects.CommonUsageErrorResponseErrorItem;
import io.cdap.plugin.zuora.objects.CommonUsageErrorResponseErrorItemErrorsItem;
import io.cdap.plugin.zuora.objects.CommonUsageImportsErrorResponse;
import io.cdap.plugin.zuora.objects.CommonUsageImportsErrorResponseErrorItem;
import io.cdap.plugin.zuora.objects.CommonUsageImportsErrorResponseErrorItemErrorsItem;
import io.cdap.plugin.zuora.objects.Contact;
import io.cdap.plugin.zuora.objects.ContactObjectCustomFields;
import io.cdap.plugin.zuora.objects.CreateEntityResponseType;
import io.cdap.plugin.zuora.objects.CreateEntityType;
import io.cdap.plugin.zuora.objects.CreateOrderChargeOverride;
import io.cdap.plugin.zuora.objects.CreateOrderChargeOverrideBillingItem;
import io.cdap.plugin.zuora.objects.CreateOrderChargeOverridePricingItem;
import io.cdap.plugin.zuora.objects.CreateOrderChargeUpdate;
import io.cdap.plugin.zuora.objects.CreateOrderCreateSubscription;
import io.cdap.plugin.zuora.objects.CreateOrderCreateSubscriptionNewSubscriptionOwnerAccount;
import io.cdap.plugin.zuora.objects.CreateOrderCreateSubscriptionTermsItem;
import io.cdap.plugin.zuora.objects.CreateOrderCreateSubscriptionTermsItemInitialTermItem;
import io.cdap.plugin.zuora.objects.CreateOrderOrderAction;
import io.cdap.plugin.zuora.objects.CreateOrderPricingUpdate;
import io.cdap.plugin.zuora.objects.CreateOrderRatePlanOverride;
import io.cdap.plugin.zuora.objects.CreateOrderRatePlanUpdate;
import io.cdap.plugin.zuora.objects.CreateOrderResume;
import io.cdap.plugin.zuora.objects.CreateOrderSuspend;
import io.cdap.plugin.zuora.objects.CreateOrderTermsAndConditions;
import io.cdap.plugin.zuora.objects.CreateOrderTriggerParams;
import io.cdap.plugin.zuora.objects.CreatePMPayPalECPayPalNativeEC;
import io.cdap.plugin.zuora.objects.CreatePaymentMethodACH;
import io.cdap.plugin.zuora.objects.CreatePaymentMethodCardholderInfo;
import io.cdap.plugin.zuora.objects.CreatePaymentMethodCommon;
import io.cdap.plugin.zuora.objects.CreatePaymentMethodCreditCard;
import io.cdap.plugin.zuora.objects.CreatePaymentMethodPayPalAdaptive;
import io.cdap.plugin.zuora.objects.CreatePaymentType;
import io.cdap.plugin.zuora.objects.CreatePaymentTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreateStoredCredentialProfileRequest;
import io.cdap.plugin.zuora.objects.CreateSubscription;
import io.cdap.plugin.zuora.objects.CreateSubscriptionForEvergreen;
import io.cdap.plugin.zuora.objects.CreateSubscriptionForEvergreenNewSubscriptionOwnerAccountItem;
import io.cdap.plugin.zuora.objects.CreateSubscriptionForEvergreenTermsItem;
import io.cdap.plugin.zuora.objects.CreateSubscriptionForEvergreenTermsItemInitialTermItem;
import io.cdap.plugin.zuora.objects.CreateSubscriptionNewSubscriptionOwnerAccountItem;
import io.cdap.plugin.zuora.objects.CreateSubscriptionTermsItem;
import io.cdap.plugin.zuora.objects.CreateSubscriptionTermsItemInitialTermItem;
import io.cdap.plugin.zuora.objects.CreditBalanceAdjustmentObjectCustomFields;
import io.cdap.plugin.zuora.objects.CreditBalanceAdjustmentObjectNSFields;
import io.cdap.plugin.zuora.objects.CreditCard;
import io.cdap.plugin.zuora.objects.CreditMemoAmountBreakdownByOrderResponse;
import io.cdap.plugin.zuora.objects.CreditMemoApplyDebitMemoItemRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoApplyDebitMemoRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoApplyInvoiceItemRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoApplyInvoiceRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoEntityPrefix;
import io.cdap.plugin.zuora.objects.CreditMemoFromChargeDetailType;
import io.cdap.plugin.zuora.objects.CreditMemoFromChargeDetailTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoFromChargeType;
import io.cdap.plugin.zuora.objects.CreditMemoFromInvoiceType;
import io.cdap.plugin.zuora.objects.CreditMemoItemBreakdown;
import io.cdap.plugin.zuora.objects.CreditMemoItemFromInvoiceItemType;
import io.cdap.plugin.zuora.objects.CreditMemoItemFromInvoiceItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoItemFromWriteOffInvoice;
import io.cdap.plugin.zuora.objects.CreditMemoItemFromWriteOffInvoiceFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.CreditMemoItemPartType;
import io.cdap.plugin.zuora.objects.CreditMemoItemPartTypewithSuccess;
import io.cdap.plugin.zuora.objects.CreditMemoItemType;
import io.cdap.plugin.zuora.objects.CreditMemoItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoItemTypewithSuccess;
import io.cdap.plugin.zuora.objects.CreditMemoItemTypewithSuccessFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoObjectCustomFields;
import io.cdap.plugin.zuora.objects.CreditMemoObjectNSFields;
import io.cdap.plugin.zuora.objects.CreditMemoPartType;
import io.cdap.plugin.zuora.objects.CreditMemoPartTypewithSuccess;
import io.cdap.plugin.zuora.objects.CreditMemoResponseType;
import io.cdap.plugin.zuora.objects.CreditMemoTaxItemFromInvoiceTaxItemType;
import io.cdap.plugin.zuora.objects.CreditMemoTaxItemFromInvoiceTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.CreditMemoType;
import io.cdap.plugin.zuora.objects.CreditMemoTypewithSuccess;
import io.cdap.plugin.zuora.objects.CreditMemoUnapplyDebitMemoItemRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoUnapplyDebitMemoRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoUnapplyInvoiceItemRequestType;
import io.cdap.plugin.zuora.objects.CreditMemoUnapplyInvoiceRequestType;
import io.cdap.plugin.zuora.objects.CustomExchangeRatesDataType;
import io.cdap.plugin.zuora.objects.CustomExchangeRatesDataTypeDATEItem;
import io.cdap.plugin.zuora.objects.CustomExchangeRatesType;
import io.cdap.plugin.zuora.objects.CustomFields;
import io.cdap.plugin.zuora.objects.CustomFieldsDefinitionNoNamespace;
import io.cdap.plugin.zuora.objects.CustomFieldsDefinitionNoNamespaceSchemaItem;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinition;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinitionCreatedByIdItem;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinitionCreatedDateItem;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinitionIdItem;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinitionUpdatedByIdItem;
import io.cdap.plugin.zuora.objects.CustomObjectAllFieldsDefinitionUpdatedDateItem;
import io.cdap.plugin.zuora.objects.CustomObjectCustomFieldDefinition;
import io.cdap.plugin.zuora.objects.CustomObjectCustomFieldDefinitionUpdate;
import io.cdap.plugin.zuora.objects.CustomObjectCustomFieldsDefinition;
import io.cdap.plugin.zuora.objects.CustomObjectDefinition;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionSchemaItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionSchemaItemPropertiesItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionSchemaItemRelationshipsItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionSchemaItemRequiredItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionUpdateActionRequest;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionUpdateActionRequestRelationshipItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionUpdateActionResponse;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitionUpdateActionResponseRelationshipItem;
import io.cdap.plugin.zuora.objects.CustomObjectDefinitions;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchAction;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchActionIdsItem;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchActionRecordsItem;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchActionResult;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchActionResultUnprocessedIdsItem;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchRequest;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchRequestActionItem;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchResponse;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchResponseResultItem;
import io.cdap.plugin.zuora.objects.CustomObjectRecordBatchUpdateMapping;
import io.cdap.plugin.zuora.objects.CustomObjectRecordWithAllFields;
import io.cdap.plugin.zuora.objects.CustomObjectRecordWithOnlyCustomFields;
import io.cdap.plugin.zuora.objects.CustomObjectsAllNamespacesResponse;
import io.cdap.plugin.zuora.objects.CustomObjectsNamespace;
import io.cdap.plugin.zuora.objects.DELETEUsageResponseType;
import io.cdap.plugin.zuora.objects.DELETEntityResponseType;
import io.cdap.plugin.zuora.objects.DMTaxItemType;
import io.cdap.plugin.zuora.objects.DMTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DMTaxItemTypeNew;
import io.cdap.plugin.zuora.objects.DMTaxItemTypeNewFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DataAccessControlField;
import io.cdap.plugin.zuora.objects.DataQueryErrorResponse;
import io.cdap.plugin.zuora.objects.DataQueryJob;
import io.cdap.plugin.zuora.objects.DataQueryJobCancelled;
import io.cdap.plugin.zuora.objects.DataQueryJobCommon;
import io.cdap.plugin.zuora.objects.DataQueryJobResponse;
import io.cdap.plugin.zuora.objects.DataQueryJobsResponse;
import io.cdap.plugin.zuora.objects.DebitMemoApplicationPartType;
import io.cdap.plugin.zuora.objects.DebitMemoEntityPrefix;
import io.cdap.plugin.zuora.objects.DebitMemoFromChargeDetailType;
import io.cdap.plugin.zuora.objects.DebitMemoFromChargeDetailTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DebitMemoFromChargeType;
import io.cdap.plugin.zuora.objects.DebitMemoFromInvoiceType;
import io.cdap.plugin.zuora.objects.DebitMemoItemFromInvoiceItemType;
import io.cdap.plugin.zuora.objects.DebitMemoItemFromInvoiceItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DebitMemoItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.DebitMemoItemType;
import io.cdap.plugin.zuora.objects.DebitMemoItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DebitMemoItemTypewithSuccess;
import io.cdap.plugin.zuora.objects.DebitMemoItemTypewithSuccessFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DebitMemoObjectCustomFields;
import io.cdap.plugin.zuora.objects.DebitMemoObjectNSFields;
import io.cdap.plugin.zuora.objects.DebitMemoTaxItemFromInvoiceTaxItemType;
import io.cdap.plugin.zuora.objects.DebitMemoTaxItemFromInvoiceTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.DebitMemoType;
import io.cdap.plugin.zuora.objects.DebitMemoTypewithSuccess;
import io.cdap.plugin.zuora.objects.DeleteDataQueryJobResponse;
import io.cdap.plugin.zuora.objects.DeleteResult;
import io.cdap.plugin.zuora.objects.DiscountApplyDetailsType;
import io.cdap.plugin.zuora.objects.DiscountPricingOverride;
import io.cdap.plugin.zuora.objects.DiscountPricingUpdate;
import io.cdap.plugin.zuora.objects.DocumentPropertiesResponseType;
import io.cdap.plugin.zuora.objects.ElectronicPaymentOptions;
import io.cdap.plugin.zuora.objects.EmailHistoryVOType;
import io.cdap.plugin.zuora.objects.EndConditions;
import io.cdap.plugin.zuora.objects.EntitiesResponseTypeWithId;
import io.cdap.plugin.zuora.objects.EntitiesType;
import io.cdap.plugin.zuora.objects.EntityConnectionsArrayItemsType;
import io.cdap.plugin.zuora.objects.ErrorResponse;
import io.cdap.plugin.zuora.objects.ErrorResponseReasonsItem;
import io.cdap.plugin.zuora.objects.EventRevenueItemType;
import io.cdap.plugin.zuora.objects.EventTrigger;
import io.cdap.plugin.zuora.objects.EventType;
import io.cdap.plugin.zuora.objects.ExecuteResult;
import io.cdap.plugin.zuora.objects.ExternalPaymentOptions;
import io.cdap.plugin.zuora.objects.FeatureObjectCustomFields;
import io.cdap.plugin.zuora.objects.FieldsAdditionalProperties;
import io.cdap.plugin.zuora.objects.FilterRuleParameterDefinition;
import io.cdap.plugin.zuora.objects.FilterRuleParameterDefinitionOptionsItem;
import io.cdap.plugin.zuora.objects.FilterRuleParameterDefinitions;
import io.cdap.plugin.zuora.objects.FilterRuleParameterValues;
import io.cdap.plugin.zuora.objects.GatewayOption;
import io.cdap.plugin.zuora.objects.GenerateBillingDocumentResponseType;
import io.cdap.plugin.zuora.objects.HostedPageType;
import io.cdap.plugin.zuora.objects.InitialTerm;
import io.cdap.plugin.zuora.objects.Invoice;
import io.cdap.plugin.zuora.objects.InvoiceAdjustmentObjectCustomFields;
import io.cdap.plugin.zuora.objects.InvoiceAmountBreakdownByOrderResponse;
import io.cdap.plugin.zuora.objects.InvoiceApplicationPartType;
import io.cdap.plugin.zuora.objects.InvoiceData;
import io.cdap.plugin.zuora.objects.InvoiceDataInvoice;
import io.cdap.plugin.zuora.objects.InvoiceEntityPrefix;
import io.cdap.plugin.zuora.objects.InvoiceFile;
import io.cdap.plugin.zuora.objects.InvoiceItem;
import io.cdap.plugin.zuora.objects.InvoiceItemAdjustmentObjectCustomFields;
import io.cdap.plugin.zuora.objects.InvoiceItemBreakdown;
import io.cdap.plugin.zuora.objects.InvoiceItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.InvoiceItemObjectNSFields;
import io.cdap.plugin.zuora.objects.InvoiceItemPreviewResult;
import io.cdap.plugin.zuora.objects.InvoiceItemPreviewResultAdditionalInfoItem;
import io.cdap.plugin.zuora.objects.InvoiceObjectCustomFields;
import io.cdap.plugin.zuora.objects.InvoiceObjectNSFields;
import io.cdap.plugin.zuora.objects.InvoicePayment;
import io.cdap.plugin.zuora.objects.InvoiceProcessingOptions;
import io.cdap.plugin.zuora.objects.InvoiceResponseType;
import io.cdap.plugin.zuora.objects.InvoiceTaxItemType;
import io.cdap.plugin.zuora.objects.InvoiceType;
import io.cdap.plugin.zuora.objects.JobResult;
import io.cdap.plugin.zuora.objects.JobResultCreditMemoNumbersItem;
import io.cdap.plugin.zuora.objects.JobResultInvoiceNumbersItem;
import io.cdap.plugin.zuora.objects.JobResultSubscriptionNumbersItem;
import io.cdap.plugin.zuora.objects.JobResultSubscriptionsItem;
import io.cdap.plugin.zuora.objects.JournalEntryDetailType;
import io.cdap.plugin.zuora.objects.JournalEntryDetailTypeWithoutSuccess;
import io.cdap.plugin.zuora.objects.JournalEntryItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.JournalEntryItemType;
import io.cdap.plugin.zuora.objects.JournalEntryObjectCustomFields;
import io.cdap.plugin.zuora.objects.JournalEntrySegmentType;
import io.cdap.plugin.zuora.objects.JournalRunTransactionType;
import io.cdap.plugin.zuora.objects.JournalRunType;
import io.cdap.plugin.zuora.objects.LastTerm;
import io.cdap.plugin.zuora.objects.Linkage;
import io.cdap.plugin.zuora.objects.ListAllSettingsResponse;
import io.cdap.plugin.zuora.objects.MassUpdateType;
import io.cdap.plugin.zuora.objects.MigrationUpdateCustomObjectDefinitionsRequest;
import io.cdap.plugin.zuora.objects.MigrationUpdateCustomObjectDefinitionsResponse;
import io.cdap.plugin.zuora.objects.ModifiedStoredCredentialProfileResponse;
import io.cdap.plugin.zuora.objects.NewChargeMetrics;
import io.cdap.plugin.zuora.objects.OneTimeFlatFeePricingOverride;
import io.cdap.plugin.zuora.objects.OneTimePerUnitPricingOverride;
import io.cdap.plugin.zuora.objects.OneTimeTieredPricingOverride;
import io.cdap.plugin.zuora.objects.OneTimeVolumePricingOverride;
import io.cdap.plugin.zuora.objects.Order;
import io.cdap.plugin.zuora.objects.OrderAction;
import io.cdap.plugin.zuora.objects.OrderActionForEvergreen;
import io.cdap.plugin.zuora.objects.OrderActionObjectCustomFields;
import io.cdap.plugin.zuora.objects.OrderForEvergreen;
import io.cdap.plugin.zuora.objects.OrderForEvergreenSubscriptionsItem;
import io.cdap.plugin.zuora.objects.OrderItem;
import io.cdap.plugin.zuora.objects.OrderMetric;
import io.cdap.plugin.zuora.objects.OrderMetricsForEvergreen;
import io.cdap.plugin.zuora.objects.OrderObjectCustomFields;
import io.cdap.plugin.zuora.objects.OrderRatedResult;
import io.cdap.plugin.zuora.objects.OrderRatedResultResponseType;
import io.cdap.plugin.zuora.objects.OrderResponse;
import io.cdap.plugin.zuora.objects.OrderResponseForEvergreen;
import io.cdap.plugin.zuora.objects.OrderResume;
import io.cdap.plugin.zuora.objects.OrderSubscriptionsItem;
import io.cdap.plugin.zuora.objects.OrderSuspend;
import io.cdap.plugin.zuora.objects.OwnerTransfer;
import io.cdap.plugin.zuora.objects.POSTAccountResponseType;
import io.cdap.plugin.zuora.objects.POSTAccountType;
import io.cdap.plugin.zuora.objects.POSTAccountTypeAdditionalEmailAddressesItem;
import io.cdap.plugin.zuora.objects.POSTAccountTypeBillToContact;
import io.cdap.plugin.zuora.objects.POSTAccountTypeCreditCard;
import io.cdap.plugin.zuora.objects.POSTAccountTypeCreditCardCardHolderInfoItem;
import io.cdap.plugin.zuora.objects.POSTAccountTypeSoldToContact;
import io.cdap.plugin.zuora.objects.POSTAccountTypeSubscription;
import io.cdap.plugin.zuora.objects.POSTAccountTypeTaxInfoItem;
import io.cdap.plugin.zuora.objects.POSTAccountingCodeType;
import io.cdap.plugin.zuora.objects.POSTAccountingPeriodType;
import io.cdap.plugin.zuora.objects.POSTAttachmentResponseType;
import io.cdap.plugin.zuora.objects.POSTAuthorizeResponse;
import io.cdap.plugin.zuora.objects.POSTBillingDocumentFilesDeletionJobRequest;
import io.cdap.plugin.zuora.objects.POSTBillingDocumentFilesDeletionJobRequestAccountIdsItem;
import io.cdap.plugin.zuora.objects.POSTBillingDocumentFilesDeletionJobResponse;
import io.cdap.plugin.zuora.objects.POSTBillingPreviewCreditMemoItem;
import io.cdap.plugin.zuora.objects.POSTBillingPreviewInvoiceItem;
import io.cdap.plugin.zuora.objects.POSTCatalogType;
import io.cdap.plugin.zuora.objects.POSTCatalogTypeToEntityIdsItem;
import io.cdap.plugin.zuora.objects.POSTCreditMemoItemsForOrderBreakdown;
import io.cdap.plugin.zuora.objects.POSTCreditMemoItemsForOrderBreakdownMemoItemIdsItem;
import io.cdap.plugin.zuora.objects.POSTDecryptResponseType;
import io.cdap.plugin.zuora.objects.POSTDecryptionType;
import io.cdap.plugin.zuora.objects.POSTDelayAuthorizeCapture;
import io.cdap.plugin.zuora.objects.POSTDistributionItemType;
import io.cdap.plugin.zuora.objects.POSTDocumentPropertiesType;
import io.cdap.plugin.zuora.objects.POSTEmailBillingDocfromBillRunType;
import io.cdap.plugin.zuora.objects.POSTEntityConnectionsType;
import io.cdap.plugin.zuora.objects.POSTHMACSignatureResponseType;
import io.cdap.plugin.zuora.objects.POSTHMACSignatureType;
import io.cdap.plugin.zuora.objects.POSTInvoiceCollectCreditMemosType;
import io.cdap.plugin.zuora.objects.POSTInvoiceCollectInvoicesType;
import io.cdap.plugin.zuora.objects.POSTInvoiceCollectResponseType;
import io.cdap.plugin.zuora.objects.POSTInvoiceCollectType;
import io.cdap.plugin.zuora.objects.POSTInvoiceItemsForOrderBreakdown;
import io.cdap.plugin.zuora.objects.POSTInvoiceItemsForOrderBreakdownInvoiceItemIdsItem;
import io.cdap.plugin.zuora.objects.POSTJournalEntryItemType;
import io.cdap.plugin.zuora.objects.POSTJournalEntrySegmentType;
import io.cdap.plugin.zuora.objects.POSTJournalEntryType;
import io.cdap.plugin.zuora.objects.POSTJournalRunTransactionType;
import io.cdap.plugin.zuora.objects.POSTJournalRunType;
import io.cdap.plugin.zuora.objects.POSTMemoPdfResponse;
import io.cdap.plugin.zuora.objects.POSTOrderPreviewRequestType;
import io.cdap.plugin.zuora.objects.POSTOrderPreviewRequestTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.POSTOrderRequestType;
import io.cdap.plugin.zuora.objects.POSTOrderRequestTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodDecryption;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodDecryptionCardHolderInfoItem;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodDecryptionPaymentTokenItem;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodRequest;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodResponse;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodResponseDecryption;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodResponseReasonsItem;
import io.cdap.plugin.zuora.objects.POSTPaymentMethodType;
import io.cdap.plugin.zuora.objects.POSTPaymentRunRequest;
import io.cdap.plugin.zuora.objects.POSTPublicEmailTemplateRequest;
import io.cdap.plugin.zuora.objects.POSTPublicNotificationDefinitionRequest;
import io.cdap.plugin.zuora.objects.POSTPublicNotificationDefinitionRequestCalloutItem;
import io.cdap.plugin.zuora.objects.POSTPublicNotificationDefinitionRequestFilterRuleItem;
import io.cdap.plugin.zuora.objects.POSTQuoteDocType;
import io.cdap.plugin.zuora.objects.POSTRSASignatureResponseType;
import io.cdap.plugin.zuora.objects.POSTRSASignatureType;
import io.cdap.plugin.zuora.objects.POSTRejectPaymentRequest;
import io.cdap.plugin.zuora.objects.POSTRejectPaymentResponse;
import io.cdap.plugin.zuora.objects.POSTRejectPaymentResponseFinanceInformationItem;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByChargeType;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByChargeTypeRevenueEvent;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByDateRangeType;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByDateRangeTypeRevenueEvent;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByTransactionRatablyCMType;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByTransactionRatablyDMType;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByTransactionRatablyTypeRevenueEvent;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByTransactionType;
import io.cdap.plugin.zuora.objects.POSTRevenueScheduleByTransactionTypeRevenueEvent;
import io.cdap.plugin.zuora.objects.POSTReversePaymentRequest;
import io.cdap.plugin.zuora.objects.POSTReversePaymentResponse;
import io.cdap.plugin.zuora.objects.POSTReversePaymentResponseFinanceInformationItem;
import io.cdap.plugin.zuora.objects.POSTScCreateType;
import io.cdap.plugin.zuora.objects.POSTSequenceSetRequest;
import io.cdap.plugin.zuora.objects.POSTSequenceSetsRequest;
import io.cdap.plugin.zuora.objects.POSTSettlePaymentRequest;
import io.cdap.plugin.zuora.objects.POSTSettlePaymentResponse;
import io.cdap.plugin.zuora.objects.POSTSettlePaymentResponseFinanceInformationItem;
import io.cdap.plugin.zuora.objects.POSTSrpCreateType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionCancellationResponseType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionCancellationType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewCreditMemoItemsType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewInvoiceItemsType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewResponseType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewResponseTypeChargeMetricsItem;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewResponseTypeCreditMemoItem;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewResponseTypeInvoiceItem;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewTypePreviewAccountInfo;
import io.cdap.plugin.zuora.objects.POSTSubscriptionPreviewTypePreviewAccountInfoBillToContactItem;
import io.cdap.plugin.zuora.objects.POSTSubscriptionResponseType;
import io.cdap.plugin.zuora.objects.POSTSubscriptionType;
import io.cdap.plugin.zuora.objects.POSTTaxationItemForCMType;
import io.cdap.plugin.zuora.objects.POSTTaxationItemForCMTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.POSTTaxationItemForDMType;
import io.cdap.plugin.zuora.objects.POSTTaxationItemForDMTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.POSTTaxationItemListForCMType;
import io.cdap.plugin.zuora.objects.POSTTaxationItemListForDMType;
import io.cdap.plugin.zuora.objects.POSTTierType;
import io.cdap.plugin.zuora.objects.POSTUsageImportResponseType;
import io.cdap.plugin.zuora.objects.POSTUsageRecordRequestType;
import io.cdap.plugin.zuora.objects.POSTUsageRecordResponseType;
import io.cdap.plugin.zuora.objects.POSTUsageRecordResponseTypeDataItem;
import io.cdap.plugin.zuora.objects.POSTUsageResponseType;
import io.cdap.plugin.zuora.objects.POSTUsageType;
import io.cdap.plugin.zuora.objects.POSTVoidAuthorize;
import io.cdap.plugin.zuora.objects.POSTVoidAuthorizeResponse;
import io.cdap.plugin.zuora.objects.PUTAcceptUserAccessResponseType;
import io.cdap.plugin.zuora.objects.PUTAccountType;
import io.cdap.plugin.zuora.objects.PUTAccountTypeAdditionalEmailAddressesItem;
import io.cdap.plugin.zuora.objects.PUTAccountTypeBillToContact;
import io.cdap.plugin.zuora.objects.PUTAccountTypeSoldToContact;
import io.cdap.plugin.zuora.objects.PUTAccountTypeTaxInfoItem;
import io.cdap.plugin.zuora.objects.PUTAccountingCodeType;
import io.cdap.plugin.zuora.objects.PUTAccountingPeriodType;
import io.cdap.plugin.zuora.objects.PUTAllocateManuallyType;
import io.cdap.plugin.zuora.objects.PUTAttachmentType;
import io.cdap.plugin.zuora.objects.PUTBatchDebitMemosRequest;
import io.cdap.plugin.zuora.objects.PUTCreditMemoItemType;
import io.cdap.plugin.zuora.objects.PUTCreditMemoItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PUTCreditMemoType;
import io.cdap.plugin.zuora.objects.PUTDebitMemoItemType;
import io.cdap.plugin.zuora.objects.PUTDebitMemoItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PUTDebitMemoType;
import io.cdap.plugin.zuora.objects.PUTDenyUserAccessResponseType;
import io.cdap.plugin.zuora.objects.PUTDocumentPropertiesType;
import io.cdap.plugin.zuora.objects.PUTEntityConnectionsAcceptResponseType;
import io.cdap.plugin.zuora.objects.PUTEntityConnectionsDenyResponseType;
import io.cdap.plugin.zuora.objects.PUTEntityConnectionsDisconnectResponseType;
import io.cdap.plugin.zuora.objects.PUTEventRIDetailType;
import io.cdap.plugin.zuora.objects.PUTJournalEntryItemType;
import io.cdap.plugin.zuora.objects.PUTOrderActionTriggerDatesRequestType;
import io.cdap.plugin.zuora.objects.PUTOrderActionTriggerDatesRequestTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItem;
import io.cdap.plugin.zuora.objects.PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItemChargesItem;
import io.cdap.plugin.zuora.objects.PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItemTriggerDatesItem;
import io.cdap.plugin.zuora.objects.PUTOrderPatchRequestType;
import io.cdap.plugin.zuora.objects.PUTOrderPatchRequestTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.PUTOrderPatchRequestTypeSubscriptionsItemOrderActionsItem;
import io.cdap.plugin.zuora.objects.PUTOrderTriggerDatesResponseType;
import io.cdap.plugin.zuora.objects.PUTOrderTriggerDatesResponseTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.PUTPaymentMethodType;
import io.cdap.plugin.zuora.objects.PUTPaymentRunRequest;
import io.cdap.plugin.zuora.objects.PUTPublicCalloutOptionsRequest;
import io.cdap.plugin.zuora.objects.PUTPublicEmailTemplateRequest;
import io.cdap.plugin.zuora.objects.PUTPublicNotificationDefinitionRequest;
import io.cdap.plugin.zuora.objects.PUTPublicNotificationDefinitionRequestCalloutItem;
import io.cdap.plugin.zuora.objects.PUTPublicNotificationDefinitionRequestFilterRuleItem;
import io.cdap.plugin.zuora.objects.PUTRSBasicInfoType;
import io.cdap.plugin.zuora.objects.PUTRSTermType;
import io.cdap.plugin.zuora.objects.PUTRefundType;
import io.cdap.plugin.zuora.objects.PUTRefundTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PUTRenewSubscriptionResponseType;
import io.cdap.plugin.zuora.objects.PUTRenewSubscriptionType;
import io.cdap.plugin.zuora.objects.PUTScAddType;
import io.cdap.plugin.zuora.objects.PUTScUpdateType;
import io.cdap.plugin.zuora.objects.PUTScheduleRIDetailType;
import io.cdap.plugin.zuora.objects.PUTSendUserAccessRequestResponseType;
import io.cdap.plugin.zuora.objects.PUTSendUserAccessRequestType;
import io.cdap.plugin.zuora.objects.PUTSendUserAccessRequestTypeTargetEntityIdsItem;
import io.cdap.plugin.zuora.objects.PUTSequenceSetRequest;
import io.cdap.plugin.zuora.objects.PUTSequenceSetResponse;
import io.cdap.plugin.zuora.objects.PUTSpecificDateAllocationType;
import io.cdap.plugin.zuora.objects.PUTSrpAddType;
import io.cdap.plugin.zuora.objects.PUTSrpRemoveType;
import io.cdap.plugin.zuora.objects.PUTSrpUpdateType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionPatchRequestType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionPatchRequestTypeRatePlansItem;
import io.cdap.plugin.zuora.objects.PUTSubscriptionPatchRequestTypeRatePlansItemChargesItem;
import io.cdap.plugin.zuora.objects.PUTSubscriptionPreviewInvoiceItemsType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResponseType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResponseTypeChargeMetricsItem;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResponseTypeCreditMemoItem;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResponseTypeInvoiceItem;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResumeResponseType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionResumeType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionSuspendResponseType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionSuspendType;
import io.cdap.plugin.zuora.objects.PUTSubscriptionType;
import io.cdap.plugin.zuora.objects.PUTTaxationItemType;
import io.cdap.plugin.zuora.objects.PUTTaxationItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PUTUpdateUsageResponseType;
import io.cdap.plugin.zuora.objects.PUTUsageType;
import io.cdap.plugin.zuora.objects.PUTVerifyPaymentMethodType;
import io.cdap.plugin.zuora.objects.PUTVerifyPaymentMethodTypeGatewayOptionsItem;
import io.cdap.plugin.zuora.objects.PUTWriteOffInvoiceRequest;
import io.cdap.plugin.zuora.objects.PUTWriteOffInvoiceResponseCreditMemoItem;
import io.cdap.plugin.zuora.objects.PUT_BasicSummaryJournalEntryType;
import io.cdap.plugin.zuora.objects.PaidInvoicesType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationApplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationCreateRequestType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationItemApplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationItemCreateRequestType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationItemUnapplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentDebitMemoApplicationUnapplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationApplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationCreateRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationItemApplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationItemCreateRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationItemUnapplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentInvoiceApplicationUnapplyRequestType;
import io.cdap.plugin.zuora.objects.PaymentItemPartType;
import io.cdap.plugin.zuora.objects.PaymentItemPartTypewithSuccess;
import io.cdap.plugin.zuora.objects.PaymentMethodObjectCustomFields;
import io.cdap.plugin.zuora.objects.PaymentMethodType;
import io.cdap.plugin.zuora.objects.PaymentMethodTypeCardHolderInfoItem;
import io.cdap.plugin.zuora.objects.PaymentObjectCustomFields;
import io.cdap.plugin.zuora.objects.PaymentObjectNSFields;
import io.cdap.plugin.zuora.objects.PaymentPartType;
import io.cdap.plugin.zuora.objects.PaymentPartTypewithSuccess;
import io.cdap.plugin.zuora.objects.PaymentRunSummaryResponse;
import io.cdap.plugin.zuora.objects.PaymentRunSummaryTotalValues;
import io.cdap.plugin.zuora.objects.PaymentRunType;
import io.cdap.plugin.zuora.objects.PaymentType;
import io.cdap.plugin.zuora.objects.PostBillingPreviewParam;
import io.cdap.plugin.zuora.objects.PostBillingPreviewRunParam;
import io.cdap.plugin.zuora.objects.PostCreditMemoEmailRequestType;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionFieldDefinitionRequest;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionFieldsDefinitionRequest;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionRequest;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionRequestPropertiesItem;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionRequestRelationshipsItem;
import io.cdap.plugin.zuora.objects.PostCustomObjectDefinitionRequestRequiredItem;
import io.cdap.plugin.zuora.objects.PostCustomObjectRecordsRequest;
import io.cdap.plugin.zuora.objects.PostCustomObjectRecordsResponse;
import io.cdap.plugin.zuora.objects.PostDebitMemoEmailType;
import io.cdap.plugin.zuora.objects.PostEventTriggerRequest;
import io.cdap.plugin.zuora.objects.PostGenerateBillingDocumentType;
import io.cdap.plugin.zuora.objects.PostGenerateBillingDocumentTypeChargeTypeToExcludeItem;
import io.cdap.plugin.zuora.objects.PostGenerateBillingDocumentTypeSubscriptionIdsItem;
import io.cdap.plugin.zuora.objects.PostInvoiceEmailRequestType;
import io.cdap.plugin.zuora.objects.PostNonRefRefundType;
import io.cdap.plugin.zuora.objects.PostNonRefRefundTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PostOrderPreviewResponseType;
import io.cdap.plugin.zuora.objects.PostOrderResponseType;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeCreditMemoIdsItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeCreditMemoNumbersItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeInvoiceIdsItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeInvoiceNumbersItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeSubscriptionIdsItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeSubscriptionNumbersItem;
import io.cdap.plugin.zuora.objects.PostOrderResponseTypeSubscriptionsItem;
import io.cdap.plugin.zuora.objects.PostRefundType;
import io.cdap.plugin.zuora.objects.PostRefundTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PreviewAccountInfo;
import io.cdap.plugin.zuora.objects.PreviewContactInfo;
import io.cdap.plugin.zuora.objects.PreviewOptions;
import io.cdap.plugin.zuora.objects.PreviewOptionsPreviewTypesItem;
import io.cdap.plugin.zuora.objects.PreviewOrderChargeOverride;
import io.cdap.plugin.zuora.objects.PreviewOrderChargeOverrideBillingItem;
import io.cdap.plugin.zuora.objects.PreviewOrderChargeOverridePricingItem;
import io.cdap.plugin.zuora.objects.PreviewOrderChargeUpdate;
import io.cdap.plugin.zuora.objects.PreviewOrderCreateSubscription;
import io.cdap.plugin.zuora.objects.PreviewOrderCreateSubscriptionNewSubscriptionOwnerAccountItem;
import io.cdap.plugin.zuora.objects.PreviewOrderCreateSubscriptionTermsItem;
import io.cdap.plugin.zuora.objects.PreviewOrderCreateSubscriptionTermsItemInitialTermItem;
import io.cdap.plugin.zuora.objects.PreviewOrderOrderAction;
import io.cdap.plugin.zuora.objects.PreviewOrderPricingUpdate;
import io.cdap.plugin.zuora.objects.PreviewOrderRatePlanOverride;
import io.cdap.plugin.zuora.objects.PreviewOrderRatePlanUpdate;
import io.cdap.plugin.zuora.objects.PreviewOrderTriggerParams;
import io.cdap.plugin.zuora.objects.PreviewResult;
import io.cdap.plugin.zuora.objects.PreviewResultChargeMetricsItem;
import io.cdap.plugin.zuora.objects.PreviewResultCreditMemosItem;
import io.cdap.plugin.zuora.objects.PreviewResultInvoicesItem;
import io.cdap.plugin.zuora.objects.PreviewResultOrderMetricsItem;
import io.cdap.plugin.zuora.objects.PreviewResultOrderMetricsItemOrderActionsItem;
import io.cdap.plugin.zuora.objects.PriceChangeParams;
import io.cdap.plugin.zuora.objects.PricingUpdate;
import io.cdap.plugin.zuora.objects.PricingUpdateForEvergreen;
import io.cdap.plugin.zuora.objects.ProcessingOptions;
import io.cdap.plugin.zuora.objects.ProcessingOptionsElectronicPaymentOptionsItem;
import io.cdap.plugin.zuora.objects.ProductDiscountApplyDetailsType;
import io.cdap.plugin.zuora.objects.ProductFeatureObjectCustomFields;
import io.cdap.plugin.zuora.objects.ProductFeatureType;
import io.cdap.plugin.zuora.objects.ProductObjectCustomFields;
import io.cdap.plugin.zuora.objects.ProductObjectNSFields;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargeObjectCustomFields;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargeObjectNSFields;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargePricingTierType;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargePricingType;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargeType;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargeTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.ProductRatePlanChargeTypePricingSummaryItem;
import io.cdap.plugin.zuora.objects.ProductRatePlanObjectCustomFields;
import io.cdap.plugin.zuora.objects.ProductRatePlanObjectNSFields;
import io.cdap.plugin.zuora.objects.ProductRatePlanType;
import io.cdap.plugin.zuora.objects.ProductType;
import io.cdap.plugin.zuora.objects.ProvisionEntityResponseType;
import io.cdap.plugin.zuora.objects.ProxyActionamendRequest;
import io.cdap.plugin.zuora.objects.ProxyActionamendResponse;
import io.cdap.plugin.zuora.objects.ProxyActioncreateRequest;
import io.cdap.plugin.zuora.objects.ProxyActiondeleteRequest;
import io.cdap.plugin.zuora.objects.ProxyActiondeleteRequestIdsItem;
import io.cdap.plugin.zuora.objects.ProxyActionexecuteRequest;
import io.cdap.plugin.zuora.objects.ProxyActionexecuteRequestIdsItem;
import io.cdap.plugin.zuora.objects.ProxyActiongenerateRequest;
import io.cdap.plugin.zuora.objects.ProxyActionqueryMoreRequest;
import io.cdap.plugin.zuora.objects.ProxyActionqueryMoreResponse;
import io.cdap.plugin.zuora.objects.ProxyActionqueryRequest;
import io.cdap.plugin.zuora.objects.ProxyActionqueryRequestConfItem;
import io.cdap.plugin.zuora.objects.ProxyActionqueryResponse;
import io.cdap.plugin.zuora.objects.ProxyActionsubscribeRequest;
import io.cdap.plugin.zuora.objects.ProxyActionupdateRequest;
import io.cdap.plugin.zuora.objects.ProxyBadRequestResponse;
import io.cdap.plugin.zuora.objects.ProxyBadRequestResponseErrorsItem;
import io.cdap.plugin.zuora.objects.ProxyCreateAccount;
import io.cdap.plugin.zuora.objects.ProxyCreateBillRun;
import io.cdap.plugin.zuora.objects.ProxyCreateContact;
import io.cdap.plugin.zuora.objects.ProxyCreateCreditBalanceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyCreateExport;
import io.cdap.plugin.zuora.objects.ProxyCreateInvoiceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyCreateInvoicePayment;
import io.cdap.plugin.zuora.objects.ProxyCreateOrModifyProductRatePlanChargeTierData;
import io.cdap.plugin.zuora.objects.ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem;
import io.cdap.plugin.zuora.objects.ProxyCreateOrModifyResponse;
import io.cdap.plugin.zuora.objects.ProxyCreatePayment;
import io.cdap.plugin.zuora.objects.ProxyCreatePaymentGatewayOptionDataItem;
import io.cdap.plugin.zuora.objects.ProxyCreatePaymentInvoicePaymentDataItem;
import io.cdap.plugin.zuora.objects.ProxyCreatePaymentMethod;
import io.cdap.plugin.zuora.objects.ProxyCreatePaymentMethodGatewayOptionDataItem;
import io.cdap.plugin.zuora.objects.ProxyCreateProduct;
import io.cdap.plugin.zuora.objects.ProxyCreateProductRatePlan;
import io.cdap.plugin.zuora.objects.ProxyCreateProductRatePlanCharge;
import io.cdap.plugin.zuora.objects.ProxyCreateRefund;
import io.cdap.plugin.zuora.objects.ProxyCreateRefundGatewayOptionDataItem;
import io.cdap.plugin.zuora.objects.ProxyCreateRefundRefundInvoicePaymentDataItem;
import io.cdap.plugin.zuora.objects.ProxyCreateTaxationItem;
import io.cdap.plugin.zuora.objects.ProxyCreateUnitOfMeasure;
import io.cdap.plugin.zuora.objects.ProxyCreateUsage;
import io.cdap.plugin.zuora.objects.ProxyGetAccount;
import io.cdap.plugin.zuora.objects.ProxyGetAmendment;
import io.cdap.plugin.zuora.objects.ProxyGetBillRun;
import io.cdap.plugin.zuora.objects.ProxyGetCommunicationProfile;
import io.cdap.plugin.zuora.objects.ProxyGetContact;
import io.cdap.plugin.zuora.objects.ProxyGetCreditBalanceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyGetExport;
import io.cdap.plugin.zuora.objects.ProxyGetFeature;
import io.cdap.plugin.zuora.objects.ProxyGetImport;
import io.cdap.plugin.zuora.objects.ProxyGetInvoice;
import io.cdap.plugin.zuora.objects.ProxyGetInvoiceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyGetInvoiceItem;
import io.cdap.plugin.zuora.objects.ProxyGetInvoiceItemAdjustment;
import io.cdap.plugin.zuora.objects.ProxyGetInvoicePayment;
import io.cdap.plugin.zuora.objects.ProxyGetInvoiceSplit;
import io.cdap.plugin.zuora.objects.ProxyGetInvoiceSplitItem;
import io.cdap.plugin.zuora.objects.ProxyGetPayment;
import io.cdap.plugin.zuora.objects.ProxyGetPaymentMethod;
import io.cdap.plugin.zuora.objects.ProxyGetPaymentMethodSnapshot;
import io.cdap.plugin.zuora.objects.ProxyGetPaymentMethodTransactionLog;
import io.cdap.plugin.zuora.objects.ProxyGetPaymentTransactionLog;
import io.cdap.plugin.zuora.objects.ProxyGetProduct;
import io.cdap.plugin.zuora.objects.ProxyGetProductFeature;
import io.cdap.plugin.zuora.objects.ProxyGetProductRatePlan;
import io.cdap.plugin.zuora.objects.ProxyGetProductRatePlanCharge;
import io.cdap.plugin.zuora.objects.ProxyGetProductRatePlanChargeTier;
import io.cdap.plugin.zuora.objects.ProxyGetRatePlan;
import io.cdap.plugin.zuora.objects.ProxyGetRatePlanCharge;
import io.cdap.plugin.zuora.objects.ProxyGetRatePlanChargeTier;
import io.cdap.plugin.zuora.objects.ProxyGetRefund;
import io.cdap.plugin.zuora.objects.ProxyGetRefundInvoicePayment;
import io.cdap.plugin.zuora.objects.ProxyGetRefundTransactionLog;
import io.cdap.plugin.zuora.objects.ProxyGetSubscription;
import io.cdap.plugin.zuora.objects.ProxyGetSubscriptionProductFeature;
import io.cdap.plugin.zuora.objects.ProxyGetTaxationItem;
import io.cdap.plugin.zuora.objects.ProxyGetUnitOfMeasure;
import io.cdap.plugin.zuora.objects.ProxyGetUsage;
import io.cdap.plugin.zuora.objects.ProxyModifyAccount;
import io.cdap.plugin.zuora.objects.ProxyModifyAmendment;
import io.cdap.plugin.zuora.objects.ProxyModifyBillRun;
import io.cdap.plugin.zuora.objects.ProxyModifyContact;
import io.cdap.plugin.zuora.objects.ProxyModifyCreditBalanceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyModifyInvoice;
import io.cdap.plugin.zuora.objects.ProxyModifyInvoiceAdjustment;
import io.cdap.plugin.zuora.objects.ProxyModifyInvoicePayment;
import io.cdap.plugin.zuora.objects.ProxyModifyPayment;
import io.cdap.plugin.zuora.objects.ProxyModifyPaymentMethod;
import io.cdap.plugin.zuora.objects.ProxyModifyProduct;
import io.cdap.plugin.zuora.objects.ProxyModifyProductRatePlan;
import io.cdap.plugin.zuora.objects.ProxyModifyProductRatePlanCharge;
import io.cdap.plugin.zuora.objects.ProxyModifyProductRatePlanChargeTier;
import io.cdap.plugin.zuora.objects.ProxyModifyRatePlanCharge;
import io.cdap.plugin.zuora.objects.ProxyModifyRefund;
import io.cdap.plugin.zuora.objects.ProxyModifySubscription;
import io.cdap.plugin.zuora.objects.ProxyModifyTaxationItem;
import io.cdap.plugin.zuora.objects.ProxyModifyUnitOfMeasure;
import io.cdap.plugin.zuora.objects.ProxyModifyUsage;
import io.cdap.plugin.zuora.objects.ProxyNoDataResponse;
import io.cdap.plugin.zuora.objects.ProxyNoDataResponseRecordsItem;
import io.cdap.plugin.zuora.objects.ProxyPostImport;
import io.cdap.plugin.zuora.objects.ProxyUnauthorizedResponse;
import io.cdap.plugin.zuora.objects.PublicEmailTemplateResponse;
import io.cdap.plugin.zuora.objects.PublicNotificationDefinitionResponse;
import io.cdap.plugin.zuora.objects.PublicNotificationDefinitionResponseCalloutItem;
import io.cdap.plugin.zuora.objects.PublicNotificationDefinitionResponseFilterRuleItem;
import io.cdap.plugin.zuora.objects.PutBatchInvoiceType;
import io.cdap.plugin.zuora.objects.PutCreditMemoTaxItemType;
import io.cdap.plugin.zuora.objects.PutCreditMemoTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PutDebitMemoTaxItemType;
import io.cdap.plugin.zuora.objects.PutDebitMemoTaxItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.PutEventTriggerRequest;
import io.cdap.plugin.zuora.objects.PutEventTriggerRequestEventTypeItem;
import io.cdap.plugin.zuora.objects.PutInvoiceResponseType;
import io.cdap.plugin.zuora.objects.PutInvoiceType;
import io.cdap.plugin.zuora.objects.PutReverseInvoiceResponseTypeCreditMemoItem;
import io.cdap.plugin.zuora.objects.PutReverseInvoiceType;
import io.cdap.plugin.zuora.objects.PutTasksRequest;
import io.cdap.plugin.zuora.objects.QueryCustomObjectRecordsResponse;
import io.cdap.plugin.zuora.objects.QueryUsageResponseType;
import io.cdap.plugin.zuora.objects.RSDetailForProductChargeType;
import io.cdap.plugin.zuora.objects.RSDetailType;
import io.cdap.plugin.zuora.objects.RSDetailWithoutSuccessType;
import io.cdap.plugin.zuora.objects.RatePlan;
import io.cdap.plugin.zuora.objects.RatePlanChargeData;
import io.cdap.plugin.zuora.objects.RatePlanChargeDataInRatePlanData;
import io.cdap.plugin.zuora.objects.RatePlanChargeDataInRatePlanDataRatePlanChargeItem;
import io.cdap.plugin.zuora.objects.RatePlanChargeDataRatePlanCharge;
import io.cdap.plugin.zuora.objects.RatePlanChargeObjectCustomFields;
import io.cdap.plugin.zuora.objects.RatePlanChargeTier;
import io.cdap.plugin.zuora.objects.RatePlanData;
import io.cdap.plugin.zuora.objects.RatePlanDataRatePlan;
import io.cdap.plugin.zuora.objects.RatePlanDataSubscriptionProductFeatureListItem;
import io.cdap.plugin.zuora.objects.RatePlanObjectCustomFields;
import io.cdap.plugin.zuora.objects.RatePlanOverride;
import io.cdap.plugin.zuora.objects.RatePlanOverrideForEvergreen;
import io.cdap.plugin.zuora.objects.RatePlanUpdate;
import io.cdap.plugin.zuora.objects.RatePlanUpdateForEvergreen;
import io.cdap.plugin.zuora.objects.RatedItem;
import io.cdap.plugin.zuora.objects.RatedResultsType;
import io.cdap.plugin.zuora.objects.RatedUsageResultsType;
import io.cdap.plugin.zuora.objects.RecurringFlatFeePricingOverride;
import io.cdap.plugin.zuora.objects.RecurringFlatFeePricingUpdate;
import io.cdap.plugin.zuora.objects.RecurringPerUnitPricingOverride;
import io.cdap.plugin.zuora.objects.RecurringPerUnitPricingUpdate;
import io.cdap.plugin.zuora.objects.RecurringTieredPricingOverride;
import io.cdap.plugin.zuora.objects.RecurringTieredPricingUpdate;
import io.cdap.plugin.zuora.objects.RecurringVolumePricingOverride;
import io.cdap.plugin.zuora.objects.RecurringVolumePricingUpdate;
import io.cdap.plugin.zuora.objects.RefundCreditMemoItemType;
import io.cdap.plugin.zuora.objects.RefundCreditMemoType;
import io.cdap.plugin.zuora.objects.RefundCreditMemoTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.RefundInvoicePayment;
import io.cdap.plugin.zuora.objects.RefundItemPartType;
import io.cdap.plugin.zuora.objects.RefundItemPartTypewithSuccess;
import io.cdap.plugin.zuora.objects.RefundObjectCustomFields;
import io.cdap.plugin.zuora.objects.RefundObjectNSFields;
import io.cdap.plugin.zuora.objects.RefundPartResponseType;
import io.cdap.plugin.zuora.objects.RefundPartResponseTypewithSuccess;
import io.cdap.plugin.zuora.objects.RefundPaymentType;
import io.cdap.plugin.zuora.objects.RefundPaymentTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.RefundType;
import io.cdap.plugin.zuora.objects.RefundTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.RefundTypewithSuccess;
import io.cdap.plugin.zuora.objects.RefundTypewithSuccessFinanceInformationItem;
import io.cdap.plugin.zuora.objects.RemoveProduct;
import io.cdap.plugin.zuora.objects.RenewalTerm;
import io.cdap.plugin.zuora.objects.RevenueEventDetailType;
import io.cdap.plugin.zuora.objects.RevenueEventDetailWithoutSuccessType;
import io.cdap.plugin.zuora.objects.RevenueEventItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.RevenueEventObjectCustomFields;
import io.cdap.plugin.zuora.objects.RevenueItemType;
import io.cdap.plugin.zuora.objects.RevenueScheduleItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.RevenueScheduleItemType;
import io.cdap.plugin.zuora.objects.RevenueScheduleObjectCustomFields;
import io.cdap.plugin.zuora.objects.RevenueStartDateSettingType;
import io.cdap.plugin.zuora.objects.RsRevenueItemType;
import io.cdap.plugin.zuora.objects.SaveResult;
import io.cdap.plugin.zuora.objects.SequenceSetResponse;
import io.cdap.plugin.zuora.objects.SettingItemHttpOperation;
import io.cdap.plugin.zuora.objects.SettingItemHttpOperationRequestTypeItem;
import io.cdap.plugin.zuora.objects.SettingItemHttpOperationResponseTypeItem;
import io.cdap.plugin.zuora.objects.SettingItemHttpRequestParameter;
import io.cdap.plugin.zuora.objects.SettingItemWithOperationsInformation;
import io.cdap.plugin.zuora.objects.SettingValueRequest;
import io.cdap.plugin.zuora.objects.SettingValueResponse;
import io.cdap.plugin.zuora.objects.SettingValueResponseErrorMessagesItem;
import io.cdap.plugin.zuora.objects.SettingValueResponseWrapper;
import io.cdap.plugin.zuora.objects.SettingsBatchRequest;
import io.cdap.plugin.zuora.objects.SettingsBatchResponse;
import io.cdap.plugin.zuora.objects.SoldToContact;
import io.cdap.plugin.zuora.objects.SoldToContactPostOrder;
import io.cdap.plugin.zuora.objects.StoredCredentialProfilesResponseProfilesItem;
import io.cdap.plugin.zuora.objects.SubmitDataQueryRequest;
import io.cdap.plugin.zuora.objects.SubmitDataQueryRequestOutputItem;
import io.cdap.plugin.zuora.objects.SubmitDataQueryResponse;
import io.cdap.plugin.zuora.objects.SubscribeRequest;
import io.cdap.plugin.zuora.objects.SubscribeRequestAccount;
import io.cdap.plugin.zuora.objects.SubscribeRequestBillToContact;
import io.cdap.plugin.zuora.objects.SubscribeRequestPaymentMethodItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestPaymentMethodItemGatewayOptionDataItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestPreviewOptionsItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSoldToContact;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscribeOptionsItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscribeOptionsItemElectronicPaymentOptionsItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscribeOptionsItemExternalPaymentOptionsItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscribeOptionsItemSubscribeInvoiceProcessingOptionsItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscriptionDataItem;
import io.cdap.plugin.zuora.objects.SubscribeRequestSubscriptionDataSubscription;
import io.cdap.plugin.zuora.objects.SubscribeResult;
import io.cdap.plugin.zuora.objects.SubscribeResultChargeMetricsDataItem;
import io.cdap.plugin.zuora.objects.SubscribeResultInvoiceResultItem;
import io.cdap.plugin.zuora.objects.SubscribeResultInvoiceResultItemInvoiceItem;
import io.cdap.plugin.zuora.objects.SubscriptionObjectCustomFields;
import io.cdap.plugin.zuora.objects.SubscriptionObjectNSFields;
import io.cdap.plugin.zuora.objects.SubscriptionObjectQTFields;
import io.cdap.plugin.zuora.objects.SubscriptionProductFeature;
import io.cdap.plugin.zuora.objects.SubscriptionProductFeatureList;
import io.cdap.plugin.zuora.objects.SubscriptionProductFeatureObjectCustomFields;
import io.cdap.plugin.zuora.objects.SubscriptionProductFeatureType;
import io.cdap.plugin.zuora.objects.SubscriptionRatePlanChargesType;
import io.cdap.plugin.zuora.objects.SubscriptionRatePlanType;
import io.cdap.plugin.zuora.objects.SubscriptionRatedResult;
import io.cdap.plugin.zuora.objects.SubscriptionType;
import io.cdap.plugin.zuora.objects.SubscriptionTypeWithSuccess;
import io.cdap.plugin.zuora.objects.Task;
import io.cdap.plugin.zuora.objects.TaskDataItem;
import io.cdap.plugin.zuora.objects.TaskParametersItem;
import io.cdap.plugin.zuora.objects.TaskTagsItem;
import io.cdap.plugin.zuora.objects.TasksResponse;
import io.cdap.plugin.zuora.objects.TasksResponsePaginationItem;
import io.cdap.plugin.zuora.objects.TaxInfo;
import io.cdap.plugin.zuora.objects.TaxationItemObjectCustomFields;
import io.cdap.plugin.zuora.objects.TaxationItemType;
import io.cdap.plugin.zuora.objects.TaxationItemTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.TaxationItemTypewithSuccess;
import io.cdap.plugin.zuora.objects.TaxationItemTypewithSuccessFinanceInformationItem;
import io.cdap.plugin.zuora.objects.Term;
import io.cdap.plugin.zuora.objects.TermsAndConditions;
import io.cdap.plugin.zuora.objects.TierType;
import io.cdap.plugin.zuora.objects.TimeSlicedElpNetMetrics;
import io.cdap.plugin.zuora.objects.TimeSlicedMetrics;
import io.cdap.plugin.zuora.objects.TimeSlicedMetricsForEvergreen;
import io.cdap.plugin.zuora.objects.TimeSlicedNetMetrics;
import io.cdap.plugin.zuora.objects.TimeSlicedNetMetricsForEvergreen;
import io.cdap.plugin.zuora.objects.TimeSlicedTcbNetMetrics;
import io.cdap.plugin.zuora.objects.TimeSlicedTcbNetMetricsForEvergreen;
import io.cdap.plugin.zuora.objects.TokenResponse;
import io.cdap.plugin.zuora.objects.TransferPaymentType;
import io.cdap.plugin.zuora.objects.TriggerDate;
import io.cdap.plugin.zuora.objects.TriggerParams;
import io.cdap.plugin.zuora.objects.UnapplyCreditMemoType;
import io.cdap.plugin.zuora.objects.UnapplyPaymentType;
import io.cdap.plugin.zuora.objects.UpdateCustomFieldsDefinitionRequestNoNamespace;
import io.cdap.plugin.zuora.objects.UpdateCustomObjectCusotmField;
import io.cdap.plugin.zuora.objects.UpdateCustomObjectCusotmFieldDefinitionItem;
import io.cdap.plugin.zuora.objects.UpdateEntityResponseType;
import io.cdap.plugin.zuora.objects.UpdateEntityType;
import io.cdap.plugin.zuora.objects.UpdatePaymentType;
import io.cdap.plugin.zuora.objects.UpdatePaymentTypeFinanceInformationItem;
import io.cdap.plugin.zuora.objects.UpdateTask;
import io.cdap.plugin.zuora.objects.UpdateTaskTagsItem;
import io.cdap.plugin.zuora.objects.UsageDetailResponseType;
import io.cdap.plugin.zuora.objects.UsageFlatFeePricingOverride;
import io.cdap.plugin.zuora.objects.UsageFlatFeePricingUpdate;
import io.cdap.plugin.zuora.objects.UsageImport;
import io.cdap.plugin.zuora.objects.UsageImportStatusResponseType;
import io.cdap.plugin.zuora.objects.UsageImports;
import io.cdap.plugin.zuora.objects.UsageObjectCustomFields;
import io.cdap.plugin.zuora.objects.UsageOveragePricingOverride;
import io.cdap.plugin.zuora.objects.UsageOveragePricingUpdate;
import io.cdap.plugin.zuora.objects.UsagePerUnitPricingOverride;
import io.cdap.plugin.zuora.objects.UsagePerUnitPricingUpdate;
import io.cdap.plugin.zuora.objects.UsageResponseType;
import io.cdap.plugin.zuora.objects.UsageTieredPricingOverride;
import io.cdap.plugin.zuora.objects.UsageTieredPricingUpdate;
import io.cdap.plugin.zuora.objects.UsageTieredWithOveragePricingOverride;
import io.cdap.plugin.zuora.objects.UsageTieredWithOveragePricingUpdate;
import io.cdap.plugin.zuora.objects.UsageType;
import io.cdap.plugin.zuora.objects.UsageVolumePricingOverride;
import io.cdap.plugin.zuora.objects.UsageVolumePricingUpdate;
import io.cdap.plugin.zuora.objects.Workflow;
import io.cdap.plugin.zuora.objects.WorkflowError;
import io.cdap.plugin.zuora.objects.WorkflowInstance;
import io.cdap.plugin.zuora.objects.WorkflowResponse;
import io.cdap.plugin.zuora.objects.WorkflowResponseMessagesItem;
import io.cdap.plugin.zuora.objects.WorkflowResponseTasksItem;
import io.cdap.plugin.zuora.objects.WorkflowsResponse;
import io.cdap.plugin.zuora.objects.WorkflowsResponsePaginationItem;
import io.cdap.plugin.zuora.objects.ZObject;
import io.cdap.plugin.zuora.objects.ZObject_update;
import io.cdap.plugin.zuora.objects.ZObject_updateFieldsToNullItem;
import java.util.Arrays;
import java.util.List;

/** Hardcoded list of REST Objects. */
@SuppressWarnings("rawtypes")
public class RestObjectsConfig {
  private static List<Class> objects =
      Arrays.asList(
          // base rest objects
          ProductType.class,
          RefundTypewithSuccess.class,
          Order.class,
          EntitiesType.class,
          DebitMemoTypewithSuccess.class,
          CreditMemoTypewithSuccess.class,
          BillingDocumentsResponseType.class,

          // objects to post
          CreditMemoAmountBreakdownByOrderResponse.class,
          CreditMemoType.class,
          DebitMemoType.class,
          GenerateBillingDocumentResponseType.class,
          InvoiceAmountBreakdownByOrderResponse.class,
          POSTBillingDocumentFilesDeletionJobResponse.class,
          PostOrderPreviewResponseType.class,
          PostOrderResponseType.class,
          RefundCreditMemoType.class,
          RefundPaymentType.class,
          TaxationItemTypewithSuccess.class,

          // objects to get and post
          ARPaymentType.class,
          PaymentRunType.class,

          // others rest objects
          Account.class,
          AccountCreditCardHolder.class,
          AccountObjectCustomFields.class,
          AccountObjectNSFields.class,
          AccountingCodeObjectCustomFields.class,
          AccountingPeriodObjectCustomFields.class,
          ActionsErrorResponse.class,
          AmendRequestAmendOptionsItem.class,
          AmendRequestPreviewOptionsItem.class,
          AmendRequest.class,
          AmendResultAmendmentIdsItem.class,
          AmendResult.class,
          AmendmentRatePlanDataItem.class,
          Amendment.class,
          AmendmentObjectCustomFields.class,
          AmendmentRatePlanChargeData.class,
          AmendmentRatePlanChargeDataRatePlanCharge.class,
          AmendmentRatePlanChargeTier.class,
          ApplyCreditMemoType.class,
          ApplyPaymentType.class,
          BadRequestResponseErrorsItem.class,
          BadRequestResponse.class,
          BatchDebitMemoType.class,
          BatchInvoiceType.class,
          BillToContact.class,
          BillToContactPostOrder.class,
          BillingOptions.class,
          BillingPreviewResult.class,
          BillingUpdate.class,
          BodyInSettingValueReponse.class,
          BodyInSettingValueRequest.class,
          BreakdownDetail.class,
          CalloutAuth.class,
          CalloutMergeFields.class,
          CancelSubscription.class,
          ChargeMetricsData.class,
          ChargeOverrideBillingItem.class,
          ChargeOverridePricingItem.class,
          ChargeOverride.class,
          ChargeOverrideForEvergreenBillingItem.class,
          ChargeOverrideForEvergreenPricingItem.class,
          ChargeOverrideForEvergreen.class,
          ChargePreviewMetricsCmrrItem.class,
          ChargePreviewMetricsTaxItem.class,
          ChargePreviewMetricsTcbItem.class,
          ChargePreviewMetricsTcvItem.class,
          ChargePreviewMetrics.class,
          ChargeRatedResult.class,
          ChargeTier.class,
          ChargeUpdate.class,
          ChargeUpdateForEvergreen.class,
          ChildrenSettingValueRequest.class,
          CommonErrorResponse.class,
          CommonRatingErrorResponseReasonsItem.class,
          CommonRatingErrorResponse.class,
          CommonResponseTypeReasonsItem.class,
          CommonResponseType.class,
          CommonUsageErrorResponseErrorItemErrorsItem.class,
          CommonUsageErrorResponseErrorItem.class,
          CommonUsageErrorResponse.class,
          CommonUsageImportsErrorResponseErrorItemErrorsItem.class,
          CommonUsageImportsErrorResponseErrorItem.class,
          CommonUsageImportsErrorResponse.class,
          Contact.class,
          ContactObjectCustomFields.class,
          CreateEntityResponseType.class,
          CreateEntityType.class,
          CreateOrderChargeOverrideBillingItem.class,
          CreateOrderChargeOverridePricingItem.class,
          CreateOrderChargeOverride.class,
          CreateOrderChargeUpdate.class,
          CreateOrderCreateSubscriptionTermsItemInitialTermItem.class,
          CreateOrderCreateSubscriptionTermsItem.class,
          CreateOrderCreateSubscription.class,
          CreateOrderCreateSubscriptionNewSubscriptionOwnerAccount.class,
          CreateOrderOrderAction.class,
          CreateOrderPricingUpdate.class,
          CreateOrderRatePlanOverride.class,
          CreateOrderRatePlanUpdate.class,
          CreateOrderResume.class,
          CreateOrderSuspend.class,
          CreateOrderTermsAndConditions.class,
          CreateOrderTriggerParams.class,
          CreatePMPayPalECPayPalNativeEC.class,
          CreatePaymentMethodACH.class,
          CreatePaymentMethodCardholderInfo.class,
          CreatePaymentMethodCommon.class,
          CreatePaymentMethodCreditCard.class,
          CreatePaymentMethodPayPalAdaptive.class,
          CreatePaymentTypeFinanceInformationItem.class,
          CreatePaymentType.class,
          CreateStoredCredentialProfileRequest.class,
          CreateSubscriptionNewSubscriptionOwnerAccountItem.class,
          CreateSubscriptionTermsItemInitialTermItem.class,
          CreateSubscriptionTermsItem.class,
          CreateSubscription.class,
          CreateSubscriptionForEvergreenNewSubscriptionOwnerAccountItem.class,
          CreateSubscriptionForEvergreenTermsItemInitialTermItem.class,
          CreateSubscriptionForEvergreenTermsItem.class,
          CreateSubscriptionForEvergreen.class,
          CreditBalanceAdjustmentObjectCustomFields.class,
          CreditBalanceAdjustmentObjectNSFields.class,
          CreditMemoApplyDebitMemoItemRequestType.class,
          CreditMemoApplyDebitMemoRequestType.class,
          CreditMemoApplyInvoiceItemRequestType.class,
          CreditMemoApplyInvoiceRequestType.class,
          CreditMemoEntityPrefix.class,
          CreditMemoFromChargeDetailTypeFinanceInformationItem.class,
          CreditMemoFromChargeDetailType.class,
          CreditMemoFromChargeType.class,
          CreditMemoFromInvoiceType.class,
          CreditMemoItemBreakdown.class,
          CreditMemoItemFromInvoiceItemTypeFinanceInformationItem.class,
          CreditMemoItemFromInvoiceItemType.class,
          CreditMemoItemFromWriteOffInvoiceFinanceInformationItem.class,
          CreditMemoItemFromWriteOffInvoice.class,
          CreditMemoItemObjectCustomFields.class,
          CreditMemoObjectCustomFields.class,
          CreditMemoObjectNSFields.class,
          CreditMemoResponseType.class,
          CreditMemoTaxItemFromInvoiceTaxItemTypeFinanceInformationItem.class,
          CreditMemoTaxItemFromInvoiceTaxItemType.class,
          CreditMemoUnapplyDebitMemoItemRequestType.class,
          CreditMemoUnapplyDebitMemoRequestType.class,
          CreditMemoUnapplyInvoiceItemRequestType.class,
          CreditMemoUnapplyInvoiceRequestType.class,
          CustomFields.class,
          CustomFieldsDefinitionNoNamespaceSchemaItem.class,
          CustomFieldsDefinitionNoNamespace.class,
          CustomObjectAllFieldsDefinitionCreatedByIdItem.class,
          CustomObjectAllFieldsDefinitionCreatedDateItem.class,
          CustomObjectAllFieldsDefinitionIdItem.class,
          CustomObjectAllFieldsDefinitionUpdatedByIdItem.class,
          CustomObjectAllFieldsDefinitionUpdatedDateItem.class,
          CustomObjectAllFieldsDefinition.class,
          CustomObjectCustomFieldDefinition.class,
          CustomObjectCustomFieldDefinitionUpdate.class,
          CustomObjectCustomFieldsDefinition.class,
          CustomObjectDefinitionSchemaItemPropertiesItem.class,
          CustomObjectDefinitionSchemaItemRelationshipsItem.class,
          CustomObjectDefinitionSchemaItemRequiredItem.class,
          CustomObjectDefinitionSchemaItem.class,
          CustomObjectDefinition.class,
          CustomObjectDefinitionUpdateActionRequestRelationshipItem.class,
          CustomObjectDefinitionUpdateActionRequest.class,
          CustomObjectDefinitionUpdateActionResponseRelationshipItem.class,
          CustomObjectDefinitionUpdateActionResponse.class,
          CustomObjectDefinitions.class,
          CustomObjectRecordBatchActionIdsItem.class,
          CustomObjectRecordBatchActionRecordsItem.class,
          CustomObjectRecordBatchAction.class,
          CustomObjectRecordBatchActionResultUnprocessedIdsItem.class,
          CustomObjectRecordBatchActionResult.class,
          CustomObjectRecordBatchRequestActionItem.class,
          CustomObjectRecordBatchRequest.class,
          CustomObjectRecordBatchResponseResultItem.class,
          CustomObjectRecordBatchResponse.class,
          CustomObjectRecordBatchUpdateMapping.class,
          CustomObjectRecordWithAllFields.class,
          CustomObjectRecordWithOnlyCustomFields.class,
          CustomObjectsNamespace.class,
          DELETEUsageResponseType.class,
          DELETEntityResponseType.class,
          DataAccessControlField.class,
          DataQueryErrorResponse.class,
          DataQueryJob.class,
          DataQueryJobCancelled.class,
          DataQueryJobCommon.class,
          DebitMemoEntityPrefix.class,
          DebitMemoFromChargeDetailTypeFinanceInformationItem.class,
          DebitMemoFromChargeDetailType.class,
          DebitMemoFromChargeType.class,
          DebitMemoFromInvoiceType.class,
          DebitMemoItemFromInvoiceItemTypeFinanceInformationItem.class,
          DebitMemoItemFromInvoiceItemType.class,
          DebitMemoItemObjectCustomFields.class,
          DebitMemoObjectCustomFields.class,
          DebitMemoObjectNSFields.class,
          DebitMemoTaxItemFromInvoiceTaxItemTypeFinanceInformationItem.class,
          DebitMemoTaxItemFromInvoiceTaxItemType.class,
          DeleteDataQueryJobResponse.class,
          DeleteResult.class,
          DiscountPricingOverride.class,
          DiscountPricingUpdate.class,
          ElectronicPaymentOptions.class,
          EndConditions.class,
          ErrorResponseReasonsItem.class,
          ErrorResponse.class,
          EventRevenueItemType.class,
          EventTrigger.class,
          EventType.class,
          ExecuteResult.class,
          ExternalPaymentOptions.class,
          FeatureObjectCustomFields.class,
          FieldsAdditionalProperties.class,
          FilterRuleParameterDefinitionOptionsItem.class,
          FilterRuleParameterDefinition.class,
          FilterRuleParameterDefinitions.class,
          FilterRuleParameterValues.class,
          APaymentGatwayResponse.class,
          ARPaymentTypeFinanceInformationItem.class,
          ARPaymentTypewithSuccessFinanceInformationItem.class,
          ARPaymentTypewithSuccess.class,
          ARatedResultTypeAdditionalInfoItem.class,
          ARatedResultType.class,
          AccountSummaryInvoiceType.class,
          AccountSummaryPaymentInvoiceType.class,
          AccountSummaryPaymentType.class,
          AccountSummarySubscriptionRatePlanType.class,
          AccountSummarySubscriptionType.class,
          AccountSummaryTypeTaxInfoItem.class,
          AccountSummaryType.class,
          AccountSummaryTypeBasicInfoAdditionalEmailAddressesItem.class,
          AccountSummaryTypeBasicInfoDefaultPaymentMethodItem.class,
          AccountSummaryTypeBasicInfo.class,
          AccountSummaryTypeBillToContact.class,
          AccountSummaryTypeSoldToContact.class,
          AccountSummaryUsageType.class,
          AccountTypeBillingAndPaymentItemAdditionalEmailAddressesItem.class,
          AccountTypeBillingAndPaymentItem.class,
          AccountTypeMetricsItem.class,
          AccountTypeTaxInfoItem.class,
          AccountType.class,
          AccountTypeBasicInfo.class,
          AccountTypeBillToContact.class,
          AccountTypeSoldToContact.class,
          AccountingCodeItemType.class,
          AccountingCodeItemWithoutSuccessType.class,
          AccountingPeriodTypeFileIdsItem.class,
          AccountingPeriodType.class,
          AccountingPeriodWithoutSuccessTypeFileIdsItem.class,
          AccountingPeriodWithoutSuccessType.class,
          AllCustomObjectDefinitionsInNamespaceResponse.class,
          AmendmentType.class,
          AttachmentResponseType.class,
          AttachmentResponseWithoutSuccessType.class,
          BillingDocumentFilesDeletionJobResponse.class,
          CMTaxItemTypeFinanceInformationItem.class,
          CMTaxItemType.class,
          CMTaxItemTypeNewFinanceInformationItem.class,
          CMTaxItemTypeNew.class,
          CalloutHistoryVOType.class,
          ChargeRSDetailType.class,
          CreditMemoItemPartType.class,
          CreditMemoItemPartTypewithSuccess.class,
          CreditMemoItemTypeFinanceInformationItem.class,
          CreditMemoItemType.class,
          CreditMemoItemTypewithSuccessFinanceInformationItem.class,
          CreditMemoItemTypewithSuccess.class,
          CreditMemoPartType.class,
          CreditMemoPartTypewithSuccess.class,
          CustomExchangeRatesDataTypeDATEItem.class,
          CustomExchangeRatesDataType.class,
          CustomExchangeRatesType.class,
          DMTaxItemTypeFinanceInformationItem.class,
          DMTaxItemType.class,
          DMTaxItemTypeNewFinanceInformationItem.class,
          DMTaxItemTypeNew.class,
          DebitMemoItemTypeFinanceInformationItem.class,
          DebitMemoItemType.class,
          DebitMemoItemTypewithSuccessFinanceInformationItem.class,
          DebitMemoItemTypewithSuccess.class,
          DiscountApplyDetailsType.class,
          DocumentPropertiesResponseType.class,
          EmailHistoryVOType.class,
          EntitiesResponseTypeWithId.class,
          EntityConnectionsArrayItemsType.class,
          InvoiceTaxItemType.class,
          InvoiceType.class,
          JournalEntryDetailType.class,
          JournalEntryDetailTypeWithoutSuccess.class,
          JournalEntryItemType.class,
          JournalEntrySegmentType.class,
          JournalRunTransactionType.class,
          JournalRunType.class,
          MassUpdateType.class,
          PaidInvoicesType.class,
          PaymentItemPartType.class,
          PaymentItemPartTypewithSuccess.class,
          PaymentMethodTypeCardHolderInfoItem.class,
          PaymentMethodType.class,
          PaymentPartType.class,
          PaymentPartTypewithSuccess.class,
          PaymentRunSummaryResponse.class,
          PaymentRunSummaryTotalValues.class,
          PaymentType.class,
          ProductDiscountApplyDetailsType.class,
          ProductRatePlanChargePricingTierType.class,
          ProductRatePlanChargePricingType.class,
          ProductRatePlanChargeTypeFinanceInformationItem.class,
          ProductRatePlanChargeTypePricingSummaryItem.class,
          ProductRatePlanChargeType.class,
          ProductRatePlanType.class,
          PublicEmailTemplateResponse.class,
          PublicNotificationDefinitionResponseCalloutItem.class,
          PublicNotificationDefinitionResponseFilterRuleItem.class,
          PublicNotificationDefinitionResponse.class,
          RSDetailForProductChargeType.class,
          RSDetailType.class,
          RSDetailWithoutSuccessType.class,
          RefundCreditMemoTypeFinanceInformationItem.class,
          RefundItemPartType.class,
          RefundItemPartTypewithSuccess.class,
          RefundPaymentTypeFinanceInformationItem.class,
          RefundTypeFinanceInformationItem.class,
          RefundType.class,
          RefundTypewithSuccessFinanceInformationItem.class,
          RevenueEventDetailType.class,
          RevenueEventDetailWithoutSuccessType.class,
          RevenueItemType.class,
          RevenueStartDateSettingType.class,
          RsRevenueItemType.class,
          SequenceSetResponse.class,
          SubscriptionProductFeatureType.class,
          SubscriptionRatePlanChargesType.class,
          SubscriptionRatePlanType.class,
          SubscriptionType.class,
          SubscriptionTypeWithSuccess.class,
          TaxationItemTypeFinanceInformationItem.class,
          TaxationItemType.class,
          TaxationItemTypewithSuccessFinanceInformationItem.class,
          TierType.class,
          UsageImportStatusResponseType.class,
          UsageResponseType.class,
          UsageType.class,
          GatewayOption.class,
          ARatedUsageResultType.class,
          BillingPreviewRunResponse.class,
          CustomObjectsAllNamespacesResponse.class,
          DataQueryJobResponse.class,
          DataQueryJobsResponse.class,
          DebitMemoApplicationPartType.class,
          HostedPageType.class,
          InvoiceApplicationPartType.class,
          OrderRatedResultResponseType.class,
          OrderResponse.class,
          OrderResponseForEvergreen.class,
          OrderResume.class,
          OrderSuspend.class,
          ProductFeatureType.class,
          RatedResultsType.class,
          RatedUsageResultsType.class,
          StoredCredentialProfilesResponseProfilesItem.class,
          UsageDetailResponseType.class,
          WorkflowResponseMessagesItem.class,
          WorkflowResponseTasksItem.class,
          WorkflowResponse.class,
          WorkflowsResponsePaginationItem.class,
          WorkflowsResponse.class,
          InitialTerm.class,
          Invoice.class,
          InvoiceAdjustmentObjectCustomFields.class,
          InvoiceData.class,
          InvoiceDataInvoice.class,
          InvoiceEntityPrefix.class,
          InvoiceFile.class,
          InvoiceItem.class,
          InvoiceItemAdjustmentObjectCustomFields.class,
          InvoiceItemBreakdown.class,
          InvoiceItemObjectCustomFields.class,
          InvoiceItemObjectNSFields.class,
          InvoiceItemPreviewResultAdditionalInfoItem.class,
          InvoiceItemPreviewResult.class,
          InvoiceObjectCustomFields.class,
          InvoiceObjectNSFields.class,
          InvoicePayment.class,
          InvoiceProcessingOptions.class,
          InvoiceResponseType.class,
          JobResultCreditMemoNumbersItem.class,
          JobResultInvoiceNumbersItem.class,
          JobResultSubscriptionNumbersItem.class,
          JobResultSubscriptionsItem.class,
          JobResult.class,
          JournalEntryItemObjectCustomFields.class,
          JournalEntryObjectCustomFields.class,
          LastTerm.class,
          Linkage.class,
          ListAllSettingsResponse.class,
          MigrationUpdateCustomObjectDefinitionsRequest.class,
          MigrationUpdateCustomObjectDefinitionsResponse.class,
          ModifiedStoredCredentialProfileResponse.class,
          NewChargeMetrics.class,
          OneTimeFlatFeePricingOverride.class,
          OneTimePerUnitPricingOverride.class,
          OneTimeTieredPricingOverride.class,
          OneTimeVolumePricingOverride.class,
          OrderSubscriptionsItem.class,
          OrderAction.class,
          OrderActionForEvergreen.class,
          OrderActionObjectCustomFields.class,
          OrderForEvergreenSubscriptionsItem.class,
          OrderForEvergreen.class,
          OrderItem.class,
          OrderMetricsForEvergreen.class,
          OrderObjectCustomFields.class,
          OrderRatedResult.class,
          OwnerTransfer.class,
          POSTAccountResponseType.class,
          POSTAccountTypeAdditionalEmailAddressesItem.class,
          POSTAccountTypeTaxInfoItem.class,
          POSTAccountType.class,
          POSTAccountTypeBillToContact.class,
          POSTAccountTypeCreditCardCardHolderInfoItem.class,
          POSTAccountTypeCreditCard.class,
          POSTAccountTypeSoldToContact.class,
          POSTAccountTypeSubscription.class,
          POSTAccountingCodeType.class,
          POSTAccountingPeriodType.class,
          POSTAttachmentResponseType.class,
          POSTAuthorizeResponse.class,
          POSTBillingDocumentFilesDeletionJobRequestAccountIdsItem.class,
          POSTBillingDocumentFilesDeletionJobRequest.class,
          POSTBillingPreviewCreditMemoItem.class,
          POSTBillingPreviewInvoiceItem.class,
          POSTCatalogTypeToEntityIdsItem.class,
          POSTCatalogType.class,
          POSTCreditMemoItemsForOrderBreakdownMemoItemIdsItem.class,
          POSTCreditMemoItemsForOrderBreakdown.class,
          POSTDecryptResponseType.class,
          POSTDecryptionType.class,
          POSTDelayAuthorizeCapture.class,
          POSTDistributionItemType.class,
          POSTDocumentPropertiesType.class,
          POSTEmailBillingDocfromBillRunType.class,
          POSTEntityConnectionsType.class,
          POSTHMACSignatureResponseType.class,
          POSTHMACSignatureType.class,
          POSTInvoiceCollectCreditMemosType.class,
          POSTInvoiceCollectInvoicesType.class,
          POSTInvoiceCollectResponseType.class,
          POSTInvoiceCollectType.class,
          POSTInvoiceItemsForOrderBreakdownInvoiceItemIdsItem.class,
          POSTInvoiceItemsForOrderBreakdown.class,
          POSTJournalEntryItemType.class,
          POSTJournalEntrySegmentType.class,
          POSTJournalEntryType.class,
          POSTJournalRunTransactionType.class,
          POSTJournalRunType.class,
          POSTMemoPdfResponse.class,
          POSTOrderPreviewRequestTypeSubscriptionsItem.class,
          POSTOrderPreviewRequestType.class,
          POSTOrderRequestTypeSubscriptionsItem.class,
          POSTOrderRequestType.class,
          POSTPaymentMethodDecryptionCardHolderInfoItem.class,
          POSTPaymentMethodDecryptionPaymentTokenItem.class,
          POSTPaymentMethodDecryption.class,
          POSTPaymentMethodRequest.class,
          POSTPaymentMethodResponseReasonsItem.class,
          POSTPaymentMethodResponse.class,
          POSTPaymentMethodResponseDecryption.class,
          POSTPaymentMethodType.class,
          POSTPaymentRunRequest.class,
          POSTPublicEmailTemplateRequest.class,
          POSTPublicNotificationDefinitionRequestCalloutItem.class,
          POSTPublicNotificationDefinitionRequestFilterRuleItem.class,
          POSTPublicNotificationDefinitionRequest.class,
          POSTQuoteDocType.class,
          POSTRSASignatureResponseType.class,
          POSTRSASignatureType.class,
          POSTRejectPaymentRequest.class,
          POSTRejectPaymentResponseFinanceInformationItem.class,
          POSTRejectPaymentResponse.class,
          POSTRevenueScheduleByChargeType.class,
          POSTRevenueScheduleByChargeTypeRevenueEvent.class,
          POSTRevenueScheduleByDateRangeType.class,
          POSTRevenueScheduleByDateRangeTypeRevenueEvent.class,
          POSTRevenueScheduleByTransactionRatablyCMType.class,
          POSTRevenueScheduleByTransactionRatablyDMType.class,
          POSTRevenueScheduleByTransactionRatablyTypeRevenueEvent.class,
          POSTRevenueScheduleByTransactionType.class,
          POSTRevenueScheduleByTransactionTypeRevenueEvent.class,
          POSTReversePaymentRequest.class,
          POSTReversePaymentResponseFinanceInformationItem.class,
          POSTReversePaymentResponse.class,
          POSTScCreateType.class,
          POSTSequenceSetRequest.class,
          POSTSequenceSetsRequest.class,
          POSTSettlePaymentRequest.class,
          POSTSettlePaymentResponseFinanceInformationItem.class,
          POSTSettlePaymentResponse.class,
          POSTSrpCreateType.class,
          POSTSubscriptionCancellationResponseType.class,
          POSTSubscriptionCancellationType.class,
          POSTSubscriptionPreviewCreditMemoItemsType.class,
          POSTSubscriptionPreviewInvoiceItemsType.class,
          POSTSubscriptionPreviewResponseTypeChargeMetricsItem.class,
          POSTSubscriptionPreviewResponseTypeCreditMemoItem.class,
          POSTSubscriptionPreviewResponseTypeInvoiceItem.class,
          POSTSubscriptionPreviewResponseType.class,
          POSTSubscriptionPreviewType.class,
          POSTSubscriptionPreviewTypePreviewAccountInfoBillToContactItem.class,
          POSTSubscriptionPreviewTypePreviewAccountInfo.class,
          POSTSubscriptionResponseType.class,
          POSTSubscriptionType.class,
          POSTTaxationItemForCMTypeFinanceInformationItem.class,
          POSTTaxationItemForCMType.class,
          POSTTaxationItemForDMTypeFinanceInformationItem.class,
          POSTTaxationItemForDMType.class,
          POSTTaxationItemListForCMType.class,
          POSTTaxationItemListForDMType.class,
          POSTTierType.class,
          POSTUsageImportResponseType.class,
          POSTUsageRecordRequestType.class,
          POSTUsageRecordResponseTypeDataItem.class,
          POSTUsageRecordResponseType.class,
          POSTUsageResponseType.class,
          POSTUsageType.class,
          POSTVoidAuthorize.class,
          POSTVoidAuthorizeResponse.class,
          PUTAcceptUserAccessResponseType.class,
          PUTAccountTypeAdditionalEmailAddressesItem.class,
          PUTAccountTypeTaxInfoItem.class,
          PUTAccountType.class,
          PUTAccountTypeBillToContact.class,
          PUTAccountTypeSoldToContact.class,
          PUTAccountingCodeType.class,
          PUTAccountingPeriodType.class,
          PUTAllocateManuallyType.class,
          PUTAttachmentType.class,
          PUTBatchDebitMemosRequest.class,
          PUTCreditMemoItemTypeFinanceInformationItem.class,
          PUTCreditMemoItemType.class,
          PUTCreditMemoType.class,
          PUTDebitMemoItemTypeFinanceInformationItem.class,
          PUTDebitMemoItemType.class,
          PUTDebitMemoType.class,
          PUTDenyUserAccessResponseType.class,
          PUTDocumentPropertiesType.class,
          PUTEntityConnectionsAcceptResponseType.class,
          PUTEntityConnectionsDenyResponseType.class,
          PUTEntityConnectionsDisconnectResponseType.class,
          PUTEventRIDetailType.class,
          PUTJournalEntryItemType.class,
          PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItemChargesItem.class,
          PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItemTriggerDatesItem
              .class,
          PUTOrderActionTriggerDatesRequestTypeSubscriptionsItemOrderActionsItem.class,
          PUTOrderActionTriggerDatesRequestTypeSubscriptionsItem.class,
          PUTOrderActionTriggerDatesRequestType.class,
          PUTOrderPatchRequestTypeSubscriptionsItemOrderActionsItem.class,
          PUTOrderPatchRequestTypeSubscriptionsItem.class,
          PUTOrderPatchRequestType.class,
          PUTOrderTriggerDatesResponseTypeSubscriptionsItem.class,
          PUTOrderTriggerDatesResponseType.class,
          PUTPaymentMethodType.class,
          PUTPaymentRunRequest.class,
          PUTPublicCalloutOptionsRequest.class,
          PUTPublicEmailTemplateRequest.class,
          PUTPublicNotificationDefinitionRequestCalloutItem.class,
          PUTPublicNotificationDefinitionRequestFilterRuleItem.class,
          PUTPublicNotificationDefinitionRequest.class,
          PUTRSBasicInfoType.class,
          PUTRSTermType.class,
          PUTRefundTypeFinanceInformationItem.class,
          PUTRefundType.class,
          PUTRenewSubscriptionResponseType.class,
          PUTRenewSubscriptionType.class,
          PUTScAddType.class,
          PUTScUpdateType.class,
          PUTScheduleRIDetailType.class,
          PUTSendUserAccessRequestResponseType.class,
          PUTSendUserAccessRequestTypeTargetEntityIdsItem.class,
          PUTSendUserAccessRequestType.class,
          PUTSequenceSetRequest.class,
          PUTSequenceSetResponse.class,
          PUTSpecificDateAllocationType.class,
          PUTSrpAddType.class,
          PUTSrpRemoveType.class,
          PUTSrpUpdateType.class,
          PUTSubscriptionPatchRequestTypeRatePlansItemChargesItem.class,
          PUTSubscriptionPatchRequestTypeRatePlansItem.class,
          PUTSubscriptionPatchRequestType.class,
          PUTSubscriptionPreviewInvoiceItemsType.class,
          PUTSubscriptionResponseTypeChargeMetricsItem.class,
          PUTSubscriptionResponseTypeCreditMemoItem.class,
          PUTSubscriptionResponseTypeInvoiceItem.class,
          PUTSubscriptionResponseType.class,
          PUTSubscriptionResumeResponseType.class,
          PUTSubscriptionResumeType.class,
          PUTSubscriptionSuspendResponseType.class,
          PUTSubscriptionSuspendType.class,
          PUTSubscriptionType.class,
          PUTTaxationItemTypeFinanceInformationItem.class,
          PUTTaxationItemType.class,
          PUTUpdateUsageResponseType.class,
          PUTUsageType.class,
          PUTVerifyPaymentMethodTypeGatewayOptionsItem.class,
          PUTVerifyPaymentMethodType.class,
          PUTWriteOffInvoiceRequest.class,
          PUTWriteOffInvoiceResponseCreditMemoItem.class,
          PUT_BasicSummaryJournalEntryType.class,
          PaymentDebitMemoApplicationApplyRequestType.class,
          PaymentDebitMemoApplicationCreateRequestType.class,
          PaymentDebitMemoApplicationItemApplyRequestType.class,
          PaymentDebitMemoApplicationItemCreateRequestType.class,
          PaymentDebitMemoApplicationItemUnapplyRequestType.class,
          PaymentDebitMemoApplicationUnapplyRequestType.class,
          PaymentInvoiceApplicationApplyRequestType.class,
          PaymentInvoiceApplicationCreateRequestType.class,
          PaymentInvoiceApplicationItemApplyRequestType.class,
          PaymentInvoiceApplicationItemCreateRequestType.class,
          PaymentInvoiceApplicationItemUnapplyRequestType.class,
          PaymentInvoiceApplicationUnapplyRequestType.class,
          PaymentMethodObjectCustomFields.class,
          PaymentObjectCustomFields.class,
          PaymentObjectNSFields.class,
          PostBillingPreviewParam.class,
          PostBillingPreviewRunParam.class,
          PostCreditMemoEmailRequestType.class,
          PostCustomObjectDefinitionFieldDefinitionRequest.class,
          PostCustomObjectDefinitionFieldsDefinitionRequest.class,
          PostCustomObjectDefinitionRequestPropertiesItem.class,
          PostCustomObjectDefinitionRequestRelationshipsItem.class,
          PostCustomObjectDefinitionRequestRequiredItem.class,
          PostCustomObjectDefinitionRequest.class,
          PostCustomObjectRecordsRequest.class,
          PostCustomObjectRecordsResponse.class,
          PostDebitMemoEmailType.class,
          PostEventTriggerRequest.class,
          PostGenerateBillingDocumentTypeChargeTypeToExcludeItem.class,
          PostGenerateBillingDocumentTypeSubscriptionIdsItem.class,
          PostGenerateBillingDocumentType.class,
          PostInvoiceEmailRequestType.class,
          PostNonRefRefundTypeFinanceInformationItem.class,
          PostNonRefRefundType.class,
          PostOrderResponseTypeCreditMemoIdsItem.class,
          PostOrderResponseTypeCreditMemoNumbersItem.class,
          PostOrderResponseTypeInvoiceIdsItem.class,
          PostOrderResponseTypeInvoiceNumbersItem.class,
          PostOrderResponseTypeSubscriptionIdsItem.class,
          PostOrderResponseTypeSubscriptionNumbersItem.class,
          PostOrderResponseTypeSubscriptionsItem.class,
          PostRefundTypeFinanceInformationItem.class,
          PostRefundType.class,
          PreviewAccountInfo.class,
          PreviewContactInfo.class,
          PreviewOptionsPreviewTypesItem.class,
          PreviewOptions.class,
          PreviewOrderChargeOverrideBillingItem.class,
          PreviewOrderChargeOverridePricingItem.class,
          PreviewOrderChargeOverride.class,
          PreviewOrderChargeUpdate.class,
          PreviewOrderCreateSubscriptionNewSubscriptionOwnerAccountItem.class,
          PreviewOrderCreateSubscriptionTermsItemInitialTermItem.class,
          PreviewOrderCreateSubscriptionTermsItem.class,
          PreviewOrderCreateSubscription.class,
          PreviewOrderOrderAction.class,
          PreviewOrderPricingUpdate.class,
          PreviewOrderRatePlanOverride.class,
          PreviewOrderRatePlanUpdate.class,
          PreviewOrderTriggerParams.class,
          PreviewResultChargeMetricsItem.class,
          PreviewResultCreditMemosItem.class,
          PreviewResultInvoicesItem.class,
          PreviewResultOrderMetricsItemOrderActionsItem.class,
          PreviewResultOrderMetricsItem.class,
          PreviewResult.class,
          PriceChangeParams.class,
          PricingUpdate.class,
          PricingUpdateForEvergreen.class,
          ProcessingOptionsElectronicPaymentOptionsItem.class,
          ProcessingOptions.class,
          ProductFeatureObjectCustomFields.class,
          ProductObjectCustomFields.class,
          ProductObjectNSFields.class,
          ProductRatePlanChargeObjectCustomFields.class,
          ProductRatePlanChargeObjectNSFields.class,
          ProductRatePlanObjectCustomFields.class,
          ProductRatePlanObjectNSFields.class,
          ProvisionEntityResponseType.class,
          ProxyActionamendRequest.class,
          ProxyActionamendResponse.class,
          ProxyActioncreateRequest.class,
          ProxyActiondeleteRequestIdsItem.class,
          ProxyActiondeleteRequest.class,
          ProxyActionexecuteRequestIdsItem.class,
          ProxyActionexecuteRequest.class,
          ProxyActiongenerateRequest.class,
          ProxyActionqueryMoreRequest.class,
          ProxyActionqueryMoreResponse.class,
          ProxyActionqueryRequestConfItem.class,
          ProxyActionqueryRequest.class,
          ProxyActionqueryResponse.class,
          ProxyActionsubscribeRequest.class,
          ProxyActionupdateRequest.class,
          ProxyBadRequestResponseErrorsItem.class,
          ProxyBadRequestResponse.class,
          ProxyCreateAccount.class,
          ProxyCreateBillRun.class,
          ProxyCreateContact.class,
          ProxyCreateCreditBalanceAdjustment.class,
          ProxyCreateExport.class,
          ProxyCreateInvoiceAdjustment.class,
          ProxyCreateInvoicePayment.class,
          ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierItem.class,
          ProxyCreateOrModifyProductRatePlanChargeTierData.class,
          ProxyCreateOrModifyResponse.class,
          ProxyCreatePaymentGatewayOptionDataItem.class,
          ProxyCreatePaymentInvoicePaymentDataItem.class,
          ProxyCreatePayment.class,
          ProxyCreatePaymentMethodGatewayOptionDataItem.class,
          ProxyCreatePaymentMethod.class,
          ProxyCreateProduct.class,
          ProxyCreateProductRatePlan.class,
          ProxyCreateProductRatePlanCharge.class,
          ProxyCreateRefundGatewayOptionDataItem.class,
          ProxyCreateRefundRefundInvoicePaymentDataItem.class,
          ProxyCreateRefund.class,
          ProxyCreateTaxationItem.class,
          ProxyCreateUnitOfMeasure.class,
          ProxyCreateUsage.class,
          ProxyGetAccount.class,
          ProxyGetAmendment.class,
          ProxyGetBillRun.class,
          ProxyGetCommunicationProfile.class,
          ProxyGetContact.class,
          ProxyGetCreditBalanceAdjustment.class,
          ProxyGetExport.class,
          ProxyGetFeature.class,
          ProxyGetImport.class,
          ProxyGetInvoice.class,
          ProxyGetInvoiceAdjustment.class,
          ProxyGetInvoiceItem.class,
          ProxyGetInvoiceItemAdjustment.class,
          ProxyGetInvoicePayment.class,
          ProxyGetInvoiceSplit.class,
          ProxyGetInvoiceSplitItem.class,
          ProxyGetPayment.class,
          ProxyGetPaymentMethod.class,
          ProxyGetPaymentMethodSnapshot.class,
          ProxyGetPaymentMethodTransactionLog.class,
          ProxyGetPaymentTransactionLog.class,
          ProxyGetProduct.class,
          ProxyGetProductFeature.class,
          ProxyGetProductRatePlan.class,
          ProxyGetProductRatePlanCharge.class,
          ProxyGetProductRatePlanChargeTier.class,
          ProxyGetRatePlan.class,
          ProxyGetRatePlanCharge.class,
          ProxyGetRatePlanChargeTier.class,
          ProxyGetRefund.class,
          ProxyGetRefundInvoicePayment.class,
          ProxyGetRefundTransactionLog.class,
          ProxyGetSubscription.class,
          ProxyGetSubscriptionProductFeature.class,
          ProxyGetTaxationItem.class,
          ProxyGetUnitOfMeasure.class,
          ProxyGetUsage.class,
          ProxyModifyAccount.class,
          ProxyModifyAmendment.class,
          ProxyModifyBillRun.class,
          ProxyModifyContact.class,
          ProxyModifyCreditBalanceAdjustment.class,
          ProxyModifyInvoice.class,
          ProxyModifyInvoiceAdjustment.class,
          ProxyModifyInvoicePayment.class,
          ProxyModifyPayment.class,
          ProxyModifyPaymentMethod.class,
          ProxyModifyProduct.class,
          ProxyModifyProductRatePlan.class,
          ProxyModifyProductRatePlanCharge.class,
          ProxyModifyProductRatePlanChargeTier.class,
          ProxyModifyRatePlanCharge.class,
          ProxyModifyRefund.class,
          ProxyModifySubscription.class,
          ProxyModifyTaxationItem.class,
          ProxyModifyUnitOfMeasure.class,
          ProxyModifyUsage.class,
          ProxyNoDataResponseRecordsItem.class,
          ProxyNoDataResponse.class,
          ProxyPostImport.class,
          ProxyUnauthorizedResponse.class,
          PutBatchInvoiceType.class,
          PutCreditMemoTaxItemTypeFinanceInformationItem.class,
          PutCreditMemoTaxItemType.class,
          PutDebitMemoTaxItemTypeFinanceInformationItem.class,
          PutDebitMemoTaxItemType.class,
          PutEventTriggerRequestEventTypeItem.class,
          PutEventTriggerRequest.class,
          PutInvoiceResponseType.class,
          PutInvoiceType.class,
          PutReverseInvoiceResponseTypeCreditMemoItem.class,
          PutReverseInvoiceType.class,
          PutTasksRequest.class,
          QueryCustomObjectRecordsResponse.class,
          QueryUsageResponseType.class,
          RatePlan.class,
          RatePlanChargeData.class,
          RatePlanChargeDataInRatePlanDataRatePlanChargeItem.class,
          RatePlanChargeDataInRatePlanData.class,
          RatePlanChargeDataRatePlanCharge.class,
          RatePlanChargeObjectCustomFields.class,
          RatePlanChargeTier.class,
          RatePlanDataSubscriptionProductFeatureListItem.class,
          RatePlanData.class,
          RatePlanDataRatePlan.class,
          RatePlanObjectCustomFields.class,
          RatePlanOverride.class,
          RatePlanOverrideForEvergreen.class,
          RatePlanUpdate.class,
          RatePlanUpdateForEvergreen.class,
          RatedItem.class,
          RecurringFlatFeePricingOverride.class,
          RecurringFlatFeePricingUpdate.class,
          RecurringPerUnitPricingOverride.class,
          RecurringPerUnitPricingUpdate.class,
          RecurringTieredPricingOverride.class,
          RecurringTieredPricingUpdate.class,
          RecurringVolumePricingOverride.class,
          RecurringVolumePricingUpdate.class,
          RefundCreditMemoItemType.class,
          RefundInvoicePayment.class,
          RefundObjectCustomFields.class,
          RefundObjectNSFields.class,
          RefundPartResponseType.class,
          RefundPartResponseTypewithSuccess.class,
          RemoveProduct.class,
          RenewalTerm.class,
          RevenueEventItemObjectCustomFields.class,
          RevenueEventObjectCustomFields.class,
          RevenueScheduleItemObjectCustomFields.class,
          RevenueScheduleItemType.class,
          RevenueScheduleObjectCustomFields.class,
          SaveResult.class,
          SettingItemHttpOperationRequestTypeItem.class,
          SettingItemHttpOperationResponseTypeItem.class,
          SettingItemHttpOperation.class,
          SettingItemHttpRequestParameter.class,
          SettingItemWithOperationsInformation.class,
          SettingValueRequest.class,
          SettingValueResponseErrorMessagesItem.class,
          SettingValueResponse.class,
          SettingValueResponseWrapper.class,
          SettingsBatchRequest.class,
          SettingsBatchResponse.class,
          SoldToContact.class,
          SoldToContactPostOrder.class,
          SubmitDataQueryRequestOutputItem.class,
          SubmitDataQueryRequest.class,
          SubmitDataQueryResponse.class,
          SubscribeRequestPaymentMethodItemGatewayOptionDataItem.class,
          SubscribeRequestPaymentMethodItem.class,
          SubscribeRequestPreviewOptionsItem.class,
          SubscribeRequestSubscribeOptionsItemElectronicPaymentOptionsItem.class,
          SubscribeRequestSubscribeOptionsItemExternalPaymentOptionsItem.class,
          SubscribeRequestSubscribeOptionsItemSubscribeInvoiceProcessingOptionsItem.class,
          SubscribeRequestSubscribeOptionsItem.class,
          SubscribeRequestSubscriptionDataItem.class,
          SubscribeRequest.class,
          SubscribeRequestAccount.class,
          SubscribeRequestBillToContact.class,
          SubscribeRequestSoldToContact.class,
          SubscribeRequestSubscriptionDataSubscription.class,
          SubscribeResultChargeMetricsDataItem.class,
          SubscribeResultInvoiceResultItemInvoiceItem.class,
          SubscribeResultInvoiceResultItem.class,
          SubscribeResult.class,
          SubscriptionObjectCustomFields.class,
          SubscriptionObjectNSFields.class,
          SubscriptionObjectQTFields.class,
          SubscriptionProductFeature.class,
          SubscriptionProductFeatureList.class,
          SubscriptionProductFeatureObjectCustomFields.class,
          SubscriptionRatedResult.class,
          TaskDataItem.class,
          TaskParametersItem.class,
          TaskTagsItem.class,
          Task.class,
          TasksResponsePaginationItem.class,
          TasksResponse.class,
          TaxInfo.class,
          TaxationItemObjectCustomFields.class,
          Term.class,
          TermsAndConditions.class,
          TimeSlicedElpNetMetrics.class,
          TimeSlicedMetrics.class,
          TimeSlicedMetricsForEvergreen.class,
          TimeSlicedNetMetrics.class,
          TimeSlicedNetMetricsForEvergreen.class,
          TimeSlicedTcbNetMetrics.class,
          TimeSlicedTcbNetMetricsForEvergreen.class,
          TransferPaymentType.class,
          TriggerDate.class,
          TriggerParams.class,
          UnapplyCreditMemoType.class,
          UnapplyPaymentType.class,
          UpdateCustomFieldsDefinitionRequestNoNamespace.class,
          UpdateCustomObjectCusotmFieldDefinitionItem.class,
          UpdateCustomObjectCusotmField.class,
          UpdateEntityResponseType.class,
          UpdateEntityType.class,
          UpdatePaymentTypeFinanceInformationItem.class,
          UpdatePaymentType.class,
          UpdateTaskTagsItem.class,
          UpdateTask.class,
          UsageFlatFeePricingOverride.class,
          UsageFlatFeePricingUpdate.class,
          UsageImport.class,
          UsageImports.class,
          UsageObjectCustomFields.class,
          UsageOveragePricingOverride.class,
          UsageOveragePricingUpdate.class,
          UsagePerUnitPricingOverride.class,
          UsagePerUnitPricingUpdate.class,
          UsageTieredPricingOverride.class,
          UsageTieredPricingUpdate.class,
          UsageTieredWithOveragePricingOverride.class,
          UsageTieredWithOveragePricingUpdate.class,
          UsageVolumePricingOverride.class,
          UsageVolumePricingUpdate.class,
          Workflow.class,
          WorkflowError.class,
          WorkflowInstance.class,
          CreditCard.class,
          OrderMetric.class,
          TokenResponse.class,
          ZObject.class,
          ZObject_updateFieldsToNullItem.class,
          ZObject_update.class);

  public static List<Class> getObjectClasses() {
    return objects;
  }
}
