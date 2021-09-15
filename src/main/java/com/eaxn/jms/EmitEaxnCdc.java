package com.eaxn.jms;

import com.fasterxml.jackson.databind.JsonNode;

import me.ehp246.aufjms.api.annotation.At;
import me.ehp246.aufjms.api.annotation.ByJms;
import me.ehp246.aufjms.api.annotation.OfCorrelationId;

/**
 * @author Lei Yang
 *
 */
@ByJms(@At("${xtdforce.eaxntransfer.jms.destination.eaxnInbox}"))
public interface EmitEaxnCdc {
    void cdcNotification(@OfCorrelationId String id, JsonNode casePayload);
}