package com.eaxn.web;

import java.util.UUID;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaxn.jms.EmitEaxnCase;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;

/**
 * @author Lei Yang
 *
 */

@RestController
@RequestMapping("/eax-notifications/case")
@AllArgsConstructor
public class CaseNotificationController implements Consumer<JsonNode> {
    private final static Logger LOGGER = LogManager.getLogger();

    private final EmitEaxnCase emitter;

    @PostMapping
    @Override
    public void accept(@RequestBody JsonNode payload) {
        final var id = UUID.randomUUID().toString();
        emitter.caseNotification(id, payload);

        LOGGER.atTrace().log("Emitted {}", id);
    }
}
