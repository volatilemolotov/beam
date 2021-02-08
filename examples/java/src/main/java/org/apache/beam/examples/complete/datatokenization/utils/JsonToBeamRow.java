package org.apache.beam.examples.complete.datatokenization.utils;

import static org.apache.beam.examples.complete.datatokenization.DataTokenization.FAILSAFE_ELEMENT_CODER;

import org.apache.beam.examples.complete.datatokenization.options.DataTokenizationOptions;
import org.apache.beam.sdk.transforms.JsonToRow;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;

/**
 * The {@link JsonToBeamRow} converts jsons string to beam rows.
 */
public class JsonToBeamRow extends PTransform<PCollection<String>, PCollection<Row>> {

  final DataTokenizationOptions options;
  final SchemasUtils schema;

  public JsonToBeamRow(DataTokenizationOptions options, SchemasUtils schema) {
    this.options = options;
    this.schema = schema;
  }

  @Override
  @SuppressWarnings({"argument.type.incompatible"})
  public PCollection<Row> expand(PCollection<String> jsons) {
    JsonToRow.ParseResult rows = jsons
        .apply("JsonToRow",
            JsonToRow.withExceptionReporting(schema.getBeamSchema()).withExtendedErrorInfo());

    if (options.getNonTokenizedDeadLetterPath() != null) {
      /*
       * Write Row conversion errors to filesystem specified path
       */
      rows.getFailedToParseLines()
          .apply("ToFailsafeElement",
              MapElements.into(FAILSAFE_ELEMENT_CODER.getEncodedTypeDescriptor())
                  .via((Row errRow) -> FailsafeElement
                      .of(errRow.getString("line"), errRow.getString("line"))
                      .setErrorMessage(errRow.getString("err"))
                  ))
          .apply("WriteCsvConversionErrorsToGcs",
              ErrorConverters.WriteStringMessageErrorsAsCsv.newBuilder()
                  .setCsvDelimiter(options.getCsvDelimiter())
                  .setErrorWritePath(options.getNonTokenizedDeadLetterPath())
                  .build());
    }
    return rows.getResults().setRowSchema(schema.getBeamSchema());
  }
}
