package com.bridge.sme.dto;

import lombok.Data;
import java.util.Map;

@Data
public class Email {
    String[] to;
    String from;
    String subject;
    String text;
    String template;
    Map<String, Object> properties;
}