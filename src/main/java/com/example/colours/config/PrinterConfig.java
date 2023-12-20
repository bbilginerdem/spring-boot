package com.example.colours.config;

import com.example.colours.services.BluePrinter;
import com.example.colours.services.ColourPrinter;
import com.example.colours.services.GreenPrinter;
import com.example.colours.services.RedPrinter;
import com.example.colours.services.impl.ColourPrinterImpl;
import com.example.colours.services.impl.EnglishBluePrinter;
import com.example.colours.services.impl.EnglishGreenPrinter;
import com.example.colours.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class PrinterConfig {

  @Bean
  public BluePrinter bluePrinter() {
    return new EnglishBluePrinter();
  }

  @Bean
  public RedPrinter redPrinter() {
    return new EnglishRedPrinter();
  }

  @Bean
  public GreenPrinter greenPrinter() {
    return new EnglishGreenPrinter();
  }

  @Bean
  public ColourPrinter colourPrinter(
      BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
    return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
  }
}
