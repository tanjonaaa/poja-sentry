package com.poja.sentry.endpoint.rest.controller.health;

import com.poja.sentry.PojaGenerated;
import com.poja.sentry.repository.DummyRepository;
import com.poja.sentry.repository.DummyUuidRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.sentry.Sentry;

@PojaGenerated
@RestController
@AllArgsConstructor
public class PingController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;

  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/ping")
  public String ping() {

    try {
      throw new Exception("Preprod execption");
    } catch (Exception e) {
      Sentry.captureException(e);
    }



    return "pong "+System.getenv("SENTRY_DSN")+" "+System.getenv("SENTRY_ENVIRONMENT");

  }
}
