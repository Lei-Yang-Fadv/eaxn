package com.eaxn.web;

import java.util.UUID;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaxn.jms.EmitEaxnCdc;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;

/**
 * @author Lei Yang
 *
 */
@RestController
@RequestMapping("/eax-notifications/cdc")
@AllArgsConstructor
public class CdcNotificationController implements Consumer<JsonNode> {
    private final static Logger LOGGER = LogManager.getLogger();

    private final EmitEaxnCdc emitter;

    @Override
    public void accept(@RequestBody final JsonNode payload) {
        final var id = UUID.randomUUID().toString();
        emitter.cdcNotification(id, payload);

        LOGGER.atTrace().log("Emitted {}", id);
    }

}
